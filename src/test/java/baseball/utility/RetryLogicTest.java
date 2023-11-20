package baseball.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.utility.RetryLogic.*;
import static org.assertj.core.api.Assertions.*;

class RetryLogicTest {

    int count = 0;

    @DisplayName("예외가 발생하면 지정된 숫자만큼 재시도 기회를 준다.")
    @Test
    void retryTest() {

        assertThatThrownBy(() -> retry(() -> plusCount()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(count).isEqualTo(5);
    }

    private void plusCount() {
        count++;
        throw new IllegalArgumentException();
    }
}