package software.aoc.day02.b.model;

import software.aoc.day02.a.model.Id;

import java.util.stream.LongStream;
import java.util.stream.Stream;


public class IdRanges {
    private final software.aoc.day02.a.model.Id start;
    private final software.aoc.day02.a.model.Id end;

    private IdRanges(software.aoc.day02.a.model.Id[] parameters) {
        this.start=parameters[0];
        this.end=parameters[1];
    }
    public static IdRanges create(software.aoc.day02.a.model.Id[] ids) {
        return new IdRanges(ids);
    }

    public Stream<software.aoc.day02.a.model.Id> stream() {
        return LongStream.range(start.id(),end.id()+1).mapToObj(software.aoc.day02.a.model.Id::new);
    }
    public software.aoc.day02.a.model.Id start(){return start;}
    public Id end(){return end;}

}
