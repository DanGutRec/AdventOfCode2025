package software.aoc.day01.a.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dial {
    private final ArrayList<Rotation> orders;
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
    public Dial add(Stream<String> split) {
        split.map(this::orderFactory).forEach(orders::add);
        return this;
    }

    private Rotation orderFactory(String line) {
        return Rotation.create(line);
    }
    private int normalize(int value) {
        return ((value < 0 ? 100 : 0)+value) % 100;
    }
    private int sumAll() {
        return normalize(orders.stream().mapToInt(Rotation::movement).sum()+50);
    }
    public int position() {
        return sumAll();
    }
    public int countPositionIsOn0(){
        return (int) IntStream.range(0,orders.size()+1).map(this::sumSubOrders).filter(position-> position ==0).count();
    }

    private int sumSubOrders(int position) {
        return normalize(orders.stream().limit(position).mapToInt(Rotation::movement).sum()+50);
    }

}
