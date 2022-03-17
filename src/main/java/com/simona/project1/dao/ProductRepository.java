package com.simona.project1.dao;

import com.simona.project1.model.Product;
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
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Product> getProducts() {
        return jdbcTemplate.query("select id_product,name,price,stoc , category  from projectps.product", new ProductRowMapper());
    }


    public Product findById(Integer id) {
        String sql = "SELECT * FROM projectps.product WHERE ID_PRODUCT = ?";
        try{
            return  (Product) this.jdbcTemplate.queryForObject(sql, new Object[] {id}, new ProductRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public  Boolean saveProduct( Product product){
        String query="insert into projectps.product values(?,?,?,?,?)";

        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1,product.getId_product());
                ps.setString(2, product.getName());
                ps.setDouble(3,product.getPrice());
                ps.setInt(4,product.getStoc());
                ps.setString(5,product.getCategory());
                return ps.execute();
            }
        });
    }

    public void updateProduct( Product product){
        String query="update projectps.product set name = ? , price = ? , stoc = ? , category = ?  where id_product = ?";
        Object[] params = { product.getName(), product.getPrice(),product.getStoc(),product.getCategory(), product.getId_product()};
        int[] types = {Types.VARCHAR, Types.DOUBLE,Types.INTEGER,Types.VARCHAR,Types.INTEGER};

        jdbcTemplate.update(query, params, types);
    }

    public Integer deleteProductById(Integer id){
        return jdbcTemplate.update("delete from projectps.product where id_product = ?",id);
    }

    public Integer findMaxId(){
        String query = "select max(id_product) from projectps.product";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }


    public List<Product> getProductsAvailable() {
        return jdbcTemplate.query("select id_product,name,price,stoc , category  from product where stoc>0", new ProductRowMapper());
    }

}
