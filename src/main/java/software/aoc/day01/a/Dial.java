package software.aoc.day01.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Dial {
    private final ArrayList<Integer> orders;
    private Dial() {
        this.orders = new ArrayList<Integer>();
    }
    public  static Dial create() {
        return new Dial();
    }
    public int position() {
        return sumAll();
    }

    private int sumAll() {
        return normalize(orders.stream().mapToInt(x -> x).sum()+50);
    }

    private int normalize(int value) {
        return (value < 0 ? 100 : 0)+value % 100;
    }

    public Dial execution(String orders) {
        return add(orders.split("\n"));
    }

    public Dial add(String... split) {
        Arrays.stream(split).map(this::conversion).forEach(orders::add);
        return this;
    }

    private int conversion(String line) {
        return signOf(line)*parseInt(line);
    }

    private int parseInt(String line) {
        return Integer.parseInt(line.substring(1));
    }

    private int signOf(String line) {
        return line.charAt(0) == 'R' ? 1 : -1;
    }
}
