package org.Tema11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RelationManager {

    private final Connection conn;

    public RelationManager(Connection conn) {
        this.conn = conn;
    }

    public void insertRelation(int accommodationId, int roomFairId) throws SQLException {
        String sql = "INSERT INTO accommodation_room_fair_relation (accommodation_id, room_fair_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, accommodationId);
            stmt.setInt(2, roomFairId);
            stmt.executeUpdate();

        }
    }
}
