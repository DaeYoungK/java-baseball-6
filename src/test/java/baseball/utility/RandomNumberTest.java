package baseball.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class RandomNumberTest {

    RandomNumber randomNumber = new RandomNumber();

    @DisplayName("서로 다른 숫자가 랜덤으로 3개가 생성된다.")
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    @ParameterizedTest
    void setRandomNumberTest() {
        List<Integer> numbers = randomNumber.create();
        List<Integer> distinctNumbers = distinctNumbers(numbers);
        assertThat(numbers.size()).isEqualTo(distinctNumbers.size());
    }

    private List<Integer> distinctNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }


}