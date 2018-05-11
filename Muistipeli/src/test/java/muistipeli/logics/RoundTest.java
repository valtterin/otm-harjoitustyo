package muistipeli.logics;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RoundTest {
    
    Round newround;

    @Before
    public void setUp() {
        newround = new Round(6);
    }

    
    // testaa että ensimmäinen numero/symboli on legit
    @Test
    public void currentSymbolWorks() {
        assertTrue(1 <= this.newround.currentSymbol() && this.newround.currentSymbol() <= 4);
    }
    
    
    // vertaa comparen avulla tämän hetkistä symbolia kaikkiin mahdollisiin symboleihin   
    @Test
    public void compareWorks() {
        boolean test = false;
        int nmbr = 1; 
        while (nmbr <= 4) {
            if (this.newround.compare(nmbr)) {
                test = true;
            }
            nmbr++;
        }  
        assertTrue(test);
    }
    
    @Test
    public void compareWorksNot() {
        assertTrue(!this.newround.compare(0));
    }
    
    
    
    @Test
    public void getMarkerWorks() {
        assertEquals(0, this.newround.getMarker());
    }
    
    
    @Test
    public void moveMarkerWorks() {
        this.newround.moveMarker();
        this.newround.moveMarker();
        this.newround.moveMarker();
        this.newround.moveMarker();
        assertTrue(this.newround.moveMarker());
    }
    
    @Test
    public void moveMarkerWorksNotTooHigh() {
        this.newround.moveMarker();
        this.newround.moveMarker();
        this.newround.moveMarker();
        this.newround.moveMarker();
        this.newround.moveMarker();
        assertTrue(!this.newround.moveMarker());
    }
    
    @Test
    public void setMarkerWorks() {
        assertTrue(this.newround.setMarker(5));
    }
    
    @Test
    public void setMarkerWorksNotTooHigh() {
        assertTrue(!this.newround.setMarker(6));
    }
    
    @Test
    public void setMarkerWorksNotNegative() {
        assertTrue(!this.newround.setMarker(-1));
    }
    
    
    // testaa nextRoundin toiminnallisuutta
    @Test
    public void nextRoundWorks() {
        this.newround.nextRound(1);
        this.newround.setMarker(6);
        assertTrue(1 <= this.newround.currentSymbol() && this.newround.currentSymbol() <= 4);
    }
    
    
}
