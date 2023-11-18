package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballStore {

    private List<Integer> baseballNumbers = new ArrayList<>();

    public List<Integer> saveNumber(List<Integer> numbers) {
        baseballNumbers = numbers;
        return baseballNumbers;
    }
}
