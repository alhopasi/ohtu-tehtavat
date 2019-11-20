
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private int goals;
    private String team;
    private String nationality;
    private String birthdate;
    private int assists;

    public void setTeam(String team) { this.team = team; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }
    public void setAssists(int assists) { this.assists = assists; }
    public void setName(String name) {
        this.name = name;
    }
    public void setGoals(int goals) { this.goals = goals; }

    public String getTeam() { return team; }
    public String getName() {
        return name;
    }
    public int getGoals() { return goals; }
    public int getAssists() { return assists; }
    public String getBirthdate() { return birthdate; }
    public String getNationality() { return nationality; }

    public int getScore() {
        return goals + assists;
    }

    @Override
    public int compareTo(Player other) {
        if (this.getScore() > other.getScore()) {
            return -1;
        }
        if (this.getScore() < other.getScore()) {
            return 1;
        }
        return this.getGoals() - other.getGoals();
    }

    @Override
    public String toString() {
        return name + emptySpaces(20, name.length()) + team +
                emptySpaces(4, Integer.toString(goals).length()) + goals + " +" +
                emptySpaces(3, Integer.toString(assists).length()) + assists + " =" +
                emptySpaces(3, Integer.toString(getScore()).length()) + getScore();
    }

    private String emptySpaces(int toAmount, int stringLength) {
        char[] array = new char[toAmount - stringLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = ' ';
        }
        return new String(array);
    }
}
