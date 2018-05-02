package muistipeli.logics;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseGameTest {
    Game test;
    
    @Before
    public void setUp() {
        test = new ReverseGame();
    }
    
    @Test
    public void nextSymbolWorks() {
        int symbol = this.test.nextSymbol();
        assertTrue(1 <= symbol && symbol <= 4);
    }
    
    @Test
    public void nextSymbolReturnsZero() {
        this.test.nextSymbol();
        int symbol = this.test.nextSymbol();
        assertEquals(0, symbol);
    }
    
    @Test
    public void compareAnswerFalse() {
        assertTrue(!this.test.compareAnswer(5));
    }
    
    // tämä testi on purkkaa
    // toimii vain, koska kyseessä ensimmäinen kierros
    // brutaalisti käydään kaikki mahdolliset vastaukset läpi oikean löytämiseksi
    // normaalissa pelissä peli loppuisi heti ensimmäiseen väärään vastaukseen, joten testaaminen idioottivarmasti on hankalahkoa
    // ellei classeihin lisättäisi jotain toiminnallisuutta pelkkiin testaustarkoituksiin: kuten symbolinketjun luonti, joka sisältää vain ykkösiä
    @Test
    public void compareAnswerTrue() {
        boolean passed = false;
        if (this.test.compareAnswer(1)) {
            passed = true;
        }
        if (this.test.compareAnswer(2)) {
            passed = true;
        }
        if (this.test.compareAnswer(3)) {
            passed = true;
        }
        if (this.test.compareAnswer(4)) {
            passed = true;
        }
        assertTrue(passed);
    }
}
