package software.aoc.day01.a.model;

public class Order {
    private final int movement;
    private Order(int order) {
        this.movement = order;
    }
    public static Order create(String line){
        return new Order(deserialize(line));
    }

    private static int deserialize(String line) {
        return signOf(line)*parseInt(line);
    }

    private static int parseInt(String line) {
        return line.charAt(0) == 'R' ? 1 : -1;
    }

    private static int signOf(String line) {
        return Integer.parseInt(line.substring(1));
    }
    public int movement(){
        return this.movement;
    }

}
