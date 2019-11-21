package ohtu.intjoukkosovellus;

public class KonsoliUI implements UI {

    IO io;
    JoukonHallitsija jh;

    public KonsoliUI(IO io, JoukonHallitsija jh) {
        this.io = io;
        this.jh = jh;
    }

    @Override
    public void suorita() {
        tulostaOtsikko();

        while (true) {
            String komento = io.lueKomento();
            if (!suoritaKomento(komento)) {
                break;
            };
            tulostaKomennot();
        }
    }

    private boolean suoritaKomento(String saatuKomento) {
        String komento = saatuKomento.toLowerCase();
        if (komento.equals("lisää") || komento.equals("li")) {
            lisaa();
        } else if (komento.equals("poista") || komento.equals("p")) {
            poista();
        } else if (komento.equals("kuuluu") || komento.equals("k")) {
            kuuluuko();
        } else if (komento.equals("yhdiste") || komento.equals("y")) {
            yhdiste();
        } else if (komento.equals("leikkaus") || komento.equals("le")) {
            leikkaus();
        } else if (komento.equals("erotus") || komento.equals("e")) {
            erotus();
        } else if (komento.matches("a|b|c")) {
            tulostaJoukko(komento);
        } else if (komento.equals("lopeta") || komento.equals("quit") || komento.equals("q")) {
            System.out.println("Lopetetaan, moikka!");
            return false;
        } else {
            System.out.println("Virheellinen komento! " + saatuKomento);
        }
        return true;
    }

    private void erotus() {
        IntJoukko eka = lueJoukko("1. joukko?");
        IntJoukko toka = lueJoukko("2. joukko?");
        System.out.println("A erotus B = " + jh.erotus(eka, toka));
    }

    private void yhdiste() {
        IntJoukko eka = lueJoukko("1. joukko?");
        IntJoukko toka = lueJoukko("2. joukko?");
        System.out.println("A yhdiste B = " + jh.yhdiste(eka, toka));
    }

    private void leikkaus() {
        IntJoukko eka = lueJoukko("1. joukko?");
        IntJoukko toka = lueJoukko("2. joukko?");
        System.out.println("A leikkaus B = " + jh.leikkaus(eka, toka));
    }

    private void tulostaJoukko(String joukko) {
        IntJoukko j = jh.haeJoukko(joukko);
        System.out.println(j);
    }

    private void kuuluuko() {
        IntJoukko j = lueJoukko("Mihin joukkoon?");
        int l = io.lueInt("Mikä luku?");
        if (jh.kuuluu(j, l)) {
            System.out.println(l + " kuuluu joukkoon ");
        } else {
            System.out.println(l + " ei kuulu joukkoon ");
        }
    }

    private void lisaa() {
        IntJoukko j = lueJoukko("Mihin joukkoon?");
        int l = io.lueInt("Mikä luku lisätään?");
        jh.lisaa(j, l);
    }

    private void poista() {
        IntJoukko j = lueJoukko("Mistä joukosta?");
        int l = io.lueInt("Mikä luku poistetaan?");
        jh.poista(j, l);
    }

    private IntJoukko lueJoukko(String teksti) {
        String j = "";
        while (!jh.onJoukko(j)) {
            j = io.lueKomento(teksti);
        }
        return jh.haeJoukko(j);
    }

    private void tulostaOtsikko() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        tulostaKomennot();
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }

    private void tulostaKomennot() {
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
    }


}
