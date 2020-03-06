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
public interface Pelaaja {
    
    public String annaSiirto();
    
    public void asetaSiirto(String toisensiirto);
    
    public boolean onkoTietokone();
    
}
