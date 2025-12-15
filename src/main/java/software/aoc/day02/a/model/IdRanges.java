package software.aoc.day02.a.model;

import software.aoc.day02.a.aplication.IdRangeDeserializer;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class IdRanges {
    private final Id start;
    private final Id end;

    private IdRanges(Id[] parameters) {
        this.start=parameters[0];
        this.end=parameters[1];
    }
    public static IdRanges create(Id[] ids) {
        return new IdRanges(ids);
    }

    public Stream<Id> stream() {
        return LongStream.range(start.id(),end.id()+1).mapToObj(Id::new);
    }
    public Id start(){return start;}
    public Id end(){return end;}

}
