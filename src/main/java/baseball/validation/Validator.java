package baseball.validation;

public class Validator {

    private static final int PLAYER_NUMBER = 3;
    private static final int RETRY_NUMBER = 1;

    public int playerNumber(String number) {
        checkSize(number, PLAYER_NUMBER);
        int resultNumber = checkType(number);

        return resultNumber;
    }

    private void checkSize(String number, int length) {
        if (number.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    private int checkType(String number) {
        Integer resultNumber;
        try {
            resultNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return resultNumber;
    }
}
