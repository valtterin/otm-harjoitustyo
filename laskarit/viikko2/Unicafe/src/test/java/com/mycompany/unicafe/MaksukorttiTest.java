package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikein() {
        assertEquals(10, kortti.saldo());      
    }
    
    @Test
    public void saldoVahenee() {
        kortti.otaRahaa(8);
        assertEquals(2, kortti.saldo());      
    }
    
    @Test
    public void saldoVaheneeToinen() {
        assertTrue(kortti.otaRahaa(8));      
    }
    
    @Test
    public void saldoEiNegatiivinen() {
        kortti.otaRahaa(11);
        assertEquals(10, kortti.saldo());      
    }
    
        @Test
    public void saldoEiNegatiivinenToinen() {
        assertTrue(!kortti.otaRahaa(11));       
    }
    
}
