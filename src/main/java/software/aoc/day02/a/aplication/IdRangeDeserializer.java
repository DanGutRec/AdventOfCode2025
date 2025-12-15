package software.aoc.day02.a.aplication;

import software.aoc.day02.a.model.Id;

import java.util.Arrays;

public class IdRangeDeserializer {
    private static IdRangeDeserializer instance;
    public  Id[] deserialize(String line) {
        return ToID(SplitLine(line));
    }

    private static Id[] ToID(String[] strings) {
        return toID(parseInt(strings));
    }

    private static Id[] toID(int[] ints) {
        return Arrays.stream(ints).mapToObj(Id::new).toArray(Id[]::new);
    }

    private static int[] parseInt(String[] strings) {
        return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
    }
    private static String[] SplitLine(String line) {
        return line.split("-");
    }
    public static IdRangeDeserializer instance() {
        if (instance==null) instance= new IdRangeDeserializer();
        return instance;
    }

}
