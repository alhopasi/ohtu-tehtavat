package ohtu.intjoukkosovellus;

import java.util.ArrayList;
import java.util.List;

public class IntJoukko {

    private List<Integer> joukko;

    public IntJoukko() {
        joukko = new ArrayList<>();
    }

    public IntJoukko(int kapasiteetti) {
        this();
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        this();
    }

    public boolean lisaa(int luku) {
        if (joukko.contains(luku)) {
            return false;
        }
        joukko.add(luku);
        return true;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < joukko.size(); i++) {
            if (joukko.get(i) == luku) {
                joukko.remove(i);
                return true;
            }
        }
        return false;
    }

    public int joukonKoko() {
        return joukko.size();
    }

    @Override
    public String toString() {
        String merkkijono = "{";
        for (int luku : joukko) {
            merkkijono += (luku + ", ");
        }
        if (joukko.size() > 0) {
            merkkijono = merkkijono.substring(0,merkkijono.length() - 2);
        }
        merkkijono += "}";
        return merkkijono;
    }

    public int[] toIntArray() {
        int[] taulu = new int[joukko.size()];
        int i = 0;
        for (int luku : joukko) {
            taulu[i] = luku;
            i++;
        }
        return taulu;
    }

    private List<Integer> getList() {
        return joukko;
    }

    public static IntJoukko yhdiste(IntJoukko eka, IntJoukko toka) {
        IntJoukko uusi = new IntJoukko();
        for (int luku : eka.getList()) {
            uusi.lisaa(luku);
        }
        for (int luku : toka.getList()) {
            uusi.lisaa(luku);
        }
        return uusi;
    }

    public static IntJoukko leikkaus(IntJoukko eka, IntJoukko toka) {
        IntJoukko uusi = new IntJoukko();
        for (int luku : eka.getList()) {
            if (toka.onkoLukua(luku)) {
                uusi.lisaa(luku);
            }
        }
        return uusi;
    }

    public static IntJoukko erotus(IntJoukko eka, IntJoukko toka) {
        IntJoukko uusi = new IntJoukko();
        for (int luku : eka.getList()) {
            uusi.lisaa(luku);
        }
        for (int luku : toka.getList()) {
            uusi.poista(luku);
        }
        return uusi;
    }

    public boolean onkoLukua(int luku) {
        return joukko.contains(luku);
    }

}
