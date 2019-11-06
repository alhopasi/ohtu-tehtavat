package ohtu;

import ohtu.verkkokauppa.*;

public class Main {

    public static void main(String[] args) {

        Viitegeneraattori viitegen = new ViitegeneraattoriImpl();
        Kirjanpito kirjanpito = new KirjanpitoImpl();
        Pankki pankki = new PankkiImpl(kirjanpito);
        Varasto varasto = new VarastoImpl(kirjanpito);
        Kauppa kauppa = new Kauppa(varasto, pankki, viitegen);


        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }

        Viitegeneraattori viitegen2 = new ViitegeneraattoriImpl();
        System.out.println(viitegen.uusi());
        Viitegeneraattori viitegen3 = new ViitegeneraattoriImpl();
        System.out.println(viitegen3.uusi());
        System.out.println(viitegen2.uusi());
    }
}
