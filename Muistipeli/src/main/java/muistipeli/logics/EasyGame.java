package muistipeli.logics;

/**
 * EasyGame vastaa yhden "helpon" pelin pelaamisesta, 
 * missä symboliketju säilyy läpi kierrosten samana.
 */ 
public class EasyGame extends Game {
    

    
    public EasyGame() {
        super();
    }
    
    
    /**
     * Metodi tarkastaa, onko pelaaja läpäissyt kierroksen. 
     * Mikäli on, metodi alustaa seuraavan kierroksen.
     * 
     * @return siirrytäänkö uudelle kierrokselle
     */
    @Override
    public boolean nextRound() {
        if (this.roundPassed) {
            this.roundPassed = false;
            this.symbolNumber = 0;
            this.roundNumber++;
            this.roundX.nextRound();
            this.roundX.setMarker(0);
            return true;
        }
        return false;
    }

    
    
    
}
