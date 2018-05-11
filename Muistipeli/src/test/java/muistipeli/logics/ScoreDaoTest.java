
package muistipeli.logics;

import java.sql.SQLException;
import muistipeli.database.Database;
import muistipeli.database.Score;
import muistipeli.database.ScoreDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreDaoTest {
    
    
    Database database;
    ScoreDao scoredao;
    Score test1Score;
    
    @Before
    public void setUp() throws Exception  {
        database = new Database("jdbc:sqlite:scores.db");
        database.deleteAll();
        scoredao = new ScoreDao(database);
        test1Score = new Score("Juha", 15, "Reverse");
        try {
            scoredao.saveScore(test1Score);
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }

    
    // testaa että ensimmäinen numero/symboli on legit
    @Test
    public void currentSymbolWorks() {
        test1Score = new Score("Timo", 30, "Reverse");
        try {
            scoredao.saveScore(test1Score);
        } catch (SQLException ex) {
            System.out.println("error");
        }
        assertTrue(1 <= this.newround.currentSymbol() && this.newround.currentSymbol() <= 4);
    }
    
    
    
}
