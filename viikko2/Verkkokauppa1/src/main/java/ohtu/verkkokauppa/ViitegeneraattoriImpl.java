package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class ViitegeneraattoriImpl implements Viitegeneraattori {

    static private int seuraava = 1;

    @Override
    public int uusi(){
        return seuraava++;
    }
}