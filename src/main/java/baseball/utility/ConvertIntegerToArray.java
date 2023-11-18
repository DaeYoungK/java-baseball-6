package baseball.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertIntegerToArray {

    public List<Integer> convert(int number) {
        List<Integer> resultNumbers = new ArrayList<>();
        List<String> numbers = Arrays.asList(String.valueOf(number).split(""));
        numbers.stream().forEach(num -> resultNumbers.add(Integer.parseInt(num)));
        return resultNumbers;
    }
}
