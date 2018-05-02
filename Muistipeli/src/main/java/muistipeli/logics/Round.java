
package muistipeli.logics;


/**
 * Round luokka vastaa yhden kierroksen pelaamisesta.
 */

public class Round {
    private int marker;   // marker on ketjun kohdassa, jota kulloinkin tarkastellaan
    private SymbolChain chain;
    
    /**
     * Konstruktori alustaa kierroksen luomalla kierroksen 
     * numeroa vastaan pituisen ketjun symboleita.
     * 
     * @param   roundNumber   Kulloisen kierroksen numero, määrittää tarvittavan kokoisen koon symboliketjulle
     */   
    public Round(int roundNumber) {
        this.marker = 0;
        this.chain = new SymbolChain(roundNumber);
    }
    
    /**
     * Metodi palauttaa markkerin osoittaman, eli kulloisen, numeron ketjusta.
     * 
     * @return Tarkasteltavan paikan symboli, tai 0 jos symbolia ei ole.
     */ 
    public int currentSymbol() {        
        // markkerin ei pitäisi ikinä olla liian suuri, mutta tämä nyt kuitenkin varmistuksena
        if (this.marker >= this.chain.getSize()) {
            return 0;
        }        
        return this.chain.getSymbol(this.marker);
    }
    
    
    /**
     * Metodi vertaa parametrina annettua symbolia tämän hetkiseen symboliin.
     * 
     * @param   symbol   Vertailtava symboli
     * 
     * @return vastaako parametrin symboli todellista symbolia
     */ 
    public boolean compare(int symbol) {
        if (symbol == this.currentSymbol()) {
            return true;
        }
        return false;
    }
    
    
    /**
     * Metodi liikuttaa markeria yhden eteenpäin, mikäli marker ei ole jo
     * ketjun päädyssä.
     * 
     * @return onnistuiko liikutus
     */ 
    public boolean moveMarker() {
        if (this.marker < (this.chain.getSize() - 1)) {
            this.marker = this.marker + 1;
            return true;
        }
        return false; 
    }
    
    public int getMarker() {
        return this.marker;
    }
    
    
    /**
     * Metodi asettaa markerin haluttuun kohtaan, ja palauttaa true, 
     * mikäli asetus onnistuu.
     * 
     * @param   number   Markerin uusi haluttu kohta
     * 
     * @return onnistuiko markerin asetus
     */ 
    public boolean setMarker(int number) {
        if (number < 0) {
            return false;
        }
        if (number >= this.chain.getSize()) {
            return false;
        }
        this.marker = number;
        return true;
    }
    
    /**
     * Metodi alustaa uuden kierroksen lisäämällä vanhan symboliketjun
     * loppuun uuden symbolin.
     */
    public void nextRound() {
        // this.marker = 0;
        this.chain.addSymbol();
    }
    
}
