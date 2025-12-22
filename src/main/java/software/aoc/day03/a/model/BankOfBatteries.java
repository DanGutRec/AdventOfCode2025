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
    public BankOfBatteries addBattery(Stream<Battery> battery) {
        battery.forEach(this::addBattery);
        return this;
    }
    public int size() {return this.batteries.size();}
    public Battery getBattery(int index) {return this.batteries.get(index);}

    public BankOfBatteries addBattery(Battery b1) {
        this.batteries.add(b1);
        return this;
    }
}
