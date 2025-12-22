package software.aoc.day03.a.application;

import software.aoc.day03.a.model.BankOfBatteries;
import software.aoc.day03.a.model.Battery;

import java.util.Arrays;
import java.util.stream.Stream;

public class BankOfBatteriesDeserializer {
    private static BankOfBatteriesDeserializer instance;

    public static BankOfBatteries deserialize(String input) {
        if (instance == null) instance = new BankOfBatteriesDeserializer();
        return toBankOfBatteries(input);
    }
    private static BankOfBatteries toBankOfBatteries(String input) {
        return BankOfBatteries.create().addBattery(BatteryDeserializer.deserialize(input));
    }






}
