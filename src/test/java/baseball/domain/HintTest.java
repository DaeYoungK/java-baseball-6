package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HintTest {

    Hint hint = new Hint();

    @DisplayName("출력용 힌트 메시지를 만든다.- 스트라이크")
    @Test
    void onlyStrikeHintTest() {
        int strikeCount = 1;
        int ballCount = 0;

        String hintMessage = hint.create(strikeCount, ballCount);

        assertThat(hintMessage).isEqualTo("1스트라이크");
    }

    @DisplayName("출력용 힌트 메시지를 만든다.- 볼")
    @Test
    void onlyBallHintTest() {
        int strikeCount = 0;
        int ballCount = 2;

        String hintMessage = hint.create(strikeCount, ballCount);

        assertThat(hintMessage).isEqualTo("2볼");
    }

    @DisplayName("출력용 힌트 메시지를 만든다.- 볼, 스트라이크")
    @Test
    void BallAndStrikeHintTest() {
        int strikeCount = 1;
        int ballCount = 2;

        String hintMessage = hint.create(strikeCount, ballCount);

        assertThat(hintMessage).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("출력용 힌트 메시지를 만든다.- 낫싱")
    @Test
    void nothingHintTest() {
        int strikeCount = 0;
        int ballCount = 0;

        String hintMessage = hint.create(strikeCount, ballCount);

        assertThat(hintMessage).isEqualTo("낫싱");
    }
}