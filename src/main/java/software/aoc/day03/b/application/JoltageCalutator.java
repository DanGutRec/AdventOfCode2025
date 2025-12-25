package software.aoc.day03.b.application;

import software.aoc.day03.b.model.BankOfBatteries;

import java.util.stream.Stream;

public class JoltageCalutator {
    public static long maxiumJoltage(Stream<BankOfBatteries> input,int taken) {
        return input.mapToLong(batteries -> BatteriesSelector.largestPossibleVoltage(batteries, taken)).sum();
    }
}
