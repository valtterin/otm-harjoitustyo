package domain;

import java.util.ArrayList;
import java.util.Random;


// SymbolChain luo halutun pituisen ketjun numeroita (eli pelimme tapauksessa "symboleita")

public class SymbolChain {
    
    private ArrayList<Integer> chain;
    
    // voitaisiin lisätä parametri int complexity, jolla päätetään kuinka montaa mahdollista symbolia ketjusta löytyy
    public SymbolChain(int length) {
        
        this.chain = new ArrayList<>();
        
        // while lauseella täytetään listaan satunnaisia numeroita("symboleita") väliltä 1-4 parametrin length verran
        while (true) {
            if (this.chain.size() == length) {
                break;
            }
            // tähän toiminnallisuus satunnaisten numeroiden arpomiseen ja lisäämiseen listaan
            // this.chain.add(4);   //placeholder
            Random rand = new Random();
            int randomNmbr = rand.nextInt(4) + 1;
            this.chain.add(randomNmbr);
        }
        
        
    }
    
    
    // getSymbol palauttaa listasta X:n symbolin/numeron, jos X on väärältä väliltä metodi palauttaa nollan
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
    
    
    // lisää yhden uuden symbolin/numeron listan loppuun
    public void addSymbol() {
        // tähän toiminnallisuus satunnaisten numeroiden arpomiseen ja lisäämiseen listaan
        // this.chain.add(4);   //placeholder
        Random rand = new Random();
        int randomNmbr = rand.nextInt(4) + 1;
        this.chain.add(randomNmbr);
    }
    
    
    // palauttaa symbolilistan koon
    public int getSize() {
        return this.chain.size();
    }
    
    
    
}
