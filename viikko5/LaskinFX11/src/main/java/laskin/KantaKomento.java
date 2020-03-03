/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author ahyvatti
 */
public abstract class KantaKomento implements Komento {
    
    TextField tuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    
    public KantaKomento(TextField tuloskentta,
            TextField syotekentta,
            Button nollaa,
            Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }
    
    @Override
    public void suorita() {
        try {
            edellinenTulos = Integer.parseInt(tuloskentta.getText());
            int syote = Integer.parseInt("0"+syotekentta.getText());
            int tulos = laske(edellinenTulos, syote);
            tuloskentta.setText("" + tulos);
            syotekentta.setText("");
            nollaa.disableProperty().set(tulos==0);
            undo.disableProperty().set(false);
        } catch( Exception e) {
            
        }
    }
    
    @Override
    public void peru() {
        tuloskentta.setText("" + edellinenTulos);
        nollaa.disableProperty().set(edellinenTulos == 0);
        undo.disableProperty().set(true);
    }
    
    protected abstract int laske(int edellinen, int syote);
    

    private int edellinenTulos;
}


