package org.Tema11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccomodationManager {

    private final Connection conn;

    public AccomodationManager(Connection conn) {
        this.conn = conn;
    }

    public int insertAccommodation(String type, String bedType, int maxGuests, String description) throws SQLException {
        String sql = "INSERT INTO accommodation (type, bed_type, max_guests, description) " +
                "VALUES (?, ?, ?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, type);
            stmt.setString(2, bedType);
            stmt.setInt(3, maxGuests);
            stmt.setString(4, description);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }
}
