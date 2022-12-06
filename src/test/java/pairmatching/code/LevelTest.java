package pairmatching.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LevelTest {

    @ParameterizedTest
    @ValueSource(strings = {"level", "level1", "level5", "#", "$$$"})
    void level_did_not_correct_input_to_throw_error(final String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Level.of(input, Mission.PERFORMANCEIMPROVEMENT));
    }

    @ParameterizedTest
    @CsvSource(value = {"레벨1,성능개선", "레벨2,자동차경주", "레벨3,장바구니"})
    void 레벨에_맞는_미션이_입력값으로_들어오지_않으면_에러를_던진다(String levelName, String missionName) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Level.of(levelName, Mission.of(missionName)));
    }

    @Test
    void is_level_return_levels_message() {
        var actual = Level.of("레벨1",Mission.of("자동차경주")).getName();
        var expected = "레벨1";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    @Test
    void 올바른_미션과_레벨을_출력하는지_확인() {
        var actual = Level.message();
        var expected = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "  - 레벨3: \n"
                + "  - 레벨4: 성능개선 | 배포\n"
                + "  - 레벨5: ";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}