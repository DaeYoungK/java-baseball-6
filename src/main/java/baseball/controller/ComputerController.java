package baseball.controller;

import baseball.domain.Computer;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerController {
    InputView inputView = new InputView();
    Computer computer = new Computer();
    boolean gameState = false;

    public void start() {
        computer.setComputerNumber();
        int computerNumber = computer.getComputerNumber();
        while (!gameState) {
            int playerNumber = inputView.print_input_message();
            gameState = compareNumber(computerNumber, playerNumber);
        }

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
        strikeCheck(playerNumbers, computerNumbers);
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
