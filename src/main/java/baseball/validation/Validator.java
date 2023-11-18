package baseball.validation;

public class Validator {

    public int playerNumber(String number) {
        checkSize(number);
        int resultNumber = checkType(number);

        return resultNumber;
    }

    private void checkSize(String number) {
        if (number.length() != 3) {
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
