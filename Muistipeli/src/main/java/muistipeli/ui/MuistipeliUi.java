package muistipeli.ui;
// import static javafx.application.Application.launch;
import java.sql.SQLException;
import muistipeli.gamemodes.ReverseGame;
import muistipeli.gamemodes.BlindGame;
import muistipeli.logics.Game;
import muistipeli.gamemodes.EasyGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.*; 
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import muistipeli.database.*;

public class MuistipeliUi extends Application {

    Text startingRoundInfo;
    Text difficultyInfo;
    Text delayInfo;
    Text infoDelayInfo;
    Text scoringInfo;
    Text endgameText4 = new Text(" ");;
    
    
    int startingRound = 1;
    int difficulty = 1;
    int delaySymbol = 1000;   // kuvioiden kesto ruudulla 
    int delayText = 1500;  // text boxien kesto ruudulla
    boolean legitScore = true;
    int delay1;  
    Game newGame = new Game(difficulty, startingRound);
    Text score = new Text("Pisteet: ");
    Scene newGameScene;
    Scene showSymbolsScene;
    Scene guessScene;
    Scene endGameScene;
    Scene symbolOneScene;
    Scene symbolTwoScene;
    Scene symbolThreeScene;
    Scene symbolFourScene;
    Scene optionsScene;
    Scene HighScoresScene;
    Scene scoresScene;
    Text scoring;
    Text endgameText;
    BorderPane askSymbolsPane;
    Stage thestage;
    BorderPane showSymbolsPane;
    GridPane guessTopPane;

    Scene showScene;
    Text centerHelpLabel;
    
    Database database;
    ScoreDao scoredao;
    
        
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        database = new Database("jdbc:sqlite:scores.db");
        scoredao = new ScoreDao(database);
        
        
        
        
        thestage = primaryStage;
        
        
        // end game scene
        this.defineEndScene();
        

        // symbol one to four scenes
        
        Circle greenCircleBig = new Circle();    
        greenCircleBig.setCenterX(142.5f); 
        greenCircleBig.setCenterY(125.0f); 
        greenCircleBig.setRadius(70.0f); 
        greenCircleBig.setFill(Color.GREEN);    
        greenCircleBig.setStrokeWidth(2);  
        greenCircleBig.setStroke(Color.BLACK);

        Group root1 = new Group(greenCircleBig); 
        symbolOneScene = new Scene(root1, 285, 250, Color.IVORY);  
        

        Polygon redTriangleBig = new Polygon();
        redTriangleBig.getPoints().addAll(new Double[]{
            145.0, 55.0,
            70.0, 190.0,
            220.0, 190.0 });
        redTriangleBig.setFill(Color.RED);    
        redTriangleBig.setStrokeWidth(2); 
        redTriangleBig.setStroke(Color.BLACK);

        Group root2 = new Group(redTriangleBig); 
        symbolTwoScene = new Scene(root2, 285, 250, Color.IVORY);  
        
        
        Circle yellowCircleBig = new Circle();    
        yellowCircleBig.setCenterX(142.5f); 
        yellowCircleBig.setCenterY(125.0f); 
        yellowCircleBig.setRadius(70.0f); 
        yellowCircleBig.setFill(Color.YELLOW);    
        yellowCircleBig.setStrokeWidth(2); 
        yellowCircleBig.setStroke(Color.BLACK);
    
        Group root3 = new Group(yellowCircleBig); 
        symbolThreeScene = new Scene(root3, 285, 250, Color.IVORY);  
        
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
        symbolFourScene = new Scene(root4, 285, 250, Color.IVORY);  
        
        // high scores Scene defined
        this.defineScoreScene();

        
        // optionsScene defined
        BorderPane optionsPane = new BorderPane();
        optionsPane.setStyle("-fx-background-color: #FFFFF0;");
        
        GridPane optionsGrid = new GridPane();
        optionsGrid.setPadding(new Insets(20, 20, 20, 20));
        optionsGrid.setVgap(10);
        optionsGrid.setHgap(10);

        
        Text startingRoundLabel = new Text("Aloituskierros:");
        startingRoundLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(startingRoundLabel, 0, 0);
        optionsGrid.getChildren().add(startingRoundLabel);

