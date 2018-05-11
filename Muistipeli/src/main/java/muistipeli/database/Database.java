

package muistipeli.database;

import java.sql.*;


public class Database {
    private String databaseAddress;

    public Database(String address) throws ClassNotFoundException {
//        try (Connection conn = DriverManager.getConnection("jdbc:sqlite")) {
//            Statement statement = conn.createStatement();
//            statement.executeUpdate("CREATE DATABASE scores");
//        } catch (Throwable t) {
//            System.out.println("Virhe: " + t.getMessage());
//        }
        this.databaseAddress = address;
        this.init();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
    private void init() {
        try (Connection conn = getConnection()) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Scores(id integer PRIMARY KEY, nickname varchar(200), score integer(20), gamemode varchar(200))");
            // statement.executeUpdate("CREATE TABLE IF NOT EXISTS Scores(id integer PRIMARY KEY, nickname varchar(200), score integer(20), gamemode varchar(200), startingRound integer(20), symbolDelay integer(20), infoDelay integer(20))");
        } catch (Throwable t) {
            System.out.println("Virhe: " + t.getMessage());
        }
    }

}
