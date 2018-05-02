package muistipeli.logics;

import java.util.ArrayList;
import java.util.Random;


/**
 * SymbolChain luokka luo halutun pituisen ketjun symboleita (numeroita)
 */
public class SymbolChain {
    
    private ArrayList<Integer> chain;
    
    /**
     * Konstruktori luo halutun kokoisen listan, 
     * ja täyttää sen satunnaisilla numeroilla väliltä 1-4.
     * 
     * Sama numero ei voi esiintyä listassa peräkkäisillä sijoilla.
     * 
     * @param   length   Listan haluttu koko
     */
    public SymbolChain(int length) {
        
        this.chain = new ArrayList<>();
        
        while (true) {
            if (this.chain.size() == length) {
                break;
            }

            Random rand = new Random();
            int randomNmbr = rand.nextInt(4) + 1;
            
            if (this.chain.size() != 0) {
                if (randomNmbr != this.chain.get(this.chain.size() - 1)) {
                    this.chain.add(randomNmbr);
                }
            } else {
                this.chain.add(randomNmbr);
            }
            
        }
        
        
    }
    
    
    /**
     * Metodi palauttaa ketjusta parametrina annetun paikan symbolin numeron.
     *
     * @param   number   Tiedusteltavan symbolin paikka ketjussa
     * 
     * @return symbolin numero
     */
    public int getSymbol(int number) {
        
        // varmistetaan, että annettu parametri number on oikealta väliltä
        if (number >= this.chain.size()) {
            return 0;
        }
        
        if (number < 0) {
            return 0;
        }
        
        return this.chain.get(number);
    }
    
    
    /**
     * Metodi lisää yhden uuden symbolin ketjun loppuun.
     */
    public void addSymbol() {
        // tähän toiminnallisuus satunnaisten numeroiden arpomiseen ja lisäämiseen listaan
        // this.chain.add(4);   //placeholder
        while (true) {
            // tähän toiminnallisuus satunnaisten numeroiden arpomiseen ja lisäämiseen listaan
            // this.chain.add(4);   //placeholder
            Random rand = new Random();
            int randomNmbr = rand.nextInt(4) + 1;
            
            // katsotaan, onko viimeisin numero sama kuin edellinen, jos on niin arvotaan uusi numero
            if (this.chain.size() != 0) {
                if (randomNmbr != this.chain.get(this.chain.size() - 1)) {
                    this.chain.add(randomNmbr);
                    break;
                }
            } else {
                this.chain.add(randomNmbr);
            }
            
        }
    }
    
    
    /**
     * Metodi palauttaa ketjun koon.
     * 
     * @return ketjun koko
     */
    public int getSize() {
        return this.chain.size();
    }
    
    
    
}
