package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class KonsoliIO implements IO {

    Scanner s;

    public KonsoliIO() {
        s  = new Scanner(System.in);
    }

    @Override
    public String lueKomento() {
        return s.nextLine();
    }

    @Override
    public String lueKomento(String teksti) {
        System.out.println(teksti);
        return s.nextLine();
    }

    @Override
    public int lueInt() {
        return s.nextInt();
    }

    @Override
    public int lueInt(String teksti) {
        System.out.println(teksti);
        int luku = s.nextInt();
        s.nextLine();
        return luku;
    }

}
