package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(410);
    }

    @Test
    public void tonninSeteli() {
        assertEquals(100000, kassa.kassassaRahaa());      
    }
    
    @Test
    public void maukkaitaLounaitaMyytyNolla() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());      
    }
    
        @Test
    public void edullisiaLounaitaMyytyNolla() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());      
    }
    
        @Test
    public void maukkaitaLounaitaSyoty() {
        kassa.syoMaukkaasti(400);
        kassa.syoMaukkaasti(380);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());      
    }
    
            @Test
    public void maukasLounasEiSyoty() {
        assertEquals(380, kassa.syoMaukkaasti(380));      
    }
    
            @Test
    public void maukkaitaLounaitaSyotyKassa() {
        kassa.syoMaukkaasti(400);
        kassa.syoMaukkaasti(380);
        assertEquals(100400, kassa.kassassaRahaa());      
    }
    
            @Test
    public void edullisiaLounaitaSyoty() {
        kassa.syoEdullisesti(240);
        kassa.syoEdullisesti(10);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());      
    }
    
            @Test
    public void edullisiaLounaitaSyotyKassa() {
        kassa.syoEdullisesti(240);
        kassa.syoEdullisesti(10);
        assertEquals(100240, kassa.kassassaRahaa());      
    }
    
                @Test
    public void edullinenLounasEiSyoty() {
        kassa.syoEdullisesti(240);
        kassa.syoMaukkaasti(10);
        assertEquals(230, kassa.syoEdullisesti(230));      
    }
    
    
               @Test
    public void maukasLounasKortilla() {
        kassa.syoMaukkaasti(kortti);
        
        assertTrue(!kassa.syoMaukkaasti(kortti));
    }
    
                   @Test
    public void maukasLounasKortillaVelka() {
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(10, kortti.saldo());   
    }
    
    
        @Test
    public void maukkaitaLounaitaSyotyKortilla() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());      
    }
    
    
                      @Test
    public void maukasLounasKortillaKassa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());   
    }
    
    
    
                   @Test
    public void edullinenLounasKortilla() {
        kassa.syoEdullisesti(kortti);
        
        assertTrue(!kassa.syoEdullisesti(kortti));
    }
    
                   @Test
    public void edullinenLounasKortillaVelka() {
        kassa.syoEdullisesti(kortti);
        
        assertEquals(170, kortti.saldo());   
    }
    
    
        @Test
    public void edullisiaLounaitaSyotyKortilla() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());      
    }
    
    
                      @Test
    public void edullinenLounasKortillaKassa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());   
    }
    
    
    @Test
    public void kortinLataus()   {
        kassa.lataaRahaaKortille(kortti, 600);
        assertEquals(1010, kortti.saldo()); 
    }
    
    @Test
    public void kortinLatausNegatiivinen()   {
        kassa.lataaRahaaKortille(kortti, -6);
        assertEquals(410, kortti.saldo()); 
    }
    
    
    @Test
    public void kortinLatausKassa()   {
        kassa.lataaRahaaKortille(kortti, 400);
        assertEquals(100400, kassa.kassassaRahaa());    
    }
            
    


    
//    @Test
//    public void syoMaukkaastiTest() {
//        kassa.syoMaukkaasti(kortti);
//        kassa.syoMaukkaasti(kortti);
//        assertEquals(100400, kassa.kassassaRahaa());      
//    }

    
    
//        @Test
//    public void saldoEiNegatiivinenToinen() {
//        assertTrue(!kortti.otaRahaa(11));
//        maukkaitaLounaitaMyyty()
//                assertEquals(1000, kassa.kassassaRahaa());
//    }
    
    
}