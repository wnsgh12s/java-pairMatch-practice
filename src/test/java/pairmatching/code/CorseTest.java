package pairmatching.code;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CorseTest {
    @ParameterizedTest
    @ValueSource(strings = {"풀스택", "12", "##@@"})
    void 올바른_입력값이_들어오지_않았을_때_오류를_반환_하는가(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Course.of(input));
    }

    @Test
    void 과정의_이름이_올바르게_출력_된다() {
        var expected = "백엔드 | 프론트엔드";
        assertThat(Course.message())
                .isEqualTo(expected);
    }

}