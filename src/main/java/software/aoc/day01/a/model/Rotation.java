package software.aoc.day01.a.model;

import software.aoc.day01.a.aplication.Deserialize;

public class Rotation {
    private final int movement;
    private Rotation(int order) {
        this.movement = order;
    }
    public static Rotation create(String line){
        return new Rotation(Deserialize.deserialize(line));
    }
    public int movement(){
        return this.movement;
    }

}
