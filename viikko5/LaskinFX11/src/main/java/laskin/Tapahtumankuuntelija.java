package laskin;

import java.util.Map;
import java.util.HashMap;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta; 
    private TextField syotekentta; 
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;
    private Map<Button, Komento> komennot;
    private Komento edellinen = null;    

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;

        komennot = new HashMap<>();
        
        komennot.put(plus, new PlusKomento(tuloskentta, syotekentta, nollaa, undo));
        komennot.put(miinus, new MiinusKomento(tuloskentta, syotekentta, nollaa, undo));
        komennot.put(nollaa, new NollausKomento(tuloskentta, syotekentta, nollaa, undo));
        
    }
    
    @Override
    public void handle(Event event) {
        if( event.getTarget() != undo ) {
            Komento komento = komennot.get((Button) event.getTarget());
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }
    }

}
