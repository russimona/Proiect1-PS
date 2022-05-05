package com.simona.project1.dao;

import com.simona.project1.model.Order;
import com.simona.project1.model.OrderRowMapper;
import com.simona.project1.model.user.Client;
import com.simona.project1.model.user.ClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  List<Client> getClients() {

        List<Client> clients = jdbcTemplate.query("select *  from projectps.user ", new ClientRowMapper());
        if(clients.isEmpty()){
            return null;
        }else{
            clients = clients.stream().filter(client -> client.type != null).filter(client -> client.type.equals("CLIENT")).collect(Collectors.toList());
            return clients;
        }
    }


    public boolean login(String username, String password){
        List<Client> clients = jdbcTemplate.query("select name, email , phone_number, type, password  from projectps.user", new ClientRowMapper());

        if(clients == null) return false;
        for(Client c : clients){
            //System.out.println(c.getPassword()+" "+c.getEmail());
            if(c.getPassword().equals(password) && c.getEmail().equals(username)){
                return true;
            }
        }

        return false;
    }

    public Client findById(Integer id) {
        String sql = "SELECT * FROM projectps.client WHERE ID_Client = ?";
        try{
            return  (Client) this.jdbcTemplate.queryForObject(sql, new Object[] {id}, new ClientRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    public  Client findByNameEmailPhone(String email) {
        String sql = "SELECT * FROM projectps.user WHERE email = ?";
        try{
            return  (Client) this.jdbcTemplate.queryForObject(sql, new String[]{email}, new ClientRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    public  Boolean saveClient( Client client){
        String query="insert into projectps.user values(?,?,?,?, ?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, client.getNume());
                ps.setString(2, client.getEmail());
                ps.setString(3, client.getPhone_number());
                ps.setString(4, "CLIENT");
                ps.setString(5, client.getPassword());
                return ps.execute();
            }
        });
    }

    public Integer deleteUserByEmail(String email){
        return jdbcTemplate.update("delete from projectps.user where email = ?",email);
    }


}
