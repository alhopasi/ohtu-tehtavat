package ohtu;

import java.util.Arrays;

public class PlayerPrinter {

    Player[] players;

    public PlayerPrinter(Player[] players) {
        this.players = players;
    }

    public void printNationality(String nationality) {
        System.out.println("Players from " + nationality + " " + java.util.Calendar.getInstance().getTime());
        System.out.println();
        Arrays.stream(players).filter(p -> p.getNationality().equals(("FIN"))).sorted().forEach(p -> System.out.println(p.toString()));
    }
}
