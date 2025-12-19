package software.aoc.day02.b.aplication;

import software.aoc.day02.b.model.Id;

import java.util.Arrays;

public class IdRangeDeserializer {
    private static IdRangeDeserializer instance;
    public  Id[] deserialize(String line) {
        return ToID(SplitLine(line));
    }

    private static Id[] ToID(String[] strings) {
        return toID(parseLong(strings));
    }

    private static Id[] toID(long[] ints) {
        return Arrays.stream(ints).mapToObj(Id::new).toArray(Id[]::new);
    }

    private static long[] parseLong(String[] strings) {
        return Arrays.stream(strings).mapToLong(Long::valueOf).toArray();
    }
    private static String[] SplitLine(String line) {
        return line.split("-");
    }
    public static IdRangeDeserializer instance() {
        if (instance==null) instance= new IdRangeDeserializer();
        return instance;
    }

}
