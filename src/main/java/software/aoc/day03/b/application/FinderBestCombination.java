package software.aoc.day03.b.application;

import software.aoc.day03.b.model.BankOfBatteries;

import java.util.stream.LongStream;

public class FinderBestCombination {
    private final BankOfBatteries bob;
    private final int maxBatteries;

    private FinderBestCombination(BankOfBatteries bob, int maxBatteries) {
        this.bob = bob;
        this.maxBatteries = maxBatteries;
    }

    public static FinderBestCombination instance(BankOfBatteries bob, int maxBatteries) {
        return new FinderBestCombination(bob, maxBatteries);
    }

    public long generateCombinations() {
        if (bob.size() <= maxBatteries) return concatenateAll();
        return findLargestSubsequence();
    }

    private long concatenateAll() {
        return LongStream.range(0,bob.size())
                .map(x->bob.getBattery((int) x).joltage()* (long) Math.pow(10,bob.size()-x-1))
                .sum();
    }

    private long findLargestSubsequence() {
        int[] stack = new int[bob.size()];
        int size = 0;
        int toRemove = bob.size() - maxBatteries;

        for (int i = 0; i < bob.size(); i++) {
            while ((toRemove > 0 && size > 0) && (stack[size - 1]<bob.getBattery(i).joltage())) {
                size--;
                toRemove--;
            }
            stack[size++] = bob.getBattery(i).joltage();
        }
        return buildResult(stack, size - toRemove);
    }

    private long buildResult(int[] stack, int length) {
        long result = 0L;
        for (int i = 0; i < length; i++) {
            result = result * 10 + stack[i];
        }
        return result;
    }
}