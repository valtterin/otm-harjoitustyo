package muistipeli.logics;

/**
 * EasyGame vastaa yhden "helpon" pelin pelaamisesta, 
 * missä symboliketju säilyy läpi kierrosten samana.
 */ 
public class EasyGame extends Game {
    

    
    public EasyGame(int chosenDifficulty, int chosenStart) {
        super(chosenDifficulty, chosenStart);
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
            this.roundX.setMarker(0);
            if (this.startingDifficulty == 0) {  // jos difficulty 0, niin pitäydytään samassa rundissa
                return true;
            }
            this.roundNumber++;
            this.roundX.nextRound(this.difficulty);
            return true;
        }
        return false;
    }

    
    
    
}
