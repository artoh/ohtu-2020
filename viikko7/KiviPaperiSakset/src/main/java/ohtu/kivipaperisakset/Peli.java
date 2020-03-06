/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author ahyvatti
 */
public class Peli {
    private final Pelaaja[] pelaajat;
    final String[] PELAAJATEKSTIT = {"Ensimmäisen pelaajan siirto:",
                                      "Toisen pelaajan siirto:"};  
    
    Peli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaajat = new Pelaaja[]{pelaaja1, pelaaja2};                
    }
    
    public String pelaajanVuoro(int pelaajanIndeksi) {
        Pelaaja pelaaja = pelaajat[pelaajanIndeksi];
        
        if( pelaaja.onkoTietokone()) {
            System.out.print("Tietokone valitsi :");
        } else {
            System.out.println(PELAAJATEKSTIT[pelaajanIndeksi] );
        }
        
        String siirto = pelaaja.annaSiirto();
        if( pelaaja.onkoTietokone()) {
            System.out.println( siirto );
        }
        pelaajat[ pelaajanIndeksi == 1 ? 0 : 1].asetaSiirto(siirto);
        
        return siirto;
    }
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    private static void lopetaPeli(Tuomari tuomari) {
        System.out.println("");
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    private void pelaaKierrokset(Tuomari tuomari) {
        while(true) 
        {
            String siirrot[] = new String[2];
            for(int i=0; i<2; i++) {
                siirrot[i] = this.pelaajanVuoro(i);
                if( !onkoOkSiirto(siirrot[i])) {
                    return;
                }
            }
            tuomari.kirjaaSiirto(siirrot[0], siirrot[1]);        
        }
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        this.pelaaKierrokset(tuomari);
        lopetaPeli(tuomari);
    }
}
