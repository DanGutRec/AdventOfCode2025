package software.aoc.day03.b.application;

import software.aoc.day03.b.model.BankOfBatteries;

public class BatteriesSelector {
    
    public static long largestPossibleVoltage(BankOfBatteries batteries, int taken) {
        return batteriesCombination(batteries,taken);
    }

    private static Long batteriesCombination(BankOfBatteries batteries,int taken) {
        return FinderBestCombination.instance(batteries,taken).generateCombinations();
    }


}
