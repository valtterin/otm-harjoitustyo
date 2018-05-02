
package muistipeli.logics;

/**
 * Game vastaa yhden normaalin pelin pelaamisesta, 
 * sekä toimii pohjana muille pelimuodoille.
 * 
 * Normaalissa pelissä pelaajan tulee muistaa neljästä eri tyyppisestä 
 * symbolista koostuva symboliketju.
 */  
public class Game {
    public int roundNumber;
    public int score;
    public Round roundX;
    public boolean roundPassed;
    public int symbolNumber;


    /**
     * Konstruktori alustaa pelin
     */    
    public Game() {
        this.roundNumber = 1;
        this.score = 0;
        this.roundX = new Round(this.roundNumber);   // oma metodi myös näille
        this.roundPassed = false;
        this.symbolNumber = 0;
    }
    
    
    /**
     * Metodi palauttaa ketjusta seuraavan symbolin ja siirtää seuraavaksi tarkasteltavaa paikkaa yhden eteenpäin.
     * Mikäli symbolia ei ole (eli ketju on lopussa), metodi palauttaa 0 ja asettaa seuraavaksi tarkasteltavan paikan nollaan.
     * 
     * @return ketjun seuraava symboli
     */
    public int nextSymbol() {
        if (this.roundNumber <= this.symbolNumber) {
            this.symbolNumber = 0;
            this.roundX.setMarker(0);
            return 0;
        }
        
        int currentSymbol = this.roundX.currentSymbol();
        this.roundX.moveMarker();
        this.symbolNumber++;
        return currentSymbol;                      
    } 
 
    /**
     * Metodi vertaa parametrina annettua symbolia sen hetkiseen tarkasteltavaan ketjun symboliin,
     * ja siirtää pelin sisäistä tilannetta yhden askeleen eteenpäin.
     * 
     * @param   buttonNumber   Painetun nappulan numero, eli pelaajan arvaama/muistama symboli
     * 
     * @return pelaajan arvauksen oikeellisuus
     */   
    public boolean compareAnswer(int buttonNumber) {
        if (this.roundX.compare(buttonNumber)) {
            this.score++;
            this.roundX.moveMarker();
            this.symbolNumber++;
        } else {
            return false;
        }
        // jos pelaaja sai kaikki numerot oikein, poistutaan loopista
        if (this.symbolNumber >= this.roundNumber) {
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
    
    /**
     * Metodi tarkastaa, onko pelaaja läpäissyt kierroksen. 
     * Mikäli on, metodi alustaa seuraavan kierroksen.
     * 
     * @return siirrytäänkö uudelle kierrokselle
     */       
    public boolean nextRound() {
        if (this.roundPassed) {
            this.roundPassed = false;
            this.symbolNumber = 0;  // lähdetään liikkeelle ensimmäisestä symbolista
            this.roundNumber++;
            this.roundX = new Round(this.roundNumber);
            return true;
        }
        return false;
    }
}
