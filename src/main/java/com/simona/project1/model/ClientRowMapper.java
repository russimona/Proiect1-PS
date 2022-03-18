package com.simona.project1.model;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper {

    /**
     * Mapeaza clasa client pe tabelul din baza de date cu acelasi nume
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client(); // Obj of User, and mapping DB elements.
        client.setId_client(rs.getInt("id_client"));
        client.setName(rs.getString("name"));
        client.setEmail(rs.getString("email"));
        client.setPhone_number(rs.getString("phone_number"));
        return client;
    }

}
