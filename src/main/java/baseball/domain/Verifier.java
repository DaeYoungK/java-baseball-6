package baseball.domain;

import java.util.List;

public class Verifier {

    private int count = 0;

    public int findStrike(List<Integer> collectNumbers, List<Integer> playerNumbers) {
        count = 0;
        for (int i = 0; i < collectNumbers.size(); i++) {
            count = checkStrike(count, collectNumbers.get(i), playerNumbers.get(i));
        }

        return count;
    }

    private int checkStrike(int count, int collectNumber, int playerNumber) {
        if (collectNumber == playerNumber) {
            count++;
        }
        return count;
    }

    public int findBall(List<Integer> collectNumbers, List<Integer> playerNumbers) {
        count = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            count = checkBall(collectNumbers, playerNumbers.get(i), i);
        }
        return count;
    }

    private int checkBall(List<Integer> collectNumber, int playerNumber, int index) {
        if (isBall(collectNumber, playerNumber, index)) {
            count++;
        }
        return count;
    }

    private boolean isBall(List<Integer> collectNumber, int playerNumber, int index) {
        return collectNumber.contains(playerNumber) && collectNumber.get(index) != playerNumber;
    }
}
