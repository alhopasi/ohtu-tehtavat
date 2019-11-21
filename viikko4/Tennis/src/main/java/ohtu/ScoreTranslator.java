package ohtu;

public class ScoreTranslator {

    public static String getScore(int score1, int score2) {
        int result = score1 - score2;
        if (result == 0) {
            return getEvenScore(score1);
        }
        if (score1 > 3 || score2 > 3) {
            return endGameResult(result);
        }
        return getScoreString(score1) + "-" + getScoreString(score2);
    }

    private static String endGameResult(int result) {
        if (result == 1) {
            return "Advantage player1";
        }
        if (result == -1) {
            return "Advantage player2";
        }
        if (result > 1) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private static String getEvenScore(int score) {
        if (score > 3) {
            return getScoreString(score);
        }
        return getScoreString(score) + "-All";
    }

    private static String getScoreString(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }
}
