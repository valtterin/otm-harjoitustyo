
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
            testi.gameStatus();
        });
        
        Button button2 = new Button("Kaksi");
        button2.setOnAction((event) -> {
            System.out.println("Vastasit: 2");
            testi.compareAnswer(2);
            testi.gameStatus();
        });
        
        Button button3 = new Button("Kolme");
        button3.setOnAction((event) -> {
            System.out.println("Vastasit: 3");
            testi.compareAnswer(3);
            testi.gameStatus();
        });
        
        Button button4 = new Button("Neljä");
        button4.setOnAction((event) -> {
            System.out.println("Vastasit: 4");
            testi.compareAnswer(4);
            testi.gameStatus();
//            Label score1 = new Label ("Pisteet: 1");
//            asettelu.setTop(score1);
//            nakyma = new Scene(asettelu);
//            ikkuna.setScene(nakyma);
//            ikkuna.show();
        });
        
        Button button5 = new Button("New Game");
        button5.setOnAction((event) -> {
            testi = new NormalGame();
            testi.showSymbols();
            testi.askSymbols();
        });

	bottomButtons.getChildren().add(button1);
	bottomButtons.getChildren().add(button2);
        bottomButtons.getChildren().add(button3);
        bottomButtons.getChildren().add(button4);
        
        
        
        BorderPane asettelu = new BorderPane();
        asettelu.setTop(button5);

        asettelu.setBottom(bottomButtons);

        VBox info1 = new VBox();
        info1.getChildren().add(new Label(""));
        info1.getChildren().add(new Label("Tämä on purkka käyttöliittymä sovelluksen toiminnallisuuden havainnollistamiseksi."));
        info1.getChildren().add(new Label(""));
        info1.getChildren().add(new Label("Paina 'New Game' -painiketta ensin."));
        info1.getChildren().add(new Label(""));
        info1.getChildren().add(new Label("Sovellus ei osaa vielä päivittää graafista käyttöliittymää,"));
        info1.getChildren().add(new Label("joten varsinainen teksti printtaantuu outputtiin."));
        info1.getChildren().add(new Label(""));
        asettelu.setCenter(info1);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
        
    }

    public static void main(String[] args) {
        launch(main.class);

    }
}
//    public static void main(String[] args) {
//        NormalGame testi = new NormalGame();
//    }
    
