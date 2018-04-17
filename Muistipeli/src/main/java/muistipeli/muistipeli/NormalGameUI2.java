package muistipeli.muistipeli;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NormalGameUI2 extends Application{
    
    private NormalGame normalgame;
    private Scene symbolsScene;
    private Scene buttonsScene;
    private Scene newgameScene;   
    private HBox newgameButton;
    private BorderPane newgamePane;
    
    
    @Override
    public void start(Stage ikkuna) {
        newgameButton = new HBox();
	newgameButton.setSpacing(10);
        
        
        
//        Button button1 = new Button("Yksi");
//        button1.setOnAction((event) -> {
//            System.out.println("Vastasit: 1");
//            testi.compareAnswer(1);
//            testi.gameStatus();
//        });
        
        
        Button newgame1 = new Button("New Game");
        newgame1.setOnAction((event) -> {
            this.launchGame(ikkuna);
        });

        newgameButton.getChildren().add(newgame1);
        
        
        
        

        newgameScene = new Scene(newgamePane);

        ikkuna.setScene(newgameScene);
        ikkuna.show();
        
    }    
        // kun "New Game" tai "Normal Game" painiketta painetaan
    public void launchGame() {
        this.normalgame = new NormalGame();
        // set scene from New Game -scene to ShowSymbols -scene
        this.showSymbolsScene();
        // set scene painikkeet
        // this.buttonsScene(); 
        // odotetaan käyttäjän inputtia
    }
    
    public void showSymbolsScene() {
        // includes just a box where to print all the symbols, before that round number and "get ready!)
        
//        newgamePane = new BorderPane();
//        newgamePane.setCenter(new Label("plaa"));
//        symbolsScene = new Scene(newgamePane);
//        ikkuna.setScene(symbolsScene);
        
        System.out.println("Kierros: " + this.normalgame.getRoundNumber());
        System.out.println("Valmistaudu!");
        
        // haetaan symbolit       
        while(true) {
            // printtaa ruudulle haetun mukaisen symbolin, toisin sanoen vaihtaa laatikon väriä (ehkä olisi mukavampi jos olisi värillinen ja jonkin muotoinen)
            // pitääkö jokaisella värillä olla erillinen scene? vai miten vanhaa sceneä updatetaan?
            int print = this.normalgame.nextSymbol();
            if (print > 0) {
                System.out.println(print);
            } else {   // jos print on nolla, niin hypätään seuraavaan vaiheeseen
                System.out.println("Paina painikkeita juuri näkemässäsi järjestyksessä!");
                break;
            }
        }
        
        
            
    }
    
    public void buttonsScene() {
        // painikkeet scene pitää sisällään neljä painiketta, boksin johon printataan ohjeita, ja scoren, ja kierroksen numeron
        
        // aluksi riittää vain ne neljä painiketta
        // yhden painikkeen funktionaalisuus:
        
        
        // yksi painike:
//        if (this.normalgame.compareAnswer(buttonNumber)) {
//            updates score to getScore()
//            if (this.normalgame.nextRound()) {
//                this.showSymbolsScene();
//                this.buttonsScene(); 
//            }
//        } else {
//            call method gameOver: change scene to game over, score: getScore,  new game?
//        }
//	   meneekö tässä ristiin: tämän napin funktionaalisuus ladataan uudestaan, vaikka ollaan vielä toteuttamassa tämän napin koodia?   
// buttons could have their own method too, this.buttonFunction(int buttonNumber

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