        Text difficultyLabel = new Text("Vaikeusaste:");
        difficultyLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(difficultyLabel, 0, 1);
        optionsGrid.getChildren().add(difficultyLabel);
        
        Text delayLabel = new Text("Kuvioiden kesto:");
        delayLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(delayLabel, 0, 2);
        optionsGrid.getChildren().add(delayLabel);
        
        Text infoDelayLabel = new Text("Varoituksen kesto:");
        infoDelayLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(infoDelayLabel, 0, 3);
        optionsGrid.getChildren().add(infoDelayLabel);
        

        startingRoundInfo = new Text(Integer.toString(startingRound));
        startingRoundInfo.setFill(Color.BLACK);
        GridPane.setConstraints(startingRoundInfo, 1, 0);
        optionsGrid.getChildren().add(startingRoundInfo);

        difficultyInfo = new Text(Integer.toString(difficulty));
        difficultyInfo.setFill(Color.BLACK);
        GridPane.setConstraints(difficultyInfo, 1, 1);
        optionsGrid.getChildren().add(difficultyInfo);
        
        delayInfo = new Text(Integer.toString(delaySymbol) + " ms");
        delayInfo.setFill(Color.BLACK);
        GridPane.setConstraints(delayInfo, 1, 2);
        optionsGrid.getChildren().add(delayInfo);
        
        infoDelayInfo = new Text(Integer.toString(delayText) + " ms");
        infoDelayInfo.setFill(Color.BLACK);
        GridPane.setConstraints(infoDelayInfo, 1, 3);
        optionsGrid.getChildren().add(infoDelayInfo);

        
        optionsPane.setTop(optionsGrid);
        optionsScene = new Scene(optionsPane, 285, 260);       
        
        
        Button minusStartButton = new Button("-");
        minusStartButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        minusStartButton.setMinWidth(25);
        minusStartButton.setOnAction((event) -> {
            if (startingRound > 1) {
                startingRound--;
            }
            optionsGrid.getChildren().remove(startingRoundInfo);
            startingRoundInfo = new Text(Integer.toString(startingRound));
            GridPane.setConstraints(startingRoundInfo, 1, 0);
            optionsGrid.getChildren().add(startingRoundInfo);
        });
        
        Button plusStartButton = new Button("+");
        plusStartButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        plusStartButton.setOnAction((event) -> {
            if (startingRound < 100) {
                startingRound++;
            }
            optionsGrid.getChildren().remove(startingRoundInfo);
            startingRoundInfo = new Text(Integer.toString(startingRound));
            GridPane.setConstraints(startingRoundInfo, 1, 0);
            optionsGrid.getChildren().add(startingRoundInfo);
        });

        Button minusDifficultyButton = new Button("-");
        minusDifficultyButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        minusDifficultyButton.setMinWidth(25);
        minusDifficultyButton.setOnAction((event) -> {
            if (difficulty > 0) {
                difficulty--;
            }
            optionsGrid.getChildren().remove(difficultyInfo);
            difficultyInfo = new Text(Integer.toString(difficulty));
            GridPane.setConstraints(difficultyInfo, 1, 1);
            optionsGrid.getChildren().add(difficultyInfo);
        });
        
        Button plusDifficultyButton = new Button("+");
        plusDifficultyButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        plusDifficultyButton.setOnAction((event) -> {
            if (difficulty < 100) {
                difficulty++;
            }
            optionsGrid.getChildren().remove(difficultyInfo);
            difficultyInfo = new Text(Integer.toString(difficulty));
            GridPane.setConstraints(difficultyInfo, 1, 1);
            optionsGrid.getChildren().add(difficultyInfo);
        });
        
        
        Button minusDelayButton = new Button("-");
        minusDelayButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        minusDelayButton.setMinWidth(25);
        minusDelayButton.setOnAction((event) -> {
            if (delaySymbol > 100) {
                delaySymbol = delaySymbol - 100;
            }
            optionsGrid.getChildren().remove(delayInfo);
            delayInfo = new Text(Integer.toString(delaySymbol) + " ms");
            GridPane.setConstraints(delayInfo, 1, 2);
            optionsGrid.getChildren().add(delayInfo);
        });
        
