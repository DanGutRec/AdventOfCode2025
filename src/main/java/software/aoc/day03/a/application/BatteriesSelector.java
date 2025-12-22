package software.aoc.day03.a.application;

import software.aoc.day03.a.model.BankOfBatteries;

import java.util.stream.IntStream;

public class BatteriesSelector {
    
    public static int largestPossibleVoltage(BankOfBatteries batteries) {
        return batteriesCombination(batteries)
                        .max().orElse(0);
    }

    private static IntStream batteriesCombination(BankOfBatteries batteries) {
        return IntStream.range(0, batteries.size())
                .flatMap(indexA -> IntStream.range(indexA + 1, batteries.size())
                        .map(indexB -> (batteries.getBattery(indexA).joltage() * 10)
                                + batteries.getBattery(indexB).joltage()));
    }
}
