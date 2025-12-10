package software.aoc.day01.a.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Dial {
    private final ArrayList<Order> orders;
    private Dial() {
        this.orders = new ArrayList<>();
    }
    public  static Dial create() {
        return new Dial();
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
    private int normalize(int value) {
        return (value < 0 ? 100 : 0)+value % 100;
    }
    private int sumAll() {
        return normalize(orders.stream().mapToInt(Order::movement).sum()+50);
    }
    public int position() {
        return sumAll();
    }
    public int countPositionIsOn0(){
        return (int) IntStream.range(0,orders.size()+1).map(this::sumSubOrders).filter(position-> position ==0).count();
    }

    private int sumSubOrders(int position) {
        return normalize(orders.stream().limit(position).mapToInt(Order::movement).sum()+50);
    }

}