        Button plusDelayButton = new Button("+");
        plusDelayButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        plusDelayButton.setOnAction((event) -> {
            if (delaySymbol < 10001) {
                delaySymbol = delaySymbol + 100;
            }
            optionsGrid.getChildren().remove(delayInfo);
            delayInfo = new Text(Integer.toString(delaySymbol) + " ms");
            GridPane.setConstraints(delayInfo, 1, 2);
            optionsGrid.getChildren().add(delayInfo);
        });
        
        Button minusInfoDelayButton = new Button("-");
        minusInfoDelayButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        minusInfoDelayButton.setMinWidth(25);
        minusInfoDelayButton.setOnAction((event) -> {
            if (delayText > 1) {
                delayText = delayText - 100;
            }
            optionsGrid.getChildren().remove(infoDelayInfo);
            infoDelayInfo = new Text(Integer.toString(delayText) + " ms");
            GridPane.setConstraints(infoDelayInfo, 1, 3);
            optionsGrid.getChildren().add(infoDelayInfo);
        });
        
        Button plusInfoDelayButton = new Button("+");
        plusInfoDelayButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 0px;");
        plusInfoDelayButton.setOnAction((event) -> {
            if (delayText < 10001) {
                delayText = delayText + 100;
            }
            optionsGrid.getChildren().remove(infoDelayInfo);
            infoDelayInfo = new Text(Integer.toString(delayText) + " ms");
            GridPane.setConstraints(infoDelayInfo, 1, 3);
            optionsGrid.getChildren().add(infoDelayInfo);
        });
        
        
        GridPane.setConstraints(minusInfoDelayButton, 4, 3);
        optionsGrid.getChildren().add(minusInfoDelayButton);
        
        GridPane.setConstraints(plusInfoDelayButton, 5, 3);
        optionsGrid.getChildren().add(plusInfoDelayButton);
        
        GridPane.setConstraints(minusDelayButton, 4, 2);
        optionsGrid.getChildren().add(minusDelayButton);
        
        GridPane.setConstraints(plusDelayButton, 5, 2);
        optionsGrid.getChildren().add(plusDelayButton);
        
        GridPane.setConstraints(minusDifficultyButton, 4, 1);
        optionsGrid.getChildren().add(minusDifficultyButton);
        
        GridPane.setConstraints(plusDifficultyButton, 5, 1);
        optionsGrid.getChildren().add(plusDifficultyButton);
        
        GridPane.setConstraints(minusStartButton, 4, 0);
        optionsGrid.getChildren().add(minusStartButton);
        
        GridPane.setConstraints(plusStartButton, 5, 0);
        optionsGrid.getChildren().add(plusStartButton);
        
        
        GridPane optionsSecondGrid = new GridPane();
        optionsSecondGrid.setPadding(new Insets(0, 20, 20, 20));

        
        Button defaultsButton = new Button("Default");
        defaultsButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        defaultsButton.setOnAction((event) -> {
            startingRound = 1;
            difficulty = 1;
            delaySymbol = 1000;   // kuvioiden kesto ruudulla 
            delayText = 1500;  // text boxien kesto ruudulla
            legitScore = true;
            
            optionsGrid.getChildren().remove(startingRoundInfo);
            startingRoundInfo = new Text(Integer.toString(startingRound));
            GridPane.setConstraints(startingRoundInfo, 1, 0);
            optionsGrid.getChildren().add(startingRoundInfo);
            
            optionsGrid.getChildren().remove(difficultyInfo);
            difficultyInfo = new Text(Integer.toString(difficulty));
            GridPane.setConstraints(difficultyInfo, 1, 1);
            optionsGrid.getChildren().add(difficultyInfo);
            
            optionsGrid.getChildren().remove(delayInfo);
            delayInfo = new Text(Integer.toString(delaySymbol) + " ms");
            GridPane.setConstraints(delayInfo, 1, 2);
            optionsGrid.getChildren().add(delayInfo);
            
            optionsGrid.getChildren().remove(infoDelayInfo);
            infoDelayInfo = new Text(Integer.toString(delayText) + " ms");
            GridPane.setConstraints(infoDelayInfo, 1, 3);
            optionsGrid.getChildren().add(infoDelayInfo);
            
        }); 

