package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.domain.Erotus;
import laskin.domain.Komento;
import laskin.domain.Nollaa;
import laskin.domain.Summa;

import java.util.HashMap;
import java.util.Map;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta; 
    private TextField syotekentta; 
    private Sovelluslogiikka sovellus;
    private Map<Button, Komento> komennot;
    private Komento edellinen = null;
    private Button undo;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(tuloskentta, syotekentta, sovellus));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, sovellus));
        this.undo = undo;
    }

    @Override
    public void handle(Event event) {
        if ( event.getTarget() != undo ) {
            Komento komento = komennot.get(event.getTarget());
            komento.suorita();
            edellinen = komento;
        } else {
            if (edellinen == null) {
                return;
            }
            edellinen.peru();
            edellinen = null;
        }
    }
}
