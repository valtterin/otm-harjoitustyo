package muistipeli.ui;
// import static javafx.application.Application.launch;
import muistipeli.logics.ReverseGame;
import muistipeli.logics.BlindGame;
import muistipeli.logics.Game;
import muistipeli.logics.EasyGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.scene.Group; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.*; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.geometry.Pos;

public class MuistipeliUi extends Application {
    
    Game newGame = new Game();
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
    Label centerHelpLabel;
    
        
    @Override
    public void start(Stage primaryStage) {
        
        thestage = primaryStage;
        
        // symbol one to four scenes
        
        Circle greenCircleBig = new Circle();    
        greenCircleBig.setCenterX(142.5f); 
        greenCircleBig.setCenterY(125.0f); 
        greenCircleBig.setRadius(70.0f); 
        greenCircleBig.setFill(Color.GREEN);    
        greenCircleBig.setStrokeWidth(2);  
        greenCircleBig.setStroke(Color.BLACK);

        Group root1 = new Group(greenCircleBig); 
        symbolOneScene = new Scene(root1, 285, 250, Color.WHITESMOKE);  
        

        Polygon redTriangleBig = new Polygon();
        redTriangleBig.getPoints().addAll(new Double[]{
            145.0, 55.0,
            70.0, 190.0,
            220.0, 190.0 });
        redTriangleBig.setFill(Color.RED);    
        redTriangleBig.setStrokeWidth(2); 
        redTriangleBig.setStroke(Color.BLACK);

        Group root2 = new Group(redTriangleBig); 
        symbolTwoScene = new Scene(root2, 285, 250, Color.WHITESMOKE);  
        
        
        Circle yellowCircleBig = new Circle();    
        yellowCircleBig.setCenterX(142.5f); 
        yellowCircleBig.setCenterY(125.0f); 
        yellowCircleBig.setRadius(70.0f); 
        yellowCircleBig.setFill(Color.YELLOW);    
        yellowCircleBig.setStrokeWidth(2); 
        yellowCircleBig.setStroke(Color.BLACK);
    
        Group root3 = new Group(yellowCircleBig); 
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
        
        Rectangle blueSquareBig = new Rectangle();
        blueSquareBig.setX(82.5);
        blueSquareBig.setY(70);
        blueSquareBig.setWidth(120);
        blueSquareBig.setHeight(120);
        blueSquareBig.setArcWidth(1);
        blueSquareBig.setArcHeight(1);  
        blueSquareBig.setFill(Color.DARKBLUE);    
        blueSquareBig.setStrokeWidth(2);  
        blueSquareBig.setStroke(Color.BLACK);

        Group root4 = new Group(blueSquareBig); 
        symbolFourScene = new Scene(root4, 285, 250, Color.WHITESMOKE);  
        
        
        
        // showSymbolsScene defined        
        showSymbolsPane = new BorderPane();
        showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(newGame.getRoundNumber()) + "!   Valmistaudu!"));
        showSymbolsScene = new Scene(showSymbolsPane, 285, 260);
        
                
        // newGameScene defined      
        VBox gameButtons = new VBox();
        gameButtons.setSpacing(10);
        gameButtons.setAlignment(Pos.CENTER);        


        

        BorderPane newGamePane = new BorderPane();
        
        Button newNormalGameButton = new Button("Normal Game");
        newNormalGameButton.setOnAction((event) -> {
            newGame = new Game();
            centerHelpLabel = new Label("Paina painikkeita juuri näkemässäsi järjestyksessä!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
        Button newEasyGameButton = new Button("Easy Game");
        newEasyGameButton.setOnAction((event) -> {
            newGame = new EasyGame();
            centerHelpLabel = new Label("Paina painikkeita juuri näkemässäsi järjestyksessä!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
        Button newBlindGameButton = new Button("Blind Game");
        newBlindGameButton.setOnAction((event) -> {
            newGame = new BlindGame();
            centerHelpLabel = new Label("Käy lävitse KAIKKI tähän asti näkemäsi symbolit!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
        Button newReverseGameButton = new Button("Reverse Game");
        newReverseGameButton.setOnAction((event) -> {
            newGame = new ReverseGame();
            centerHelpLabel = new Label("Paina painikkeita päinvastaisessa järjestyksessä!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
	gameButtons.getChildren().add(newEasyGameButton);        
        gameButtons.getChildren().add(newNormalGameButton);
        gameButtons.getChildren().add(newBlindGameButton);
        gameButtons.getChildren().add(newReverseGameButton);

        
        newGamePane.setCenter(gameButtons);
        newGameScene = new Scene(newGamePane, 285, 260);

        
        // luodaan kuviot guessScenen nappuloille
        
        Circle greenCircleSmall = new Circle();    
        greenCircleSmall.setCenterX(150.0f); 
        greenCircleSmall.setCenterY(150.0f); 
        greenCircleSmall.setRadius(20.0f); 
        greenCircleSmall.setFill(Color.GREEN);    
        greenCircleSmall.setStrokeWidth(1);  
        greenCircleSmall.setStroke(Color.BLACK);
         
        Circle yellowCircleSmall = new Circle();    
        yellowCircleSmall.setCenterX(150.0f); 
        yellowCircleSmall.setCenterY(150.0f); 
        yellowCircleSmall.setRadius(20.0f); 
        yellowCircleSmall.setFill(Color.YELLOW);     
        yellowCircleSmall.setStrokeWidth(1);  
        yellowCircleSmall.setStroke(Color.BLACK);
    
        Polygon redTriangleSmall = new Polygon();
        redTriangleSmall.getPoints().addAll(new Double[]{
            30.0, 12.0,
            10.0, 50.0,
            50.0, 50.0 });
        redTriangleSmall.setFill(Color.RED);    
        redTriangleSmall.setStrokeWidth(1); 
        redTriangleSmall.setStroke(Color.BLACK);

        Rectangle blueSquareSmall = new Rectangle();
        blueSquareSmall.setX(100);
        blueSquareSmall.setY(100);
        blueSquareSmall.setWidth(40);
        blueSquareSmall.setHeight(40);
        blueSquareSmall.setArcWidth(1);
        blueSquareSmall.setArcHeight(1);  
        blueSquareSmall.setFill(Color.DARKBLUE);    
        blueSquareSmall.setStrokeWidth(1);   
        blueSquareSmall.setStroke(Color.BLACK);
       
        
        // guessScene defined   
        HBox bottomButtons = new HBox();
        bottomButtons.setSpacing(10);
        
        scoring = new Label("Pisteet: " + Integer.toString(newGame.getScore()));
        
        Button button1 = defineButton(1);
        button1.setGraphic(greenCircleSmall);
        
        Button button2 = defineButton(2);
        button2.setGraphic(redTriangleSmall);
        
        Button button3 = defineButton(3);
        button3.setGraphic(yellowCircleSmall);
        
        Button button4 = defineButton(4);
        button4.setGraphic(blueSquareSmall);
        
	bottomButtons.getChildren().add(button1);
	bottomButtons.getChildren().add(button2);
        bottomButtons.getChildren().add(button3);
        bottomButtons.getChildren().add(button4);
        
        bottomButtons.setAlignment(Pos.BASELINE_CENTER);
        
        askSymbolsPane = new BorderPane();
        askSymbolsPane.setTop(scoring);
        askSymbolsPane.setBottom(bottomButtons);
        askSymbolsPane.setCenter(centerHelpLabel);

        guessScene = new Scene(askSymbolsPane, 285, 260);

        primaryStage.setScene(newGameScene);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.show();
    }
    
    public Button defineButton(int buttonNmbr) {
       Button buttonX = new Button("");
        buttonX.setOnAction((event) -> {
            if (newGame.compareAnswer(buttonNmbr)) {
                scoring = new Label("Pisteet: " + Integer.toString(newGame.getScore()));
                askSymbolsPane.setTop(scoring);
                // primaryStage.setScene(guessScene); 
                if (newGame.nextRound()) {
                    showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(newGame.getRoundNumber()) + "!   Valmistaudu!"));
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
                    scoring = new Label("Pisteet: " + Integer.toString(newGame.getScore()));
                    askSymbolsPane.setTop(scoring);
                    // guessScene = new Scene(askSymbolsPane);  blows up
                    thestage.setScene(guessScene); 
                }
            } else {
                showSymbolsPane.setCenter(new Label("Väärin! Peli loppui!   Pisteesi olivat: " + newGame.getScore()));
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
        showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(newGame.getRoundNumber()) + "!   Valmistaudu!"));
        thestage.setScene(showSymbolsScene);


        System.out.println("Kierros: " + this.newGame.getRoundNumber());

        delay = 2000;

        // haetaan symbolit       
        while (true) {
            // printtaa ruudulle haetun mukaisen symbolin, toisin sanoen vaihtaa laatikon väriä (ehkä olisi mukavampi jos olisi värillinen ja jonkin muotoinen)
            // pitääkö jokaisella värillä olla erillinen scene? vai miten vanhaa sceneä updatetaan?
            int print = this.newGame.nextSymbol();
            
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
