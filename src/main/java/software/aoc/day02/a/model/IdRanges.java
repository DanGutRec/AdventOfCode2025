package software.aoc.day02.a.model;

import software.aoc.day02.a.aplication.IdRangeDeserializer;

import java.util.Iterator;
import java.util.stream.IntStream;


public class IdRanges implements Iterable<Id> {
    private final Id start;
    private final Id end;

    private IdRanges(Id[] parameters) {
        this.start=parameters[0];
        this.end=parameters[1];
    }
    public static IdRanges create(String line, IdRangeDeserializer deserialize) {
        return new IdRanges(deserialize.deserialize(line));
    }
    public Iterator<Id> iterator() {
        return IntStream.range(start.id(),end.id()+1).mapToObj(Id::new).iterator();
    }
    public Id start(){return start;}
    public Id end(){return end;}


}
