package muistipeli.logics;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SymbolChainTest {
          
    SymbolChain testchain ;
    
    @Before
    public void setUp() {
        testchain = new SymbolChain(4);
    }
    
     
    // array listin alkiot ovat sijoituksissa 0-3, eikä 1-4
    // testataan, että getSymbol palauttaa symbolin/numeron väliltä 1-4
     @Test
    public void getSymbolWorks() {
        assertTrue(1 <= this.testchain.getSymbol(3) && this.testchain.getSymbol(3) <= 4);
    }
    
     @Test
    public void getSymbolWorksNotNegative() {
        assertEquals(0, this.testchain.getSymbol(-1));
    }
    
     @Test
    public void getSymbolWorksNotTooHigh() {
        assertEquals(0, this.testchain.getSymbol(4));
    }
     
    
     @Test
    public void getSizeWorks() {
        assertEquals(4, this.testchain.getSize());
    }
    
     @Test
    public void addSymbolWorks() {
        this.testchain.addSymbol();
        assertEquals(5, this.testchain.getSize());
    }
     
     
}
