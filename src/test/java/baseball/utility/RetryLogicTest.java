package baseball.utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetryLogicTest {

    int count = 0;

    @DisplayName("예외가 발생하면 지정된 숫자만큼 재시도 기회를 준다.")
    @Test
    void retryTest() {

        RetryLogic.retry(() -> Assertions.assertThatThrownBy(() -> plusCount())
                .isInstanceOf(IllegalArgumentException.class));

        Assertions.assertThat(count).isEqualTo(5);
    }

    private void plusCount() {
        count++;
        throw new IllegalArgumentException();
    }
}