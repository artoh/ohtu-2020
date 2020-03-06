/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author ahyvatti
 */
public class IhmisPelaaja implements Pelaaja {

    private final Scanner scanner;
    
    IhmisPelaaja(Scanner scanner) {
        this.scanner = scanner;
    }
    
    @Override
    public String annaSiirto() {
        System.out.flush();
        return scanner.nextLine();
    }

    @Override
    public void asetaSiirto(String toisensiirto) {
    }

    @Override
    public boolean onkoTietokone() {
        return false;
    }
    
}
