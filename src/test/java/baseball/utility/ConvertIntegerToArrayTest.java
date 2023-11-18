package baseball.utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertIntegerToArrayTest {

    ConvertIntegerToArray convertIntegerToArray = new ConvertIntegerToArray();

    @DisplayName("숫자를 입력받아 배열로 반환한다.")
    @Test
    void convertTest() {
        int number = 123;

        List<Integer> convertNumbers = convertIntegerToArray.convert(number);

        Assertions.assertThat(convertNumbers).containsExactly(1,2,3);
    }

}