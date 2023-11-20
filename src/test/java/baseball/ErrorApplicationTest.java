package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ErrorApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 숫자를_입력하지_않으면_예외발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("qwe");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                1, 3, 5
        );
    }

    @Test
    void 세자리_숫자를_입력하지_않으면_예외발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("1234");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                1, 3, 5
        );
    }

    @Test
    void 중복된_숫자를_입력하면_예외발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("221");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                1, 3, 5
        );
    }

    @Test
    void 숫자_영이_포함되면_예외발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("201");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                1, 3, 5
        );
    }

    @Test
    void 재시도_숫자를_입력하지_않으면_예외발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("135", "r");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                1, 3, 5
        );
    }

    @Test
    void 재시도_1과_2가_아니면_예외발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("135", "0", "3");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                1, 3, 5
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
