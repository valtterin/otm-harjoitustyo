
package muistipeli.muistipeli;


public class NormalGameUI {
    
    private NormalGame normalgame;
    
    // kun "New Game" tai "Normal Game" painiketta painetaan
    public NormalGameUI() {
        this.normalgame = new NormalGame();
    }
    
    public void launchGame() {
        
        // set scene from New Game -scene to ShowSymbols -scene
        this.showSymbolsScene();
        // set scene painikkeet
        this.buttonsScene(); 
        // odotetaan käyttäjän inputtia
    }
    
    public void showSymbolsScene() {
        // includes just a box where to print all the symbols, before that round number and "get ready!)
        
        System.out.println("Kierros: " + this.normalgame.getRoundNumber());
        System.out.println("Valmistaudu!");
        
        // haetaan symbolit       
        while(true) {
            // printtaa ruudulle haetun mukaisen symbolin, toisin sanoen vaihtaa laatikon väriä (ehkä olisi mukavampi jos olisi värillinen ja jonkin muotoinen)
            // pitääkö jokaisella värillä olla erillinen scene? vai miten vanhaa sceneä updatetaan?
            int print = this.normalgame.nextSymbol();
            if (print > 0) {
                System.out.println(print);
            } else {   // jos print on nolla, niin hypätään seuraavaan vaiheeseen
                break;
            }
        }
        
        
            
    }
    
    public void buttonsScene() {
        System.out.println("Paina painikkeita näkemässäsi järjestyksessä!");
        // painikkeet scene pitää sisällään neljä painiketta, boksin johon printataan ohjeita, ja scoren, ja kierroksen numeron
        
        // aluksi riittää vain ne neljä painiketta
        // yhden painikkeen funktionaalisuus:
        
        
        // yksi painike:
//        if (this.normalgame.compareAnswer(buttonNumber)) {
//            updates score to getScore()
//            if (this.normalgame.nextRound()) {
//                this.showSymbolsScene();
//                this.buttonsScene(); 
//            }
//        } else {
//            call method gameOver: change scene to game over, score: getScore,  new game?
//        }
//	   meneekö tässä ristiin: tämän napin funktionaalisuus ladataan uudestaan, vaikka ollaan vielä toteuttamassa tämän napin koodia?   
// buttons could have their own method too, this.buttonFunction(int buttonNumber


    }
    
}
