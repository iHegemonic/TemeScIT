package org.Tema11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingApp {

    public void run() {


        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();

        Connection conn = dbManager.getConn();

        AccomodationManager accomodationManager = new AccomodationManager(conn);
        RoomFairManager roomFairManager = new RoomFairManager(conn);
        RelationManager relationManager = new RelationManager(conn);


        try {
            int acc1 = accomodationManager.insertAccommodation("Singe", "King", 2,
                    "Cozy room with king size bed");
            int fair1 = roomFairManager.insertRoomFair(100, "summer");
            relationManager.insertRelation(acc1, fair1);

            int acc2 = accomodationManager.insertAccommodation("Double", "Standard, double", 2,
                    "Basic room with a double bed");
            int fair2 = roomFairManager.insertRoomFair(80, "All seasons");
            relationManager.insertRelation(acc2, fair2);

            printRoomPrices(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.disconnect();
        }
    }

    private void printRoomPrices(Connection conn) {
        String query = """
                SELECT a.type, a.bed_type, a.max_guests, a.description, rf.value, rf.season
                FROM accommodation a
                JOIN accommodation_room_fair_relation arfr ON a.id = arfr.accommodation_id
                JOIN room_fair rf ON rf.id = arfr.room_fair_id
                """;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.printf("Type: %s | Bed: %s | Guests: %d | Desc: %s | Price: %.2f | Season: %s%n",
                       rs.getString("type"),
                       rs.getString("bed_type"),
                       rs.getInt("max_guests"),
                       rs.getString("description"),
                       rs.getDouble("value"),
                       rs.getString("season")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
