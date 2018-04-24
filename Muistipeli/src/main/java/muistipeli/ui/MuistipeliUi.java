package muistipeli.ui;
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
import muistipeli.domain.NormalGame;
import javafx.scene.Group; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.*; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.geometry.Pos;

public class MuistipeliUi extends Application {
    
    NormalGame normalgame = new NormalGame();
    Label score = new Label("Pisteet: ");
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
    Stage thestage;
    BorderPane showSymbolsPane;
    int delay;
    Scene showScene;
    
        
    @Override
    public void start(Stage primaryStage) {
        
        thestage = primaryStage;
        
        // symbol one to four scenes
        
        Circle circle1 = new Circle();    
        circle1.setCenterX(142.5f); 
        circle1.setCenterY(125.0f); 
        circle1.setRadius(70.0f); 
        circle1.setFill(Color.GREEN);    
        circle1.setStrokeWidth(2);  
        circle1.setStroke(Color.BLACK);

        Group root1 = new Group(circle1); 
        symbolOneScene = new Scene(root1, 285, 250, Color.WHITESMOKE);  
        

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            145.0, 55.0,
            70.0, 190.0,
            220.0, 190.0 });
        polygon.setFill(Color.RED);    
        polygon.setStrokeWidth(2); 
        polygon.setStroke(Color.BLACK);

        Group root2 = new Group(polygon); 
        symbolTwoScene = new Scene(root2, 285, 250, Color.WHITESMOKE);  
        
        
        Circle circle3 = new Circle();    
        circle3.setCenterX(142.5f); 
        circle3.setCenterY(125.0f); 
        circle3.setRadius(70.0f); 
        circle3.setFill(Color.YELLOW);    
        circle3.setStrokeWidth(2); 
        circle3.setStroke(Color.BLACK);
    
        Group root3 = new Group(circle3); 
        symbolThreeScene = new Scene(root3, 285, 250, Color.WHITESMOKE);  
        