        Button exitButton2 = new Button("Takaisin");
        exitButton2.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        exitButton2.setOnAction((event) -> {
            thestage.setScene(newGameScene);
        });
  
        
        HBox settingsButtons = new HBox();
        settingsButtons.setSpacing(110);
        settingsButtons.setAlignment(Pos.CENTER); 
        
        settingsButtons.getChildren().add(exitButton2);
        settingsButtons.getChildren().add(defaultsButton);

        GridPane.setConstraints(settingsButtons, 0, 0);
        optionsSecondGrid.getChildren().add(settingsButtons);
        optionsSecondGrid.setAlignment(Pos.CENTER);
        
        optionsPane.setBottom(optionsSecondGrid);
        
        
        // showSymbolsScene defined        
        showSymbolsPane = new BorderPane();
        showSymbolsPane.setStyle("-fx-background-color: #FFFFF0;");
        showSymbolsPane.setCenter(new Text("Kierros " + Integer.toString(newGame.getRoundNumber()) + "!   Valmistaudu!"));
        showSymbolsScene = new Scene(showSymbolsPane, 285, 260);
        
                
        // newGameScene defined      
        VBox gameButtons = new VBox();
        gameButtons.setSpacing(10);
        gameButtons.setAlignment(Pos.CENTER);        


        
        BorderPane newGamePane = new BorderPane();
        GridPane gameButtonsGrid = new GridPane();
        gameButtonsGrid.setPadding(new Insets(10, 10, 10, 10));
        gameButtonsGrid.setVgap(10);
        gameButtonsGrid.setHgap(20);
        
