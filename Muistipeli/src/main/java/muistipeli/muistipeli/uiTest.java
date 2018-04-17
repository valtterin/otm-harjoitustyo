package muistipeli.muistipeli;
// import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Platform;


public class uiTest extends Application {
    
    NormalGame normalgame = new NormalGame();
    Label score = new Label ("Pisteet: ");
    Scene newGameScene;
    Scene showSymbolsScene;
    Scene guessScene;
    Scene endGameScene;
    Scene symbolOneScene;
    Scene symbolTwoScene;
    Scene symbolThreeScene;
    Scene symbolFourScene;
    Label scoring;
    BorderPane askSymbolsPane;
    int delay;
    
    
    public void showSymbols() {
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
        
    @Override
    public void start(Stage primaryStage) {
        
        
        // symbol one-four scenes
        
        BorderPane symbolOnePane = new BorderPane();
        symbolOnePane.setCenter(new Label("1"));
        symbolOneScene = new Scene(symbolOnePane);
        
        BorderPane symbolTwoPane = new BorderPane();
        symbolTwoPane.setCenter(new Label("2"));
        symbolTwoScene = new Scene(symbolTwoPane);
        
        BorderPane symbolThreePane = new BorderPane();
        symbolThreePane.setCenter(new Label("3"));
        symbolThreeScene = new Scene(symbolThreePane);
        
        BorderPane symbolFourPane = new BorderPane();
        symbolFourPane.setCenter(new Label("4"));
        symbolFourScene = new Scene(symbolFourPane);
        
        
        
        // newGameScene defined & atm endGameScene
        BorderPane newGamePane = new BorderPane();
        HBox newGameButtonBox = new HBox();
        
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction((event) -> {
            normalgame = new NormalGame();
            primaryStage.setScene(showSymbolsScene);
            
            
            System.out.println("Kierros: " + this.normalgame.getRoundNumber());
            System.out.println("Valmistaudu!");
            
            delay = 0;

            // haetaan symbolit       
            while(true) {
                // printtaa ruudulle haetun mukaisen symbolin, toisin sanoen vaihtaa laatikon väriä (ehkä olisi mukavampi jos olisi värillinen ja jonkin muotoinen)
                // pitääkö jokaisella värillä olla erillinen scene? vai miten vanhaa sceneä updatetaan?
                int print = this.normalgame.nextSymbol();
                
                
                if (print > 0) {
                    System.out.println(print);
                    if (print == 1) {
                        Thread thread1 = new Thread(() -> {
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException exc) {
                                throw new Error("Unexpected interruption", exc);
                            }
                            Platform.runLater(() -> primaryStage.setScene(symbolOneScene));
                        });
                        thread1.setDaemon(true);
                        thread1.start();
                        // primaryStage.setScene(symbolOneScene);
                    }
                    if (print == 2) {
                        Thread thread2 = new Thread(() -> {
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException exc) {
                                throw new Error("Unexpected interruption", exc);
                            }
                            Platform.runLater(() -> primaryStage.setScene(symbolTwoScene));
                        });
                        thread2.setDaemon(true);
                        thread2.start();
                        // primaryStage.setScene(symbolTwoScene);
                    }
                    if (print == 3) {
                        Thread thread3 = new Thread(() -> {
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException exc) {
                                throw new Error("Unexpected interruption", exc);
                            }
                            Platform.runLater(() -> primaryStage.setScene(symbolThreeScene));
                        });
                        thread3.setDaemon(true);
                        thread3.start();
                        // primaryStage.setScene(symbolThreeScene);
                    }
                    if (print == 4) {
                        Thread thread4 = new Thread(() -> {
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException exc) {
                                throw new Error("Unexpected interruption", exc);
                            }
                            Platform.runLater(() -> primaryStage.setScene(symbolFourScene));
                        });
                        thread4.setDaemon(true);
                        thread4.start();
                        // primaryStage.setScene(symbolFourScene);
                    }

                } else {   // jos print on nolla, niin hypätään seuraavaan vaiheeseen
                    System.out.println("Paina painikkeita juuri näkemässäsi järjestyksessä!");
                    delay = delay + 2000;
                    break;
                }
                
                delay = delay + 2000;
            }
            
            Thread thread5 = new Thread(() -> {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException exc) {
                    throw new Error("Unexpected interruption", exc);
                }
                Platform.runLater(() -> primaryStage.setScene(guessScene));
            });
            thread5.setDaemon(true);
            thread5.start();
            // primaryStage.setScene(guessScene);
        });
        
        newGameButtonBox.getChildren().add(newGameButton);
        newGamePane.setCenter(newGameButtonBox);
        newGameScene = new Scene(newGamePane);