//      // tähden alkeet
//        Polygon polygon2 = new Polygon();
//        polygon2.getPoints().addAll(new Double[]{
//            184.9, 167.4,
//            90.5, 155.0,
//            142.5,  65.0 });
//
//        //Setting color to the circle 
//        polygon2.setFill(Color.YELLOW);    
//
//        //Setting the stroke width 
//        polygon2.setStrokeWidth(2); 
//
//        //Setting color to the stroke  
//        polygon2.setStroke(Color.YELLOW);
//        
//        Polygon polygon3 = new Polygon();
//        polygon3.getPoints().addAll(new Double[]{
//            202.5, 125.0,
//            90.5, 95.0,
//            194.5, 95.0 });
//
//        //Setting color to the circle 
//        polygon3.setFill(Color.YELLOW);    
//
//        //Setting the stroke width 
//        polygon3.setStrokeWidth(2); 
//
//        //Setting color to the stroke  
//        polygon3.setStroke(Color.YELLOW);
        
        Rectangle rec = new Rectangle();
        rec.setX(82.5);
        rec.setY(70);
        rec.setWidth(120);
        rec.setHeight(120);
        rec.setArcWidth(1);
        rec.setArcHeight(1);  
        rec.setFill(Color.DARKBLUE);    
        rec.setStrokeWidth(2);  
        rec.setStroke(Color.BLACK);

        Group root4 = new Group(rec); 
        symbolFourScene = new Scene(root4, 285, 250, Color.WHITESMOKE);  
        
        
        
        // showSymbolsScene defined        
        showSymbolsPane = new BorderPane();
        showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(normalgame.getRoundNumber()) + "!   Valmistaudu!"));
        showSymbolsScene = new Scene(showSymbolsPane, 285, 260);
        
                
        // newGameScene defined      
        BorderPane newGamePane = new BorderPane();
        
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction((event) -> {
            normalgame = new NormalGame();    // tarvitaan, koska seuraavaan laabeliin tulee round number
            this.showSymbols();
        });
        
        newGamePane.setCenter(newGameButton);
        newGameScene = new Scene(newGamePane, 285, 260);

        
        // luodaan kuviot guessScenen nappuloille
        
        Circle circle2 = new Circle();    
        circle2.setCenterX(150.0f); 
        circle2.setCenterY(150.0f); 
        circle2.setRadius(20.0f); 
        circle2.setFill(Color.GREEN);    
        circle2.setStrokeWidth(1);  
        circle2.setStroke(Color.BLACK);
         
        Circle circleX = new Circle();    
        circleX.setCenterX(150.0f); 
        circleX.setCenterY(150.0f); 
        circleX.setRadius(20.0f); 
        circleX.setFill(Color.YELLOW);     
        circleX.setStrokeWidth(1);  
        circleX.setStroke(Color.BLACK);
    
        Polygon polygonX = new Polygon();
        polygonX.getPoints().addAll(new Double[]{
            30.0, 12.0,
            10.0, 50.0,
            50.0, 50.0 });
        polygonX.setFill(Color.RED);    
        polygonX.setStrokeWidth(1); 
        polygonX.setStroke(Color.BLACK);

        Rectangle recX = new Rectangle();
        recX.setX(100);
        recX.setY(100);
        recX.setWidth(40);
        recX.setHeight(40);
        recX.setArcWidth(1);
        recX.setArcHeight(1);  
        recX.setFill(Color.DARKBLUE);    
        recX.setStrokeWidth(1);   
        recX.setStroke(Color.BLACK);
       
        
        // guessScene defined   
        HBox bottomButtons = new HBox();
        bottomButtons.setSpacing(10);
        
        scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
        
        Button button1 = defineButton(1);
        button1.setGraphic(circle2);
        
        Button button2 = defineButton(2);
        button2.setGraphic(polygonX);
        
        Button button3 = defineButton(3);
        button3.setGraphic(circleX);
        
        Button button4 = defineButton(4);
        button4.setGraphic(recX);
        
	bottomButtons.getChildren().add(button1);
	bottomButtons.getChildren().add(button2);
        bottomButtons.getChildren().add(button3);
        bottomButtons.getChildren().add(button4);
        
        bottomButtons.setAlignment(Pos.BASELINE_CENTER);
        
        askSymbolsPane = new BorderPane();
        askSymbolsPane.setTop(scoring);
        askSymbolsPane.setBottom(bottomButtons);
        askSymbolsPane.setCenter(new Label("Paina painikkeita juuri näkemässäsi järjestyksessä!"));

        guessScene = new Scene(askSymbolsPane, 285, 260);

        primaryStage.setScene(newGameScene);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.show();
    }
    
    public Button defineButton(int buttonNmbr) {
       Button buttonX = new Button("");
        buttonX.setOnAction((event) -> {
            if (normalgame.compareAnswer(buttonNmbr)) {
                scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
                askSymbolsPane.setTop(scoring);
                // primaryStage.setScene(guessScene); 
                if (normalgame.nextRound()) {
                    showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(normalgame.getRoundNumber()) + "!   Valmistaudu!"));
                    Thread thread = new Thread(() -> {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException exc) {
                            throw new Error("Unexpected interruption", exc);
                        }
                        Platform.runLater(() -> thestage.setScene(showSymbolsScene));
                    });
                    thread.setDaemon(true);
                    thread.start();
                    // primaryStage.setScene(showSymbolsScene);


                    this.showSymbols();
                    
                    // primaryStage.setScene(guessScene);
                    scoring = new Label("Pisteet: " + Integer.toString(normalgame.getScore()));
                    askSymbolsPane.setTop(scoring);
                    // guessScene = new Scene(askSymbolsPane);  blows up
                    thestage.setScene(guessScene); 
                }
            } else {
                showSymbolsPane.setCenter(new Label("Väärin! Peli loppui!   Pisteesi olivat: " + normalgame.getScore()));
                thestage.setScene(showSymbolsScene);

                    Thread thread = new Thread(() -> {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException exc) {
                            throw new Error("Unexpected interruption", exc);
                        }
                        Platform.runLater(() -> thestage.setScene(newGameScene));
                    });
                thread.setDaemon(true);
                thread.start();

                scoring = new Label("Pisteet: 0");
                askSymbolsPane.setTop(scoring);
            }
        });
        return buttonX;
   } 

    public void showSymbols() { 
        showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(normalgame.getRoundNumber()) + "!   Valmistaudu!"));
        thestage.setScene(showSymbolsScene);


        System.out.println("Kierros: " + this.normalgame.getRoundNumber());

        delay = 2000;

        // haetaan symbolit       
        while (true) {
            // printtaa ruudulle haetun mukaisen symbolin, toisin sanoen vaihtaa laatikon väriä (ehkä olisi mukavampi jos olisi värillinen ja jonkin muotoinen)
            // pitääkö jokaisella värillä olla erillinen scene? vai miten vanhaa sceneä updatetaan?
            int print = this.normalgame.nextSymbol();
            
            if (print > 0) {
                System.out.println(print);
                
                if (print == 1) {
                    int delay2 = delay;
                    Thread thread1 = new Thread(() -> {
                        try {
                            Thread.sleep(delay2);
                        } catch (InterruptedException exc) {
                            throw new Error("Unexpected interruption", exc);
                        }
                        Platform.runLater(() -> thestage.setScene(symbolOneScene));
                    });
                    thread1.setDaemon(true);
                    thread1.start();
                    // primaryStage.setScene(symbolOneScene);
                }
                if (print == 2) {
                    int delay2 = delay;
                    Thread thread2 = new Thread(() -> {
                        try {
                            Thread.sleep(delay2);
                        } catch (InterruptedException exc) {
                            throw new Error("Unexpected interruption", exc);
                        }
                        Platform.runLater(() -> thestage.setScene(symbolTwoScene));
                    });
                    thread2.setDaemon(true);
                    thread2.start();
                    // primaryStage.setScene(symbolTwoScene);
                }
                if (print == 3) {
                    int delay2 = delay;
                    Thread thread3 = new Thread(() -> {
                        try {
                            Thread.sleep(delay2);
                        } catch (InterruptedException exc) {
                            throw new Error("Unexpected interruption", exc);
                        }
                        Platform.runLater(() -> thestage.setScene(symbolThreeScene));
                    });
                    thread3.setDaemon(true);
                    thread3.start();
                    // primaryStage.setScene(symbolThreeScene);
                }
                if (print == 4) {
                    int delay2 = delay;
                    Thread thread4 = new Thread(() -> {
                        try {
                            Thread.sleep(delay2);
                        } catch (InterruptedException exc) {
                            throw new Error("Unexpected interruption", exc);
                        }
                        Platform.runLater(() -> thestage.setScene(symbolFourScene));
                    });
                    thread4.setDaemon(true);
                    thread4.start();
                    // primaryStage.setScene(symbolFourScene);
                }

            } else {   // jos print on nolla, niin hypätään seuraavaan vaiheeseen
                // System.out.println("Paina painikkeita juuri näkemässäsi järjestyksessä!");
                break;
            }

            delay = delay + 2000;
        }

        Thread thread5 = new Thread(() -> {
            try {
                int delay2 = delay;
                Thread.sleep(delay2);
            } catch (InterruptedException exc) {
                throw new Error("Unexpected interruption", exc);
            }
            Platform.runLater(() -> thestage.setScene(guessScene));
        });
        thread5.setDaemon(true);
        thread5.start();
        // primaryStage.setScene(guessScene);
    }
    
    public static void main(String[] args) {
        launch(MuistipeliUi.class);

    }
        
}
