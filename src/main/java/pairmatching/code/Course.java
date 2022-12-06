package pairmatching.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(final String name) {
        this.name = name;
    }

    public static void of(String input) {
        Arrays.stream(values())
                .filter(course -> course.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 과정이 아닙니다."));
    }

    public static String message() {
        String delimiter = " | ";
        return Arrays.stream(values()).map(course -> course.name)
                        .collect(Collectors.joining(delimiter));
    }
}
