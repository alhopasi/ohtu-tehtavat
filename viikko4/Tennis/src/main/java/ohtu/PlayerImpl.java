package ohtu;

public class PlayerImpl implements Player {

    private String name;
    private int wins;

    public PlayerImpl(String name) {
        this.name = name;
        wins = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public void addWin() {
        wins++;
    }

}
