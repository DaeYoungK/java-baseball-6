package baseball.controller;

import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Computer computer = new Computer();
    boolean gameState = false;

    public void start() {
        computer.setComputerNumber();
        int computerNumber = computer.getComputerNumber();
        while (!gameState) {
            int playerNumber = inputView.print_input_message();
            gameState = compareNumber(computerNumber, playerNumber);
        }
        outputView.print_end();
    }

    private boolean compareNumber(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            return true;
        }
        compareComputerAndPlayer(playerNumber);
        return false;
    }

    private void compareComputerAndPlayer(int playerNumber) {
        List<Integer> playerNumbers = numberToList(playerNumber);
        List<Integer> computerNumbers = computer.getComputerNumbers();
        int strike = strikeCheck(playerNumbers, computerNumbers);
        int ball = ballCheck(playerNumbers, computerNumbers);

        if (strike != 0 && ball != 0) {
            outputView.print_strike_and_ball(ball, strike);
        } else if (strike != 0 && ball == 0) {
            outputView.print_strike(strike);
        } else if (strike == 0 && ball != 0) {
            outputView.print_ball(ball);
        } else {
            outputView.print_nothing();
        }
    }

    private int ballCheck(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int ballCount = 0;
        for (int playerNumber : playerNumbers) {
            if (computerNumbers.contains(playerNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int strikeCheck(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (playerNumbers.get(i) == computerNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private List<Integer> numberToList(int playerNumber) {
        List<Integer> tempList = new ArrayList<>();
        while (playerNumber%10 != 0){
            int temp = playerNumber%10;
            tempList.add(temp);
            playerNumber /= 10;
        }
        Collections.reverse(tempList);
        return tempList;
    }


}
