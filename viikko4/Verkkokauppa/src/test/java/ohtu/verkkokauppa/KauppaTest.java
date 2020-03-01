/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author ahyvatti
 */
public class KauppaTest {
    
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;
    
    public KauppaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // luodaan ensin mock-oliot
        pankki = mock(Pankki.class);

        viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        varasto = mock(Varasto.class);   
        
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(1);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "keksi", 2));
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "kahvi", 8));

        // sitten testattava kauppa 
        k = new Kauppa(varasto, pankki, viite);            
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
          

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }    
    
    @Test
    public void tilisiirrollaOikeatTiedot() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        // nimi, viite, tiliNumero, kaupanTili, summa
        verify(pankki).tilisiirto("pekka", 42, "12345" ,"33333-44455", 5);   
        
    }
    
    @Test
    public void kaksiEriTuotetta() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("hessu","54321");
        verify(pankki).tilisiirto("hessu", 42, "54321" ,"33333-44455", 7);   
    }
    
    @Test
    public void kaksiSamaaTuotetta() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("hessu","54321");
        verify(pankki).tilisiirto("hessu", 42, "54321" ,"33333-44455", 10);           
    }
    
    @Test
    public void toinenTuoteLoppu() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);
        k.tilimaksu("hessu","54321");
        verify(pankki).tilisiirto("hessu", 42, "54321" ,"33333-44455", 5);                   
    }
    
    @Test
    public void aloitaAsiointiNollaaSaldon() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);
        k.aloitaAsiointi();
        k.tilimaksu("hessu","54321");
        verify(pankki).tilisiirto("hessu", 42, "54321" ,"33333-44455", 0);        
    }
    
    @Test
    public void uusiViitenumeroJokaKerta() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("hessu","54321");
        verify(viite, times(1)).uusi();

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("hessu","54321");
        verify(viite, times(2)).uusi();
    }
    
    public void tyhjennettyKoriEiMaksaEnaaMitaan() {
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.poistaKorista(2);
        k.tilimaksu("hessu","54321");
        verify(pankki).tilisiirto("hessu", 42, "54321" ,"33333-44455", 0);         
    }
}
