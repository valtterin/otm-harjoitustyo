
package muistipeli.muistipeli;


// Round käsittelee pelin yhtä kierrosta: Round pitää kirjaa siitä, mitä symbolia kulloinkin käsitellään
public class Round {
    private int marker;   // marker on ketjun kohdassa, jota kulloinkin tarkastellaan
    private SymbolChain chain;
    
    // uusi kierros: asettaa markkerin nollaan ja luo symboliketjun jonka pituus vastaa kierroksen numeroa
    public Round(int roundNmbr){
        this.marker = 0;
        this.chain = new SymbolChain(roundNmbr);
    }
    
    // palauttaa markkerin osoittaman symbolin ketjusta
    public int currentSymbol() {        
        // jos marker on liian iso, palautetaan nolla
        // markkerin ei pitäisi ikinä olla liian suuri, mutta tämä nyt kuitenkin varmistuksena
        if (this.marker >= this.chain.getSize()) {
            return 0;
        }        
        return this.chain.getSymbol(this.marker);
    }
    
    
    // vertaa annettua symbolia sen hetkiseen symboliin, palauttaa true jos samat
    // voisi ehkä siirtää johkin toiseen classiin
    public boolean compare(int symbol) {
        if (symbol == this.currentSymbol()) {
            return true;
        }
        return false;
    }
    
    
    // liikuttaa markkeria yhden eteenpäin, mikäli listan koko sallii
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
    
    
    
    
    
    //////////////////////////////////
    // muita metodeita tulevan varalta:
    
    // asettaa markkerin haluttuun kohtaan ja palauttaa true
    // jos kohta ei ole validi, palautetaan false
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
    
    // aloittaa uuden kierroksen, mutta säilyttää nykyisen symboliketjun
    // markkeri laitetaan nollaan ja symboliketjun pituutta lisätään yhdellä
    public void nextRound() {
        this.marker = 0;
        this.chain.addSymbol();
    }
    
}
