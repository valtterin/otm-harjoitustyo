
package muistipeli.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ScoreDao implements Dao<Score, Integer> {
    private Database database;
    
    public ScoreDao(Database database) {
        this.database = database;
    }

    
    /**
    *
    * Palauttaa kaikki parametrina annetun gamemoden pisteet tietokannasta.
    * 
    */
    
    public List<Score> allModeScores(String gamemode) throws SQLException {
        List<Score> scores = new ArrayList<>();
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM scores WHERE gamemode = ?");
        statement.setString(1, gamemode);

        ResultSet results = statement.executeQuery();
        
        while (results.next()) {
            String nick = results.getString("nickname");
            int score = results.getInt("score");
            String mode = results.getString("gamemode");
            scores.add(new Score(nick, score, mode));   
        }
        results.close();

        return scores;
    }
    
    
    
    
    /**
    *
    * Palauttaa parhaan tuloksen parametrina annetusta gamemodesta.
    * 
    */
    @Override
    public Score bestScore(String gamemode) throws SQLException {
        Connection connection = database.getConnection();
        List<Score> scores = this.allModeScores(gamemode);
        
        if (scores.isEmpty()) {
            return new Score("-null-", 0, gamemode);
        }
        
        Score topScore = scores.get(0);
        int i = 0;
        
        while (i < scores.size()) {
            if (scores.get(i).getScore() > topScore.getScore()) {
                topScore = scores.get(i);
            }
            i++;
        }

        return topScore;
    }

    
    /**
    *
    * Tallentaa parametrina annetun scoren tietokantaan
    */
    @Override
    public boolean saveScore(Score score) throws SQLException {
        Connection connection = database.getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO scores (nickname, score, gamemode) VALUES (?,?,?)");

        statement.setString(1, score.getPlayerName());
        statement.setInt(2, score.getScore());
        statement.setString(3, score.getGamemode());
        statement.executeUpdate();  
                
        connection.close();    
        return true;
    }
    
    
    
    

}
