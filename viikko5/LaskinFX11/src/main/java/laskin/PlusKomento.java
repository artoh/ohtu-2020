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
public class PlusKomento extends KantaKomento {

    public PlusKomento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
        super(tuloskentta, syotekentta, nollaa, undo);
    }

    @Override
    protected int laske(int edellinen, int syote) {
        return edellinen + syote;
    }
    
}
