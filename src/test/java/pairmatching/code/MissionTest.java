package pairmatching.code;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MissionTest {
    @ParameterizedTest
    @ValueSource(strings = {"라이어게임", "집가기", "#"})
    void 올바른_입력값이_들어오지_않았을_때_오류_반환(final String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Mission.of(input));
    }

    void 올바른_메시지를_출력하는지_확인한다() {
        var actual = Mission.of("자동차게임").getName();
        var expected = "자동차게임";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}