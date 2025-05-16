package org.Tema11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomFairManager {

    private final Connection conn;

    public RoomFairManager(Connection conn) {
        this.conn = conn;
    }

    public int insertRoomFair(double value, String season) throws SQLException {
        String sql = "INSERT INTO room_fair (value, season) VALUES (?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, value);
            stmt.setString(2, season);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);

        }
        return -1;
    }

}
