
package muistipeli.gamemodes;

import muistipeli.logics.Game;

/**
 * BlindGame vastaa yhden "sokko" pelin pelaamisesta. 
 * Pelimuoto vastaa muilta osin "helppoa" peliä, paitsi pelaajalle paljastetaan 
 * vain ketjun viimeisin (uusi) symboli jokaisella kierroksella.
 */  

public class BlindGame extends Game {
    
    public BlindGame(int chosenDifficulty, int chosenStart) {
        super(chosenDifficulty, chosenStart);
        this.mode = "Blind";
    }

    
    /**
     * Metodi palauttaa ketjusta seuraavan symbolin ja siirtää seuraavaksi tarkasteltavaa paikkaa yhden eteenpäin.
     * Mikäli symbolia ei ole (eli ketju on lopussa), metodi palauttaa 0 ja asettaa seuraavaksi tarkasteltavan paikan nollaan.
     * 
     * @return ketjun seuraava symboli
     */ 
    @Override
    public int nextSymbol() {
        if (this.roundNumber * this.difficulty <= this.symbolNumber) {
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
     * Metodi tarkastaa, onko pelaaja läpäissyt kierroksen. 
     * Mikäli on, metodi alustaa seuraavan kierroksen.
     * 
     * @return siirrytäänkö uudelle kierrokselle
     */    
    @Override
    public boolean nextRound() {
        if (this.roundPassed) {
            this.roundPassed = false;
            if (this.startingDifficulty == 0) {  // jos difficulty 0, niin pitäydytään samassa rundissa
                return true;
            }
            this.roundNumber++;
            this.roundX.nextRound(this.difficulty);
            this.roundX.moveMarker();
            return true;
        }
        return false;
    }    
    
}
