package baseball.controller;

import baseball.domain.BaseballStore;
import baseball.domain.Hint;
import baseball.domain.Verifier;
import baseball.utility.ConvertIntegerToArray;
import baseball.utility.RandomNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private static final int RETRY_NUMBER = 1;
    private static final int END_STRIKE_COUNT = 3;

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballStore baseballStore;
    private final Hint hint;
    private final Verifier verifier;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        baseballStore = new BaseballStore();
        hint = new Hint();
        verifier = new Verifier();
    }

    public void proceed() {
        int state = RETRY_NUMBER;

        outputView.printStart();
        while (isRetry(state)) {
            List<Integer> collectNumber = setCollectNumber();
            start(collectNumber);
            state = inputView.readRetryNumber();
        }
    }

    private List<Integer> setCollectNumber() {
        RandomNumber randomNumber = new RandomNumber();
        return baseballStore.saveNumber(randomNumber.create());
    }

    private void start(List<Integer> collectNumber) {
        boolean gameState = true;
        while (gameState) {
            ConvertIntegerToArray convertIntegerToArray = new ConvertIntegerToArray();
            List<Integer> playerNumbers = convertIntegerToArray.convert(inputView.readNumber());
            int strikeCount = verifier.findStrike(collectNumber, playerNumbers);
            int ballCount = verifier.findBall(collectNumber, playerNumbers);

            gameState = checkHint(strikeCount, ballCount);
        }
    }

    private boolean checkHint(int strikeCount, int ballCount) {
        outputView.printHint(hint.create(strikeCount, ballCount));
        if (strikeCount == END_STRIKE_COUNT) {
            outputView.printEnd();
            return false;
        }
        return true;
    }

    private boolean isRetry(int state) {
        return state == RETRY_NUMBER;
    }
}
