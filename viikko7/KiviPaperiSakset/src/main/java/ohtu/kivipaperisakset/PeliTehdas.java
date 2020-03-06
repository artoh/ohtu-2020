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
public class PeliTehdas {

    final static int PAREMPI_TEKOALY_MUISTI = 20;
    
    public static Peli kaksinpeli(Scanner scanner) {
        return new Peli( new IhmisPelaaja(scanner), new IhmisPelaaja(scanner));
    }
    
    public static Peli tekoaly(Scanner scanner) {
        return new Peli( new IhmisPelaaja(scanner), new Tekoaly());
    }
    
    public static Peli parempiTekoaly(Scanner scanner) {
        return new Peli( new IhmisPelaaja(scanner), new TekoalyParannettu(PAREMPI_TEKOALY_MUISTI) );
    }   
}
