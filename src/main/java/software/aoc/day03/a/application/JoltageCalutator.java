package software.aoc.day03.a.application;

import software.aoc.day03.a.model.BankOfBatteries;

import java.util.stream.Stream;

public class JoltageCalutator {
    public static long maxiumJoltage(Stream<BankOfBatteries> input) {
        return input.mapToInt(BatteriesSelector::largestPossibleVoltage).sum();
    }
}
