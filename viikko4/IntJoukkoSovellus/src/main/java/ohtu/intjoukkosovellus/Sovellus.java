package ohtu.intjoukkosovellus;

public class Sovellus {

    public static void main(String[] args) {
        IntJoukko A = new IntJoukko();
        IntJoukko B = new IntJoukko();
        IntJoukko C = new IntJoukko();
        IO io = new KonsoliIO();
        JoukonHallitsija jh = new JoukonHallitsijaImpl(A,B,C,io);

        UI ui = new KonsoliUI(io, jh);
        ui.suorita();
    }
}
