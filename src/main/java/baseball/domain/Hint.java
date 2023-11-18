package baseball.domain;

public class Hint {

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BLANK = " ";

    public String create(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (strikeCount == 0 && ballCount != 0) {
            return sb.append(ballCount + BALL_MESSAGE).toString();
        }
        if (strikeCount != 0 && ballCount == 0) {
            return sb.append(strikeCount + STRIKE_MESSAGE).toString();
        }
        if (strikeCount != 0 && ballCount != 0) {
            return sb.append(ballCount + BALL_MESSAGE + BLANK + strikeCount + STRIKE_MESSAGE).toString();
        }
        if (strikeCount == 3) {
            return sb.append(strikeCount + STRIKE_MESSAGE).toString();
        }
        return NOTHING_MESSAGE;
    }
}
