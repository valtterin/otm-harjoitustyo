
package muistipeli.ui;
import muistipeli.database.*;
import muistipeli.ui.MuistipeliUi;
import java.sql.*;


public class Main extends MuistipeliUi {

    
    public static void main(String[] args) throws Exception {
                       
        Database database = new Database("jdbc:sqlite:scores.db");
        
        launch(MuistipeliUi.class);
    }
    
    
    
}