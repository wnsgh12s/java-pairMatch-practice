package pairmatching.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum Level {
    LEVEL1("레벨1", List.of(Mission.RACING, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", List.of(Mission.SHOPPING_BASKET, Mission.PAYMENT, Mission.SUBWAY_MAP)),
    LEVEL3("레벨3"),
    LEVEL4("레벨4", List.of(Mission.PERFORMANCEIMPROVEMENT, Mission.DISTRIBUTE)),
    LEVEL5("레벨5");

    private final String name;
    private final List<Mission> missions;

    Level(final String name) {
        this.name = name;
        missions = new ArrayList<>();
    }


    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level of(String input, Mission mission) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(""))
                .findMission(mission);
    }

    private Level findMission(Mission mission) {
        if( missions.contains(mission)){
            return this;
        }
        throw new IllegalArgumentException();
    }

    private static Level getLevel(Mission mission, Level findedLevel) {
        if(findedLevel.missions.contains(mission)){
            return findedLevel;
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
}
