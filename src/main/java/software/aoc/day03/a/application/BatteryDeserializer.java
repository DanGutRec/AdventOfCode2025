package software.aoc.day03.a.application;

import software.aoc.day03.a.model.Battery;

import java.util.Arrays;
import java.util.stream.Stream;

public class BatteryDeserializer {
    private static  BatteryDeserializer instance;
    public static Stream<Battery> deserialize(String input) {
        if (instance == null) instance = new BatteryDeserializer();
            return toBattery(input);
    }
    public static Stream<Battery> deserializer(String[] input) {
        if (instance == null) instance = new BatteryDeserializer();
        return toBattery(Arrays.stream(input));
    }

    private static Stream<Battery> toBattery(String input) {
        return toBattery(split(input));
    }

    private static Stream<Battery> toBattery(Stream<String> split) {
        return split.mapToInt(BatteryDeserializer::toInt).mapToObj(Battery::new);
    }

    private static Stream<String> split(String input) {
        return Arrays.stream(input.split(""));
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
