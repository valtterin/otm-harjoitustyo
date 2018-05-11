
package muistipeli.ui;
import muistipeli.database.*;
import muistipeli.ui.MuistipeliUi;
import java.sql.*;


public class Main extends MuistipeliUi {

    
    public static void main(String[] args) throws Exception {
                       
        Database database = new Database("jdbc:sqlite:scores.db");
        ScoreDao scoredao = new ScoreDao(database);
        Score test1Score = new Score("Juha", 15, "Reverse");  // miten handlataan, jos input ei legit, varmaan ui:n puolella?
        
        System.out.println("1");
        
        try {
            scoredao.saveScore(test1Score);
        } catch (SQLException ex) {
            System.out.println("error");
        }
        
        System.out.println("1");
        
        Score test2Score = new Score("Esa", 30, "Reverse");  // miten handlataan, jos input ei legit, varmaan ui:n puolella?
        
        try {
            scoredao.saveScore(test2Score);
        } catch (SQLException ex) {
            System.out.println("error");
        }
        
        System.out.println("1");
        
        Score test3Score = new Score("Ilona", 31, "Reverse");  // miten handlataan, jos input ei legit, varmaan ui:n puolella?
        
        try {
            scoredao.saveScore(test3Score);
        } catch (SQLException ex) {
            System.out.println("error");
        }
        
        System.out.println("1");
        
        Score test1 = scoredao.bestScore("Reverse");
        System.out.println(test1.getPlayerName());
        
        
        launch(MuistipeliUi.class);
    }
    
    
    
}