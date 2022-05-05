package com.simona.project1.model.user;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VizitatorRowMapper implements RowMapper {
    @Override
    /**
     * Mapeaza clasa order pe tabelul din baza de date cu acelasi nume
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    public Vizitator mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vizitator vizitator = new Vizitator();
        vizitator.setEmail(rs.getString("email"));
        vizitator.setNume(rs.getString("name"));
        vizitator.setPhone_number(rs.getString("phone_number"));
        vizitator.setType(rs.getString("type"));
        return vizitator;
    }
}
