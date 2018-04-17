
package muistipeli.muistipeli;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class main extends Application {
    
    NormalGame testi;
    Label score = new Label ("Pisteet: ");
//    Scene nakyma;
//    BorderPane asettelu;
    
    @Override
    public void start(Stage ikkuna) {
        
        HBox bottomButtons = new HBox();
	bottomButtons.setSpacing(10);
        
        
        
        Button button1 = new Button("Yksi");
        button1.setOnAction((event) -> {
            System.out.println("Vastasit: 1");
            testi.compareAnswer(1);
            //testi.gameStatus();
        });
        
        Button button2 = new Button("Kaksi");
        button2.setOnAction((event) -> {
            System.out.println("Vastasit: 2");
            testi.compareAnswer(2);
            //testi.gameStatus();
        });
        
        Button button3 = new Button("Kolme");
        button3.setOnAction((event) -> {
            System.out.println("Vastasit: 3");
            testi.compareAnswer(3);
            //testi.gameStatus();
        });
        
        Button button4 = new Button("Neljä");
        button4.setOnAction((event) -> {
            System.out.println("Vastasit: 4");
            testi.compareAnswer(4);
            //testi.gameStatus();
//            Label score1 = new Label ("Pisteet: 1");
//            asettelu.setTop(score1);
//            nakyma = new Scene(asettelu);
//            ikkuna.setScene(nakyma);
//            ikkuna.show();
        });
        
        Button button5 = new Button("New Game");
        button5.setOnAction((event) -> {
            testi = new NormalGame();
            //testi.showSymbols();
            //testi.askSymbols();
        });

	bottomButtons.getChildren().add(button1);
	bottomButtons.getChildren().add(button2);
        bottomButtons.getChildren().add(button3);
        bottomButtons.getChildren().add(button4);
        bottomButtons.getChildren().add(button5);
        
        
        
        BorderPane asettelu = new BorderPane();
        asettelu.setTop(score);
        asettelu.setRight(new Label("oikea laita"));
        asettelu.setBottom(bottomButtons);
        asettelu.setLeft(new Label("vasen laita"));
        asettelu.setCenter(new Label("keskikohta"));

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
        
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
        launch(main.class);

    }
        
}


