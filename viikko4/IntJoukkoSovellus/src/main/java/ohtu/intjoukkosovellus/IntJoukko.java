package ohtu.intjoukkosovellus;

import java.util.ArrayList;
import java.util.List;

public class IntJoukko {

    List<Integer> joukko;

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

    public int mahtavuus() {
        return joukko.size();
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int luku : joukko) {
            tuotos += (luku + ", ");
        }
        if (joukko.size() > 0) {
            tuotos = tuotos.substring(0,tuotos.length() - 2);
        }
        tuotos += "}";
        return tuotos;
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

    public List<Integer> getList() {
        return joukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.getList()) {
            x.lisaa(luku);
        }
        for (int luku : b.getList()) {
            x.lisaa(luku);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.getList()) {
            if (b.onkoLukua(luku)) {
                x.lisaa(luku);
            }
        }
        return x;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.getList()) {
            x.lisaa(luku);
        }
        for (int luku : b.getList()) {
            x.poista(luku);
        }
        return x;
    }

    public boolean onkoLukua(int luku) {
        return joukko.contains(luku);
    }

}
