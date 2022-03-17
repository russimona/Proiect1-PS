package com.simona.project1.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product(); // Obj of User, and mapping DB elements.
        product.setId_product(rs.getInt("id_product"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setStoc(rs.getInt("stoc"));
        product.setCategory(rs.getString("category"));

        return product;
    }

}