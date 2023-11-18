package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class VerifierTest {

    Verifier verifier = new Verifier();

    @DisplayName("정답숫자와 플레이어가 입력한 숫자를 비교해서 스트라이크 개수를 찾는다.")
    @Test
    void findStrikeTest() {
        List<Integer> collectNumbers = Arrays.asList(1,2,3);
        List<Integer> playerNumbers = Arrays.asList(4,2,3);

        int strikeCount = verifier.findStrike(collectNumbers, playerNumbers);

        assertThat(strikeCount).isEqualTo(2);
    }

    @DisplayName("정답숫자와 플레이어가 입력한 숫자를 비교해서 볼 개수를 찾는다.")
    @Test
    void findBallTest() {
        List<Integer> collectNumbers = Arrays.asList(1,2,3);
        List<Integer> playerNumbers = Arrays.asList(1,3,2);

        int ballCount = verifier.findBall(collectNumbers, playerNumbers);

        assertThat(ballCount).isEqualTo(2);
    }

}