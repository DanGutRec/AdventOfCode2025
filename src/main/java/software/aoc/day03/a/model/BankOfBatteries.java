package software.aoc.day03.a.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BankOfBatteries {
    private final List<Battery> batteries;

    private BankOfBatteries() {
        this.batteries = new ArrayList<Battery>();
    }
    public static BankOfBatteries create() {
        return new BankOfBatteries();
    }
    public void addBattery(Stream<Battery> battery) {
        battery.forEach(this.batteries::add);
    }
}
