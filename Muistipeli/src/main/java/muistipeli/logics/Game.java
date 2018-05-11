
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
    public int difficulty;
    public boolean ranked;
    public int startingRound;
    public int startingDifficulty;


    /**
     * Konstruktori alustaa pelin.
     * 
     * @param   chosenDifficulty   Kuinka monella symbolilla symboliketju kasvaa kunkin 
     * kierroksen alussa, pelaajan valitsema parametri
     * @param   chosenStart   Aloituskierroksen numero, pelaajan valitsema
     */   
    public Game(int chosenDifficulty, int chosenStart) {
        this.roundNumber = chosenStart;
        this.startingRound = chosenStart;
        this.difficulty = chosenDifficulty;
        this.startingDifficulty = chosenDifficulty;
        this.configure(chosenDifficulty, chosenStart);
        if (this.difficulty == 0) {
            this.difficulty = 1;
        }
        this.score = 0;
        this.roundPassed = false;
        this.symbolNumber = 0;
        this.ranked = true;
        
    }
    
    
    /**
     * Metodi palauttaa ketjusta seuraavan symbolin ja siirtää seuraavaksi tarkasteltavaa paikkaa yhden eteenpäin.
     * Mikäli symbolia ei ole (eli ketju on lopussa), metodi palauttaa 0 ja asettaa seuraavaksi tarkasteltavan paikan nollaan.
     * 
     * @return ketjun seuraava symboli
     */
    public int nextSymbol() {
        if (this.roundNumber*this.difficulty <= this.symbolNumber) {
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
        if (this.symbolNumber >= this.roundNumber*this.difficulty) {
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
     * Metodia käytetään pelin konfigurointiin parametrina annettujen aloitusasetuksien mukaan.
     * 
     * @param   chosenDifficulty   Kuinka monella symbolilla symboliketju kasvaa kunkin 
     * kierroksen alussa, pelaajan valitsema parametri
     * @param   chosenStart   Aloituskierroksen numero, pelaajan valitsema
     * 
     * @return boolean, onnistuiko konfigurointi
     */   
    private boolean configure(int chosenDifficulty, int chosenStart) {
        if (chosenDifficulty > 0 && chosenDifficulty < 100 && chosenStart> 0 && chosenStart < 100) {
            this.roundX = new Round(this.roundNumber*this.difficulty);
            this.ranked = false;
            return true;            
        }
        if (chosenDifficulty == 0 && chosenStart> 0 && chosenStart < 100) {
            this.roundX = new Round(this.roundNumber);
            this.ranked = false;
            return true;            
        }
        return false;
    } 
    
    
    
//     * @param   chosenDelay   Kuinka nopeasti pelaajalle näytetään symboliketjun
//     * symboleita, pelaajan valitsema parametri, sekunnin kymmenesosissa
    
    
    /**
     * Metodi tarkastaa, onko pelaaja läpäissyt kierroksen. 
     * Mikäli on, metodi alustaa seuraavan kierroksen.
     * 
     * @return boolean, siirrytäänkö uudelle kierrokselle
     */       
    public boolean nextRound() {
        if (this.roundPassed) {
            this.roundPassed = false;
            this.symbolNumber = 0;
            if (this.startingDifficulty == 0) {  // jos difficulty 0, niin pitäydytään samassa rundissa
                this.roundX = new Round(this.startingRound);
                return true;
            }
            this.roundNumber++;
            this.roundX = new Round(this.roundNumber*this.difficulty);
            return true;
        }
        return false;
    }
}
