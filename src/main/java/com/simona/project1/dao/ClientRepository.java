package com.simona.project1.dao;

import com.simona.project1.model.Client;
import com.simona.project1.model.ClientRowMapper;
import com.simona.project1.model.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  List<Client> getClient() {
        return jdbcTemplate.query("select id_client,name,email,phone_number  from projectps.client", new ClientRowMapper());
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

    public  Client findByNameEmailPhone(String name, String email,  String phone_number) {
        String sql = "SELECT * FROM projectps.client WHERE name = ? and email = ? and phone_number=?";
        try{
            return  (Client) this.jdbcTemplate.queryForObject(sql, new Object[] {name, email,phone_number}, new ClientRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public  Boolean saveClient( Client client){
        String query="insert into projectps.client values(?,?,?,?)";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,client.getId_client());
                ps.setString(2, client.getName());
                ps.setString(3, client.getEmail());
                ps.setString(4, client.getPhone_number());
                return ps.execute();
            }
        });
    }

    public  Integer updateClient( Client client){
        String query="update projectps.client set name = ? , email = ?, phone_number = ?  where id_client = ?";
        Object[] params = { client.getName(), client.getEmail(), client.getPhone_number(), client.getId_client()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }


    public Integer deleteClientById(Integer id){
        return jdbcTemplate.update("delete from projectps.client where id_client = ?",id);
    }

    public Integer findMaxId(){
        String query = "select max(id_client) from projectps.client";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
}
