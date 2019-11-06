
package ohtu.verkkokauppa;

import java.util.ArrayList;

public class KirjanpitoImpl implements Kirjanpito {

    private static ArrayList<String> tapahtumat = new ArrayList<>();

    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