        Button newNormalGameButton = new Button("Normaali");
        newNormalGameButton.setMinWidth(90);
        newNormalGameButton.setMinHeight(30);
        newNormalGameButton.setOnAction((event) -> {
            newGame = new Game(difficulty, startingRound);
            centerHelpLabel = new Text("Paina painikkeita juuri näkemässäsi järjestyksessä!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
        Button newEasyGameButton = new Button("Helppo");
        newEasyGameButton.setMinWidth(90);
        newEasyGameButton.setMinHeight(30);
        newEasyGameButton.setOnAction((event) -> {
            newGame = new EasyGame(difficulty, startingRound);
            centerHelpLabel = new Text("Paina painikkeita juuri näkemässäsi järjestyksessä!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
        Button newBlindGameButton = new Button("Sokko");
        newBlindGameButton.setMinWidth(90);
        newBlindGameButton.setMinHeight(30);
        newBlindGameButton.setOnAction((event) -> {
            newGame = new BlindGame(difficulty, startingRound);
            centerHelpLabel = new Text("Käy lävitse KAIKKI tähän asti näkemäsi symbolit!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
        Button newReverseGameButton = new Button("Reverse");
        newReverseGameButton.setMinWidth(90);
        newReverseGameButton.setMinHeight(30);
        newReverseGameButton.setOnAction((event) -> {
            newGame = new ReverseGame(difficulty, startingRound);
            centerHelpLabel = new Text("Paina painikkeita päinvastaisessa järjestyksessä!");
            askSymbolsPane.setCenter(centerHelpLabel);
            this.showSymbols();
        });
        
        Button optionsButton = new Button("Asetukset");
        optionsButton.setMinWidth(101);
        optionsButton.setOnAction((event) -> {
            thestage.setScene(optionsScene);
        });
        
        Button scoresButton = new Button("Parhaat Pisteet");
        scoresButton.setMinWidth(95);
        scoresButton.setOnAction((event) -> {
            thestage.setScene(scoresScene);
        });
        
//	gameButtons.getChildren().add(newEasyGameButton);        
//        gameButtons.getChildren().add(newNormalGameButton);
//        gameButtons.getChildren().add(newBlindGameButton);
//        gameButtons.getChildren().add(newReverseGameButton);
//        gameButtons.getChildren().add(optionsButton);

        


        newEasyGameButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        newNormalGameButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        newBlindGameButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        newReverseGameButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        optionsButton.setStyle("-fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        scoresButton.setStyle("-fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");

        GridPane.setConstraints(newEasyGameButton, 0, 0);
        gameButtonsGrid.getChildren().add(newEasyGameButton);
        
        GridPane.setConstraints(newNormalGameButton, 1, 0);
        gameButtonsGrid.getChildren().add(newNormalGameButton);
        
        GridPane.setConstraints(newBlindGameButton, 0, 1);
        gameButtonsGrid.getChildren().add(newBlindGameButton);
        
        GridPane.setConstraints(newReverseGameButton, 1, 1);
        gameButtonsGrid.getChildren().add(newReverseGameButton);
        


        gameButtonsGrid.setAlignment(Pos.CENTER);
        
        Text titleText = new Text();
        
        titleText.setText("Muistipeli");
        titleText.setFont(Font.font ("Verdana", FontWeight.BOLD, 35));
        titleText.setFill(Color.SADDLEBROWN);

        gameButtons.getChildren().add(titleText);
        gameButtons.getChildren().add(gameButtonsGrid);
        gameButtons.getChildren().add(optionsButton);
        gameButtons.getChildren().add(scoresButton);
        newGamePane.setCenter(gameButtons);
        
        newGamePane.setStyle("-fx-background-color: #FFFFF0;");
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
        
        GridPane guessBottomPane = new GridPane();
        guessBottomPane.setPadding(new Insets(0, 0, 10, 0));

        
        HBox bottomButtons = new HBox();
        bottomButtons.setSpacing(10);
        
        
        guessTopPane = new GridPane();
        guessTopPane.setPadding(new Insets(30, 30, 30, 30));
        
        scoring = new Text();
        scoring.setFont(Font.font ("Verdana", 20));
        scoring.setFill(Color.SADDLEBROWN);
        
        scoring.setText("Pisteet: " + Integer.toString(newGame.getScore()));
        
        guessTopPane.getChildren().add(scoring);
        guessTopPane.setAlignment(Pos.BASELINE_CENTER);
        
        Button button1 = defineButton(1);
        button1.setStyle("-fx-text-fill: #8B4513; -fx-background-color: #D2B48C; -fx-border-color: #8B4513; -fx-border-width: 0px;");
        button1.setGraphic(greenCircleSmall);
        
        Button button2 = defineButton(2);
        button2.setStyle("-fx-text-fill: #8B4513; -fx-background-color: #D2B48C; -fx-border-color: #8B4513; -fx-border-width: 0px;");
        button2.setGraphic(redTriangleSmall);
        
        Button button3 = defineButton(3);
        button3.setStyle("-fx-text-fill: #8B4513; -fx-background-color: #D2B48C; -fx-border-color: #8B4513; -fx-border-width: 0px;");
        button3.setGraphic(yellowCircleSmall);
        
        Button button4 = defineButton(4);
        button4.setStyle("-fx-text-fill: #8B4513; -fx-background-color: #D2B48C; -fx-border-color: #8B4513; -fx-border-width: 0px;");
        button4.setGraphic(blueSquareSmall);
        
	bottomButtons.getChildren().add(button1);
	bottomButtons.getChildren().add(button2);
        bottomButtons.getChildren().add(button3);
        bottomButtons.getChildren().add(button4);
        
        bottomButtons.setAlignment(Pos.BASELINE_CENTER);
        
        guessBottomPane.getChildren().add(bottomButtons);
        guessBottomPane.setAlignment(Pos.BASELINE_CENTER);
        
        askSymbolsPane = new BorderPane();
        askSymbolsPane.setTop(guessTopPane);
        askSymbolsPane.setBottom(guessBottomPane);
        askSymbolsPane.setCenter(centerHelpLabel);

        askSymbolsPane.setStyle("-fx-background-color: #FFFFF0;");
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
                scoring.setText("Pisteet: " + Integer.toString(newGame.getScore()));
                askSymbolsPane.setTop(guessTopPane);

                if (newGame.nextRound()) {
                    showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(newGame.getRoundNumber()) + "!   Valmistaudu!"));
                    if (delayText > 0) {
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
                    }

                    this.showSymbols();
                    

                    scoring.setText("Pisteet: " + Integer.toString(newGame.getScore()));
                    askSymbolsPane.setTop(guessTopPane);
                    // guessScene = new Scene(askSymbolsPane);  blows up
                    thestage.setScene(guessScene); 
                }
            } else {
                showSymbolsPane.setCenter(new Label("Väärin! Peli loppui!   Pisteesi olivat: " + newGame.getScore()));
                this.defineEndScene();
                thestage.setScene(endGameScene);

                scoring.setText("Pisteet: 0");
                askSymbolsPane.setTop(guessTopPane);  // ??
            }
        });
        return buttonX;
   } 
    
    public void defineScoreScene() throws Exception {
                
        
        // scoreScene defined
        BorderPane scoresPane = new BorderPane();
        scoresPane.setStyle("-fx-background-color: #FFFFF0;");
        
        GridPane scoresGrid = new GridPane();
        scoresGrid.setPadding(new Insets(20, 20, 20, 20));
        scoresGrid.setVgap(10);
        scoresGrid.setHgap(30);

        
        Text modeInfo = new Text("Pelimuoto");
        GridPane.setConstraints(modeInfo, 0, 0);
        Text playerInfo = new Text("Pelaaja");
        GridPane.setConstraints(playerInfo, 1, 0);
        Text scoreInfo = new Text("Pisteet");
        GridPane.setConstraints(scoreInfo, 2, 0);
        scoresGrid.getChildren().add(modeInfo);
        scoresGrid.getChildren().add(playerInfo);
        scoresGrid.getChildren().add(scoreInfo);
        
        Text easyLabel = new Text("Helppo:");
        easyLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(easyLabel, 0, 1);
        scoresGrid.getChildren().add(easyLabel);

        Text normalLabel = new Text("Normaali:");
        normalLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(normalLabel, 0, 2);
        scoresGrid.getChildren().add(normalLabel);
        
        Text blindLabel = new Text("Sokko:");
        blindLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(blindLabel, 0, 3);
        scoresGrid.getChildren().add(blindLabel);
        
        Text reverseLabel = new Text("Reverse:");
        reverseLabel.setFill(Color.SADDLEBROWN);
        GridPane.setConstraints(reverseLabel, 0, 4);
        scoresGrid.getChildren().add(reverseLabel);
        
        

        Text easyTopScorePlayer = new Text(scoredao.bestScore("Easy").getPlayerName());
        easyTopScorePlayer.setFill(Color.BLACK);
        GridPane.setConstraints(easyTopScorePlayer, 1, 1);
        scoresGrid.getChildren().add(easyTopScorePlayer);

        Text normalTopScorePlayer = new Text(scoredao.bestScore("Normal").getPlayerName());
        normalTopScorePlayer.setFill(Color.BLACK);
        GridPane.setConstraints(normalTopScorePlayer, 1, 2);
        scoresGrid.getChildren().add(normalTopScorePlayer);
        
        Text blindTopScorePlayer = new Text(scoredao.bestScore("Blind").getPlayerName());
        blindTopScorePlayer.setFill(Color.BLACK);
        GridPane.setConstraints(blindTopScorePlayer, 1, 3);
        scoresGrid.getChildren().add(blindTopScorePlayer);
        
        Text reverseTopScorePlayer = new Text(scoredao.bestScore("Reverse").getPlayerName());
        reverseTopScorePlayer.setFill(Color.BLACK);
        GridPane.setConstraints(reverseTopScorePlayer, 1, 4);
        scoresGrid.getChildren().add(reverseTopScorePlayer);
        
        
        Text easyTopScore = new Text(Integer.toString(scoredao.bestScore("Easy").getScore()));
        easyTopScore.setFill(Color.BLACK);
        GridPane.setConstraints(easyTopScore, 2, 1);
        scoresGrid.getChildren().add(easyTopScore);

        Text normalTopScore = new Text(Integer.toString(scoredao.bestScore("Normal").getScore()));
        normalTopScore.setFill(Color.BLACK);
        GridPane.setConstraints(normalTopScore, 2, 2);
        scoresGrid.getChildren().add(normalTopScore);
        
        Text blindTopScore = new Text(Integer.toString(scoredao.bestScore("Blind").getScore()));
        blindTopScore.setFill(Color.BLACK);
        GridPane.setConstraints(blindTopScore, 2, 3);
        scoresGrid.getChildren().add(blindTopScore);
        
        Text reverseTopScore = new Text(Integer.toString(scoredao.bestScore("Reverse").getScore()));
        reverseTopScore.setFill(Color.BLACK);
        GridPane.setConstraints(reverseTopScore, 2, 4);
        scoresGrid.getChildren().add(reverseTopScore);
        
        
        
        scoresGrid.setAlignment(Pos.CENTER);
        
        scoresPane.setTop(scoresGrid);
        scoresScene = new Scene(scoresPane, 285, 260);       
        
        
    
        
        GridPane scoresSecondGrid = new GridPane();
        scoresSecondGrid.setPadding(new Insets(0, 20, 20, 20));

        
        Button resetButton = new Button("Nollaa");
        resetButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        resetButton.setOnAction((event) -> {
            try {
                database.deleteAll();
            } catch (SQLException ex) {
                System.out.println("error");
            }
            try {
                this.defineScoreScene();
            } catch (Exception ex) {
                System.out.println("error");
            }
            
            thestage.setScene(scoresScene);
        }); 

        Button exitButton = new Button("Takaisin");
        exitButton.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        exitButton.setOnAction((event) -> {
            thestage.setScene(newGameScene);
        });
  
        
        HBox scoresButtons = new HBox();
        scoresButtons.setSpacing(110);
        scoresButtons.setAlignment(Pos.CENTER); 
        
        scoresButtons.getChildren().add(exitButton);
        scoresButtons.getChildren().add(resetButton);

        GridPane.setConstraints(scoresButtons, 0, 0);
        scoresSecondGrid.getChildren().add(scoresButtons);
        scoresSecondGrid.setAlignment(Pos.CENTER);
        
        scoresPane.setBottom(scoresSecondGrid);
        

        
    }

    
    
    public void defineEndScene() {
        
        
        TextField playerNick = new TextField("nimimerkkisi");
        playerNick.setPromptText("nimimerkkisi");
        playerNick.setMaxWidth(150);
        
        endgameText = new Text("Pisteesi olivat: " + newGame.getScore());
        endgameText.setFont(Font.font ("Verdana", 20));
        endgameText.setFill(Color.SADDLEBROWN);
        
        Button backToMenu = new Button("Peruuta");
        backToMenu.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        backToMenu.setMinWidth(25);
        backToMenu.setOnAction((event) -> {
            endgameText4 = new Text (" ");
            thestage.setScene(newGameScene);
        });
        
        Button saveScore = new Button("Tallenna");
        saveScore.setStyle("-fx-font-size: 1.2em; -fx-text-fill: #8B4513; -fx-background-color: #FFF8DC; -fx-border-color: #DEB887; -fx-border-width: 1px;");
        saveScore.setOnAction((event) -> {
            String nick = playerNick.getText();
            if (nick.length() == 0) {
                endgameText4 = new Text ("liian lyhyt");
                this.defineEndScene();
            }
            if (nick.length() > 10) {
                endgameText4 = new Text ("liian pitkä (max 10)");
                this.defineEndScene();
            }
            thestage.setScene(endGameScene);
            if (nick.length() > 0 && nick.length() <= 10) {
                int i = 0;
                boolean validNick = true;
                while (i < nick.length()) {
                    if (!Character.isLetter(nick.charAt(i))) {
                        validNick = false;
                    }
                    i++;
                }
                if (validNick) {
                    
                    Score highScore = new Score(nick, newGame.getScore(), newGame.getMode());
                    try {
                        scoredao.saveScore(highScore);
                    } catch (SQLException ex) {
                        System.out.println("error");
                    }
                    
                    try {
                        this.defineScoreScene();
                    } catch (Exception ex) {
                        System.out.println("error");
                    }
                    endgameText4 = new Text (" ");
                    thestage.setScene(newGameScene);
                } else {
                    endgameText4 = new Text ("vain kirjaimet ovat sallittuja");
                    this.defineEndScene();
                    thestage.setScene(endGameScene);
                }

            }
            
            
            
        });
        

        
        BorderPane endgamePane = new BorderPane();
        VBox endgame = new VBox();
        
        endgame.getChildren().add(new Text("Väärin! Peli loppui!"));
        endgame.getChildren().add(new Text(""));
        endgame.getChildren().add(endgameText);
        endgame.getChildren().add(new Text(""));
        endgame.getChildren().add(new Text(""));
        endgame.getChildren().add(new Text("Haluatko tallentaa pisteesi?"));
        endgame.getChildren().add(new Text(""));
        endgame.getChildren().add(playerNick);
        endgame.getChildren().add(new Text(""));
        
        HBox endgameButtons = new HBox();
        endgameButtons.getChildren().add(backToMenu);
        endgameButtons.getChildren().add(saveScore);
        endgameButtons.setSpacing(25);
        endgameButtons.setAlignment(Pos.CENTER);
        endgame.getChildren().add(endgameButtons);
        endgame.setAlignment(Pos.CENTER);
        endgame.getChildren().add(new Text(""));
        endgame.getChildren().add(endgameText4);
        
        endgamePane.setCenter(endgame);
        endgamePane.setStyle("-fx-background-color: #FFFFF0;");
        endGameScene = new Scene(endgamePane, 285, 250);
    }
    
    
    public void showSymbols() { 
        showSymbolsPane.setCenter(new Label("Kierros " + Integer.toString(newGame.getRoundNumber()) + "!   Valmistaudu!"));
        thestage.setScene(showSymbolsScene);


        delay1 = delayText;

        // haetaan symbolit       
        while (true) {
            // printtaa ruudulle haetun mukaisen symbolin, toisin sanoen vaihtaa laatikon väriä (ehkä olisi mukavampi jos olisi värillinen ja jonkin muotoinen)
            // pitääkö jokaisella värillä olla erillinen scene? vai miten vanhaa sceneä updatetaan?
            int print = this.newGame.nextSymbol();
            
            if (print > 0) {
                
                if (print == 1) {
                    int delay2 = delay1;
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
                }
                if (print == 2) {
                    int delay2 = delay1;
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
                }
                if (print == 3) {
                    int delay2 = delay1;
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
                }
                if (print == 4) {
                    int delay2 = delay1;
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
                }

            } else {   // jos print on nolla, niin hypätään seuraavaan vaiheeseen
                // System.out.println("Paina painikkeita juuri näkemässäsi järjestyksessä!");
                break;
            }

            delay1 = delay1 + delaySymbol;
        }

        Thread thread5 = new Thread(() -> {
            try {
                int delay2 = delay1;
                Thread.sleep(delay2);
            } catch (InterruptedException exc) {
                throw new Error("Unexpected interruption", exc);
            }
            Platform.runLater(() -> thestage.setScene(guessScene));
        });
        thread5.setDaemon(true);
        thread5.start();
    }
    
        
}
