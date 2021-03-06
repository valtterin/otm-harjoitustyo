

package muistipeli.database;

import java.sql.*;


public class Database {
    private String databaseAddress;

    public Database(String address) throws ClassNotFoundException {
        this.databaseAddress = address;
        this.init();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
    public void init() {
        try (Connection conn = getConnection()) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Scores(id integer PRIMARY KEY, nickname varchar(200), score integer(20), gamemode varchar(200))");
        } catch (Throwable t) {
            System.out.println("Virhe: " + t.getMessage());
        }
    }
    
    public void deleteAll() throws SQLException {
        Connection connection = this.getConnection();
        PreparedStatement statement = connection.prepareStatement("DROP TABLE scores");
        statement.executeUpdate();      
        connection.close();    
        this.init();

    }

}