//        endGameScene = new Scene(newGamePane);
        
        
        // showSymbolsScene defined
        
        BorderPane showSymbolsPane = new BorderPane();
        HBox showSymbolsBox = new HBox();
        
        showSymbolsBox.getChildren().add(new Label("Symboleita tulossa!"));
        showSymbolsPane.setCenter(showSymbolsBox);
        showSymbolsScene = new Scene(showSymbolsPane);
        
        
        
        // guessScene defined
        
        
        HBox bottomButtons = new HBox();
	bottomButtons.setSpacing(10);
        
        scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
        
        
        Button button1 = new Button("Yksi");
        button1.setOnAction((event) -> {
            System.out.println("Vastasit: 1");
            if (normalgame.compareAnswer(1)) {
                System.out.println("Oikein!");
                if (normalgame.nextRound()) {
                    primaryStage.setScene(showSymbolsScene);
                    this.showSymbols();
                    scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
                    askSymbolsPane.setTop(scoring);
                    // guessScene = new Scene(askSymbolsPane);  blows up
                    primaryStage.setScene(guessScene); 
                }
            } else {
                System.out.println("Väärin! Peli loppui!");
                System.out.println("Pisteesi olivat: " + normalgame.getScore());
                primaryStage.setScene(newGameScene);
                scoring = new Label("Pisteet: 0");
            }
        });
        
        Button button2 = new Button("Kaksi");
        button2.setOnAction((event) -> {
            System.out.println("Vastasit: 2");
            if (normalgame.compareAnswer(2)) {
                System.out.println("Oikein!");
                if (normalgame.nextRound()) {
                    primaryStage.setScene(showSymbolsScene);
                    this.showSymbols();
                    scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
                    askSymbolsPane.setTop(scoring);
                    // guessScene = new Scene(askSymbolsPane);  blows up
                    primaryStage.setScene(guessScene); 
                }
            } else {
                System.out.println("Väärin! Peli loppui!");
                System.out.println("Pisteesi olivat: " + normalgame.getScore());
                primaryStage.setScene(newGameScene);
                scoring = new Label("Pisteet: 0");
            }
        });
        
        Button button3 = new Button("Kolme");
        button3.setOnAction((event) -> {
            System.out.println("Vastasit: 3");
            if (normalgame.compareAnswer(3)) {
                System.out.println("Oikein!");
                if (normalgame.nextRound()) {
                    primaryStage.setScene(showSymbolsScene);
                    this.showSymbols();
                    scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
                    askSymbolsPane.setTop(scoring);
                    // guessScene = new Scene(askSymbolsPane);  blows up
                    primaryStage.setScene(guessScene); 
                }
            } else {
                System.out.println("Väärin! Peli loppui!");
                System.out.println("Pisteesi olivat: " + normalgame.getScore());
                primaryStage.setScene(newGameScene);   // endgamescene
                scoring = new Label("Pisteet: 0");
            }
        });
        
        Button button4 = new Button("Neljä");
        button4.setOnAction((event) -> {
            System.out.println("Vastasit: 4");
            if (normalgame.compareAnswer(4)) {
                System.out.println("Oikein!");
                if (normalgame.nextRound()) {
                    primaryStage.setScene(showSymbolsScene);
                    this.showSymbols();
                    scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
                    askSymbolsPane.setTop(scoring);
                    // guessScene = new Scene(askSymbolsPane);  blows up
                    primaryStage.setScene(guessScene); 
                }
            } else {
                System.out.println("Väärin! Peli loppui!");
                System.out.println("Pisteesi olivat: " + normalgame.getScore());
                primaryStage.setScene(newGameScene);
                scoring = new Label("Pisteet: 0");
            }
        });
        

	bottomButtons.getChildren().add(button1);
	bottomButtons.getChildren().add(button2);
        bottomButtons.getChildren().add(button3);
        bottomButtons.getChildren().add(button4);
        
        
        
        askSymbolsPane = new BorderPane();
        askSymbolsPane.setTop(scoring);
        askSymbolsPane.setBottom(bottomButtons);
        askSymbolsPane.setCenter(new Label("Paina painikkeita juuri näkemässäsi järjestyksessä!"));

        guessScene = new Scene(askSymbolsPane);

        primaryStage.setScene(newGameScene);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.show();
        
    }

        //nukutaan, purkkaa
    public void sleepTime(int time) {
         try {
            Thread.sleep(time*1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }   
    }
    
    
    public static void main(String[] args) {
        launch(uiTest.class);

    }
        
}
