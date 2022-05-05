package com.simona.project1.model.user;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminRowMapper implements RowMapper {
    @Override
    /**
     * Mapeaza clasa order pe tabelul din baza de date cu acelasi nume
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();
        admin.setEmail(rs.getString("email"));
        admin.setNume(rs.getString("name"));
        admin.setPhone_number(rs.getString("phone_number"));
        admin.setType(rs.getString("type"));
        admin.setType(rs.getString("password"));
        return admin;
    }
}
