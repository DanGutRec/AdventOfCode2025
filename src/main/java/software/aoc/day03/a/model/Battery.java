package software.aoc.day03.a.model;

public record Battery(int joltage) {
    public Battery {
        if (joltage < 1 || joltage > 9) throw  new IllegalArgumentException("joltage must be between 1 and 9");
    }
    public static Battery create(int joltage) {
        return new Battery(joltage);
    }
}
