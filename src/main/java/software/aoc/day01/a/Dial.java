package software.aoc.day01.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Dial {
    private final ArrayList<Order> orders;
    private Dial() {
        this.orders = new ArrayList<Order>();
    }
    public  static Dial create() {
        return new Dial();
    }
    public int position() {
        return sumAll();
    }

    private int sumAll() {
        return normalize(orders.stream().mapToInt(Order::movement).sum()+50);
    }
    private int normalize(int value) {
        return (value < 0 ? 100 : 0)+value % 100;
    }

    public Dial execution(String orders) {
        return add(orders.split("\n"));
    }

    public Dial add(String... split) {
        Arrays.stream(split).map(this::orderFactory).forEach(orders::add);
        return this;
    }

    private Order orderFactory(String line) {
        return Order.create(line);
    }
}
