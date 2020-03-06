package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Paaohjelma {

    private static void valikko(Scanner scanner) {
        
        Map<Character, Runnable> komennot = new HashMap<>();
        
        komennot.put('a', () -> PeliTehdas.kaksinpeli(scanner).pelaa());
        komennot.put('b', () -> PeliTehdas.tekoaly(scanner).pelaa());
        komennot.put('c', () -> PeliTehdas.parempiTekoaly(scanner).pelaa());
        
        while( true ) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");
            char cmd = scanner.nextLine().charAt(0);
            if( !komennot.containsKey(cmd))
                break;
            komennot.get(cmd).run();
        }
    }
    
    public static void main(String[] args) {
        valikko( new Scanner(System.in));
    }
}
