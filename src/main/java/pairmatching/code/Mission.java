package pairmatching.code;

import java.util.Arrays;

public enum Mission {
    RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_MAP("지하철노선도"),
    PERFORMANCEIMPROVEMENT("성능개선"),
    DISTRIBUTE("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission of(String input) {
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 미션"));
    }

    public String getName() {
        return name;
    }
}
