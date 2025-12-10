package software.aoc.day01.a.model;

import software.aoc.day01.a.aplication.Deserialize;

public class Order {
    private final int movement;
    private Order(int order) {
        this.movement = order;
    }
    public static Order create(String line){
        return new Order(Deserialize.deserialize(line));
    }
    public int movement(){
        return this.movement;
    }

}
