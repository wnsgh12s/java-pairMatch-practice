package pairmatching.code;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FeatureCommandsTest {

    @Test
    void 기능명령에_존재하는_항목들이_반환된다() {

        var expected = FeatureCommands.messages();
        var actual = "1. 페어 매칭\n"
                + "2. 페어 조회\n"
                + "3. 페어 초기화\n"
                + "Q. 종료";

        Assertions.assertThat(expected).isEqualTo(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ss", "ㅇㅇ", "??"})
    void 기능명령에_존재하는_명령어를_입력_받았을_때_오류가_발생하는가(final String input) {
        System.out.println(input);
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> FeatureCommands.of(input));
    }
}