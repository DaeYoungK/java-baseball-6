package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballStoreTest {

    BaseballStore baseballStore = new BaseballStore();

    @DisplayName("랜덤으로 번호가 생성되면 정답이 저장된다.")
    @Test
    void saveNumberTest() {
        List<Integer> randomNumber= Arrays.asList(1,2,3);
        List<Integer> collectNumbers = baseballStore.saveNumber(randomNumber);

        Assertions.assertThat(collectNumbers).containsExactly(1,2,3);
    }


}