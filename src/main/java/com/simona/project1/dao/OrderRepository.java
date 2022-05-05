package com.simona.project1.dao;

import com.simona.project1.model.Order;
import com.simona.project1.model.OrderRowMapper;
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
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> getOrder() {
        return jdbcTemplate.query("select id_order, total_price , order_number, id_product, email_client  from projectps.order", new OrderRowMapper());
    }

    public Order findById(Integer id) {
        String sql = "SELECT * FROM projectps.order WHERE ID_ORDER = ?";
        try{
            return  (Order) this.jdbcTemplate.queryForObject(sql, new Object[] {id}, new OrderRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    public Boolean saveOrder(  Order order){
        String query="insert into projectps.order values(?,?,?,?,?)";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,order.getId_order());
                ps.setDouble(2, order.getTotal_price());
                ps.setInt(3,order.getOrder_number());
                ps.setInt(4,order.getId_product());
                ps.setString(5,order.getEmail_client());
                return ps.execute();
            }
        });

    }

    public Integer updateOrder( Order order){
        String query="update projectps.order set total_price = ? , order_number = ? , id_prodct = ? , email_client = ?  where id_order = ?";
        Object[] params = { order.getTotal_price(), order.getOrder_number(), order.getId_product(),  order.getEmail_client(), order.getId_order()};
        int[] types = {Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteOrderById(Integer id){
        return jdbcTemplate.update("delete from projectps.order where id_order = ?",id);
    }

    public Integer findMaxOrderNumber(){
        String query = "select max(order_number) from projectps.order";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public Integer findMaxId(){
        String query = "select max(id_order) from projectps.order";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }


}
