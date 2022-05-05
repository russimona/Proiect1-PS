package com.simona.project1.model.user;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClientRowMapper implements RowMapper {
    @Override
    /**
     * Mapeaza clasa order pe tabelul din baza de date cu acelasi nume
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setEmail(rs.getString("email"));
        client.setNume(rs.getString("name"));
        client.setPhone_number(rs.getString("phone_number"));
        client.setType(rs.getString("type"));
        client.setPassword(rs.getString("password"));
        return client;
    }
}
