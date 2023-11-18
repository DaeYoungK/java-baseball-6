package baseball.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}