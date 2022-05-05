package com.simona.project1.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderRowMapper implements RowMapper {
    @Override
    /**
     * Mapeaza clasa order pe tabelul din baza de date cu acelasi nume
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order(); // Obj of User, and mapping DB elements.
        order.setId_order(rs.getInt("id_order"));
        order.setTotal_price(rs.getDouble("total_price"));
        order.setOrder_number(rs.getInt("order_number"));
        order.setId_product(rs.getInt("id_product"));
        order.setEmail_client(rs.getString("email_client"));
        return order;
    }
}
