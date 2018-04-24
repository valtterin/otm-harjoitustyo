
package muistipeli.domain;

// import java.util.concurrent.TimeUnit;

// tämä classi vastaa yhden normaalin pelin pelaamisesta
public class NormalGame {
    
    private int roundNumber;
    private int score;
    private Round roundx;
    private boolean roundPassed;
    private int symbolnmbr;
    
    public NormalGame() {
        this.roundNumber = 1;
        this.score = 0;
        this.roundx = new Round(this.roundNumber);   // oma metodi myös näille
        this.roundPassed = false;
        this.symbolnmbr = 0;
    }
    
    
    // kertoo NormalGameUI:lle, että mikä symboli tulisi käyttäjälle näyttää, ja siirtää markkereita eteenpäin
    // palauttaa 0, jossei ole mitään näytettävää
    public int nextSymbol() {
        if (this.roundNumber <= this.symbolnmbr) {
            this.symbolnmbr = 0;
            this.roundx.setMarker(0);
            return 0;
        }
        
        int currentSymbol = this.roundx.currentSymbol();
        this.roundx.moveMarker();
        this.symbolnmbr++;
        return currentSymbol;                      
    } 
 
    
    public boolean compareAnswer(int buttonNumber) {
        if (this.roundx.compare(buttonNumber)) {
            this.score++;
            this.roundx.moveMarker();
            this.symbolnmbr++;
        } else {
            return false;
        }
        // jos pelaaja sai kaikki numerot oikein, poistutaan loopista
        if (this.symbolnmbr >= this.roundNumber) {
            this.roundPassed = true;
        }
        return true;
    }
    
    
    public int getRoundNumber() {
        return this.roundNumber;
    }
    
    public int getScore() {
        return this.score;
    }
    
    
    // metodin avulla NormalGameUI tietää milloin tulee siirtyä eri sceneen    
    public boolean nextRound() {
        // alustetaan uusi kierros
        if (this.roundPassed) {
            this.roundPassed = false;
            // this.roundx.setMarker(0);   // tarvitaanko tätä edes? ei kai, koska markkeri menee nollaan uuden rundin luonnin yhteydessä
            this.symbolnmbr = 0;  // lähdetään liikkeelle ensimmäisestä symbolista
            this.roundNumber++;
            this.roundx = new Round(this.roundNumber);
            return true;
        }
        return false;
    }

    
    
    
}
