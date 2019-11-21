package ohtu.intjoukkosovellus;

public interface JoukonHallitsija {

    void lisaa(IntJoukko j, int l);
    IntJoukko yhdiste(IntJoukko eka, IntJoukko toka);
    IntJoukko leikkaus(IntJoukko eka, IntJoukko toka);
    IntJoukko erotus(IntJoukko eka, IntJoukko toka);
    void poista(IntJoukko j, int l);
    boolean kuuluu(IntJoukko j, int l);
    boolean onJoukko(String j);
    IntJoukko haeJoukko(String j);
}
