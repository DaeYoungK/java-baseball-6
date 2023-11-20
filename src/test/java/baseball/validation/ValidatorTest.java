package baseball.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("플레이어가 입력한 숫자야구 숫자가 3자리인지 검증한다.")
    @Test
    void numberSizeTest() {
        String number = "1234";

        assertThatThrownBy(() -> validator.playerNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 입력한 데이터가 숫자인지 검증한다.")
    @Test
    void numberTypeTest() {
        String number = "qwe1";

        assertThatThrownBy(() -> validator.playerNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 입력한 숫자에 중복이 있는지 검증한다.")
    @Test
    void numberDistinctTest() {
        String number = "442";

        assertThatThrownBy(() -> validator.playerNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 입력한 숫자에 0이 있는지 검증한다.")
    @Test
    void numberContainZeroTest() {
        String number = "402";

        assertThatThrownBy(() -> validator.playerNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 입력 값이 1과 2가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"0", "3", "10"})
    @ParameterizedTest
    void checkRetryNumberTest(String number) {

        assertThatThrownBy(() -> validator.retryNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}