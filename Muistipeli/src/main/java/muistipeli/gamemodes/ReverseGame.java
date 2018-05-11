
package muistipeli.gamemodes;

import muistipeli.logics.Game;


public class ReverseGame extends Game {
    
    public ReverseGame(int chosenDifficulty, int chosenStart) {
        super(chosenDifficulty, chosenStart);
    }
    

    /**
     * Metodi palauttaa ketjusta seuraavan symbolin ja siirtää seuraavaksi tarkasteltavaa paikkaa yhden eteenpäin.
     * Mikäli symbolia ei ole (eli ketju on lopussa), metodi palauttaa 0.
     * 
     * @return ketjun seuraava symboli
     */    
    @Override
    public int nextSymbol() {
        if (this.roundNumber*this.difficulty <= this.symbolNumber) {
            return 0;
        }
        
        int currentSymbol = this.roundX.currentSymbol();
        this.roundX.moveMarker();
        this.symbolNumber++;
        return currentSymbol;                      
    } 
    

    /**
     * Metodi vertaa parametrina annettua symbolia sen hetkiseen tarkasteltavaan ketjun symboliin,
     * ja siirtää pelin sisäistä tilannetta yhden askeleen eteenpäin ("taaksepäin" tässä pelimuodossa).
     * 
     * @param   buttonNumber   Painetun nappulan numero, eli pelaajan arvaama/muistama symboli
     * 
     * @return pelaajan arvauksen oikeellisuus
     */
    @Override
    public boolean compareAnswer(int buttonNumber) {
        if (this.roundX.compare(buttonNumber)) {
            this.score++;
            this.roundX.setMarker(this.roundX.getMarker() - 1);
            this.symbolNumber--;
        } else {
            return false;
        }
        // jos pelaaja sai kaikki numerot oikein, poistutaan loopista
        if (this.symbolNumber == 0) {
            this.roundPassed = true;
        }
        return true;
    }
}
