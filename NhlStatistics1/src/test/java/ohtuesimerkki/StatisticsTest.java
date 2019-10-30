package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }

    @Test
    public void playersCanBeFoundFromStatistics() {
        Player player = stats.search("Semenko");
        assertEquals("Semenko", player.getName());
        player = stats.search("Kurri");
        assertEquals("Kurri", player.getName());
    }

    @Test
    public void playerNotFoundReturnsNull() {
        Player player = stats.search("Laine");
        assertEquals(null, player);
    }

    @Test
    public void teamReturnsListOfPlayersInTheTeam() {
        List<Player> players = stats.team("EDM");
        assertEquals("Semenko", players.get(0).getName());
        assertEquals("Kurri", players.get(1).getName());
        assertEquals("Gretzky", players.get(2).getName());
    }

    @Test
    public void topScorersReturnsCorrectAmount() {
        List<Player> players = stats.topScorers(1);
        assertEquals(1, players.size());
    }

    @Test
    public void topScorersReturnsRightPlayers() {
        List<Player> players = stats.topScorers(2);
        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
    }
}
