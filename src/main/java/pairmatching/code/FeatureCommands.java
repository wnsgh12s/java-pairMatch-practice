package pairmatching.code;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public enum FeatureCommands {
    PAIRMATCH("1", "페어 매칭"),
    PAIRLOOKUP("2", "페어 조회"),
    PAIRINIT("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String number;
    private final String message;
    private static final String FEATURE_COMMAND_FORMAT = "%s. %s";

    FeatureCommands(final String number, final String message) {
        this.number = number;
        this.message = message;
    }

    public static String messages() {
        return Arrays.stream(values())
                .map(FeatureCommands::getFormat)
                .collect(Collectors.joining("\n"));
    }

    private static String getFormat(FeatureCommands featureCommands) {
        return String.format(FEATURE_COMMAND_FORMAT, featureCommands.number, featureCommands.message);
    }

    public static FeatureCommands of(String a) {
        return Arrays.stream(values())
                .filter(featureCommands -> Objects.equals(featureCommands.number, a))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("[ERROR] 올바르지 않은 커맨드 %s",a)));
    }
}
