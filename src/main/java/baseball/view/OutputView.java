package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_MESSAGE = "%s스트라이크";
    private static final String BALL_MESSAGE = "%s볼";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printStrike(String strikeCount) {
        System.out.println(String.format(STRIKE_MESSAGE, strikeCount));
    }

    public void printBall(String ballCount) {
        System.out.println(String.format(BALL_MESSAGE, ballCount));
    }

    public void printEnd() {
        System.out.println(END_MESSAGE);
    }

}
