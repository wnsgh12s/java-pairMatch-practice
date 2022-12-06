package pairmatching.code;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;
    Level(final String name) {
        this.name =name;
    }

    public static Level of(String input) {
        return Arrays.stream(values()).filter(level -> level.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public String getName() {
        return name;
    }
    //docs? 테스트 ?
}
