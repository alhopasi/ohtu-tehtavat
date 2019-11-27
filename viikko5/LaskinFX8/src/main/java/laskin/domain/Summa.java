package laskin.domain;

import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Summa extends Komento {

    private int edellinenArvo;

    private TextField tuloskentta;
    private TextField syotekentta;
    private Sovelluslogiikka sovellus;

    public Summa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
        edellinenArvo = 0;
    }

    @Override
    public void suorita() {
        int arvo = Integer.valueOf(syotekentta.getText());
        edellinenArvo = arvo;
        sovellus.plus(arvo);
        asetaArvo();
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinenArvo);
        asetaArvo();
    }

    private void asetaArvo() {
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }
}
