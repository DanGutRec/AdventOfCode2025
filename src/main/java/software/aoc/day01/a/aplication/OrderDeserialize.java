package software.aoc.day01.a.aplication;

public class OrderDeserialize implements NumericDeserialize {
    private static OrderDeserialize instance;
    @Override
    public int deserialize(String line){
        return signOf(line)*parseInt(line);
    }
    public static int deserializeStatic(String line) {
        if (instance==null) instance= new OrderDeserialize();
        return instance.deserialize(line);
    }

    private static int parseInt(String line) {
        return line.charAt(0) == 'R' ? 1 : -1;
    }

    private static int signOf(String line) {
        return Integer.parseInt(line.substring(1));
    }
}
