package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(String player1, String player2) {
        this.player1 = new PlayerImpl(player1);
        this.player2 = new PlayerImpl(player2);
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).addWin();
    }

    private Player getPlayer(String playerName) {
        if (player1.getName().equals(playerName)) {
            return player1;
        }
        if (player2.getName().equals(playerName)) {
            return player2;
        }
        return null;
    }

    public String getScore() {
        return ScoreTranslator.getScore(player1.getWins(), player2.getWins());
    }

}