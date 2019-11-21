package ohtu.intjoukkosovellus;

public class JoukonHallitsijaImpl implements JoukonHallitsija {

    IO io;
    IntJoukko A;
    IntJoukko B;
    IntJoukko C;

    public JoukonHallitsijaImpl(IntJoukko A, IntJoukko B, IntJoukko C, IO io) {
        this.io = io;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void lisaa(IntJoukko j, int l) {
        j.lisaa(l);
    }

    @Override
    public IntJoukko yhdiste(IntJoukko eka, IntJoukko toka) {
        return IntJoukko.yhdiste(eka, toka);
    }

    @Override
    public IntJoukko leikkaus(IntJoukko eka, IntJoukko toka) {
        return IntJoukko.leikkaus(eka, toka);
    }

    @Override
    public IntJoukko erotus(IntJoukko eka, IntJoukko toka) {
        return IntJoukko.erotus(eka, toka);
    }

    @Override
    public void poista(IntJoukko j, int l) {
        j.poista(l);
    }

    @Override
    public boolean kuuluu(IntJoukko j, int l) {
        return j.onkoLukua(l);
    }

    @Override
    public IntJoukko haeJoukko(String alkuJ) {
        String j = alkuJ.toLowerCase();
        if (j.equals("a")) {
            return A;
        } else if (j.equals("b")) {
            return B;
        } else {
            return C;
        }
    }

    @Override
    public boolean onJoukko(String j) {
        return j.matches("a|b|c");
    }
}
