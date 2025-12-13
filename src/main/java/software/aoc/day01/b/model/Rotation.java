package software.aoc.day01.b.model;

import software.aoc.day01.a.aplication.OrderDeserialize;

public class Rotation {
    private final int movement;
    private Rotation(int order) {
        this.movement = order;
    }
    public static Rotation create(String line){
        return new Rotation(OrderDeserialize.deserializeStatic(line));
    }
    public int movement(){
        return this.movement;
    }

}
