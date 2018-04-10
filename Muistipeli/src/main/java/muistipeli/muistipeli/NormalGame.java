
package muistipeli.muistipeli;


import java.util.Scanner;
// import java.util.concurrent.TimeUnit;

// tämä classi vastaa yhden normaalin pelin pelaamisesta
// tämä classi on aika karseassa tilassa
// työstän järkevämpää rakennetta sovellukselle
public class NormalGame {
    
    private int roundNumber;
    private int score;
    private Round roundx;
    private boolean wrongAnswer;
    private boolean roundPassed;
    private int symbolnmbr;
    private Scanner reader = new Scanner(System.in);
    
    public NormalGame() {
        this.roundNumber = 0;
        this.score = 0;
        this.roundNumber++;
        this.roundx = new Round(this.roundNumber);   // oma metodi myös näille
        this.wrongAnswer = false;
        this.roundPassed = false;
    }

    
    // näyttää pelaajalle symboliketjun symbolit
    // pitää varmaan toteuttaa osaksi ylemmässä UI classissa
    public void showSymbols() {
        // näytetään käyttäjälle kaikki symbolchainin symbolit
        this.roundPassed = false;
        this.symbolnmbr = 0;
        this.roundx.setMarker(0);
        System.out.println("Kierros: " + this.roundNumber);

        // sleepille tarvitaan oma metodi, ettei tule tätä jäätävää toistoa, purkkaa
        this.sleepTime(2);
        System.out.println("Paina mieleesi seuraava symboli-ketju!");
        this.sleepTime(2);
        while(this.symbolnmbr < this.roundNumber) {
            // tähän kohtaan tarvitaan myöhemmin muuta (graafisen käyttöliittymän päivitystä)
            // ehkä parempi luoda uusi classi joka handlaa nämä asiat
            System.out.println(this.roundx.currentSymbol());
            this.roundx.moveMarker();
            this.symbolnmbr++;
            this.sleepTime(2);
        }
        // käytetään tulevissa metodeissa
        this.symbolnmbr = 1;  // tämän voi ehkä poistaa
        this.roundx.setMarker(0);                
    }    
    
    // päivittää ui:n kysymään, että mikä oli symboli ja aktivoi painikkeet  (voisi ehkä olla osa interaktiota)
    public void askSymbols() {
        // System.out.println("Mikä oli " + this.symbolnmbr + ". symboli?"); 
        System.out.println("Paina painikkeita näkemässäsi järjestyksessä!"); 
    }
    
    // ylempään classiin varmaan pitää lisätä linkki uuteen classiin, joka palauttaa nappulan inputin
    public boolean compareAnswer(int buttonNumber) {
        if (this.roundx.compare(buttonNumber)) {
            System.out.println("Oikein!");
            this.score++;
            this.roundx.moveMarker();
            this.symbolnmbr++;
        } else {
            System.out.println("Väärä vastaus!");
            this.wrongAnswer = true;
        }
        // jos pelaaja sai kaikki numerot oikein, poistutaan loopista
        if (this.symbolnmbr > this.roundNumber) {
            this.roundPassed = true;  // siirrä alkuun
        }
        return true;
    }
    
    public void gameStatus() {
        if (this.wrongAnswer) {
            // end game, change scene, display score
            this.sleepTime(2);
            System.out.println("Peli päättyi! Pisteesi olivat " + this.score + "!");
            this.roundPassed = false;
            this.sleepTime(2);
        }
        if (this.roundPassed) {
            // move to next round: inaktivoi vastausnapit, callaa metodia showSymbols, nostetaan kierroksen numeroa, siirretään marker nollaan
            // pitää varmaan nämä jutut siirtää UI classiin, ja jättää kaksi metodia palauttamaan true/false riippuen valueista
            // pystyykö tämä classi ylipäänsä päivittämään UI:ta?
            this.roundNumber++;
            this.roundx = new Round(this.roundNumber);
            // this.roundx.setMarker(0);   // showsymbolissa
            System.out.println("Onneksi olkoon, pääsit seuraavalle kierrokselle!");
            this.sleepTime(4);
            this.showSymbols();
            this.askSymbols();
        }
        
        // tähän tarvitsisi if lauseen yllä olevan tapaan tarkastamaan että milloin käytetään metodia ask symbols
        
    }
    
    public int getScore() {
        return this.score;
    }
        
          
    
    // nukutaan tietty määrä sekunteja
    public void sleepTime(int time) {
         try {
            Thread.sleep(time*1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }   
    }
    
}
