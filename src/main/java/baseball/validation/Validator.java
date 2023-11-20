package baseball.validation;

import baseball.utility.ConvertIntegerToArray;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.domain.ErrorMessage.*;

public class Validator {

    private static final int PLAYER_NUMBER = 3;
    private static final int RETRY_NUMBER = 1;
    private static final int NOT_RETRY_NUMBER = 2;

    public int playerNumber(String number) {
        checkSize(number, PLAYER_NUMBER);
        int resultNumber = checkType(number);
        checkDistinct(resultNumber);

        return resultNumber;
    }

    public int retryNumber(String number) {
        checkSize(number, RETRY_NUMBER);
        int resultNumber = checkType(number);
        checkNumber(resultNumber);

        return resultNumber;
    }

    private void checkNumber(int resultNumber) {
        if (isPossible(resultNumber)) {
            getMessage(COMMON_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private boolean isPossible(int resultNumber) {
        return resultNumber != RETRY_NUMBER && resultNumber != NOT_RETRY_NUMBER;
    }

    private void checkDistinct(int resultNumber) {
        ConvertIntegerToArray converter = new ConvertIntegerToArray();
        List<Integer> distinctNumbers = converter.convert(resultNumber).stream().distinct().collect(Collectors.toList());
        checkContainZero(distinctNumbers);
        if (distinctNumbers.size() != PLAYER_NUMBER) {
            getMessage(DISTINCT_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkContainZero(List<Integer> distinctNumbers) {
        if (distinctNumbers.contains(0)) {
            getMessage(COMMON_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkSize(String number, int length) {
        if (number.length() != length) {
            getMessage(COMMON_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private int checkType(String number) {
        Integer resultNumber;
        try {
            resultNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            getMessage(COMMON_ERROR);
            throw new IllegalArgumentException(e);
        }
        return resultNumber;
    }
}
