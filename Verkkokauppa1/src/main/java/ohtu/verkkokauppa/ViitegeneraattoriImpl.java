package ohtu.verkkokauppa;

public class ViitegeneraattoriImpl implements Viitegeneraattori {

    static private int seuraava = 1;

    public int uusi(){
        return seuraava++;
    }
}
