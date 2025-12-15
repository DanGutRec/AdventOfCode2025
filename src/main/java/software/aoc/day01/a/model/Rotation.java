package software.aoc.day01.a.model;

import software.aoc.day01.a.aplication.OrderDeserialize;

public record Rotation(int movement) {
    public static Rotation create(String line) {
        return new Rotation(OrderDeserialize.deserializeStatic(line));
    }

}
