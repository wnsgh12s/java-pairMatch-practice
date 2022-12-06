package pairmatching.code;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LevelTest {

    @ParameterizedTest
    @ValueSource(strings = {"level","level1","level5","#", "$$$"})
    void level_did_not_correct_input_to_throw_error(final String input){
        Assertions.assertThatIllegalArgumentException().isThrownBy(()-> Level.of(input));
    }

    @Test
    void is_level_return_levels_message(){
        var actual = Level.of("레벨1").getName();
        var expected = "레벨1";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}