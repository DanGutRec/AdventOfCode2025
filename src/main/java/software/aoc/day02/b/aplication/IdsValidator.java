package software.aoc.day02.b.aplication;

import software.aoc.day02.a.aplication.IdRangeDeserializer;
import software.aoc.day02.a.model.Id;
import software.aoc.day02.a.model.IdRanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IdsValidator {
    private final List<IdRanges> ids_ranges;
    private final IdRangeDeserializer deserialize;
    private IdsValidator(IdRangeDeserializer idRangeDeserializer) {
        this.ids_ranges = new ArrayList<>();
        this.deserialize = idRangeDeserializer;
    }
    public static IdsValidator create(IdRangeDeserializer deserialize){
        return new IdsValidator(deserialize);
    }

    private static Stream<String> splitLine(String line) {
        return Arrays.stream(line.split(","));
    }

    public IdsValidator add(String line){
        splitLine(line).
                map(idRanges->IdRanges.create(deserialize.deserialize(idRanges)))
                .forEach(ids_ranges::add);
        return this;
    }
    public long countOfInvalids(){
        return this.ids_ranges.stream().mapToLong(this::IdRangeValidation).sum();
    }

    private long IdRangeValidation(IdRanges ids) {
        return  ids.stream().filter(id->id.id()>9).mapToLong(this::isInvalidID).sum();
    }

    private long isInvalidID(Id id) {
        return (LongStream.range(2,numberLength(id.id())/2+1)
                .filter(divination->numberLength(id.id())%divination==0)
                .mapToInt(divitation->repeatedPatternValidator(id,divitation))
                .anyMatch(result->result>0) ) ?
                id.id() : 0;
    }

    private int repeatedPatternValidator(Id id,long divination) {
        return ((LongStream.range(1,numberLength(id.id())/divination)
                .mapToInt(block-> samePatternOfNumber(id, divination, block)))
                .allMatch(result->result>0)) ?
                1:0
                ;
    }

    private int samePatternOfNumber(Id id, long divination, long block) {
        return (getBeginningOfTheID(id.id(), divination, 0) == getTheEndOfTheID(id.id(), divination, block)) ? 1:0;
    }

    private long getTheEndOfTheID(long id, long divination,long numOfTheBlock) {
        return getBeginningOfTheID(id,divination,numOfTheBlock) % (long) Math.pow(10,divination);
    }

    private long getBeginningOfTheID(long id,long divination,long numOfTheBlock) {
        return (id / getPow(id, divination,numOfTheBlock));
    }

    private long getPow(long id,long divitation,long numOfTheBlock) {
        return (long) Math.pow(10,(numberLength(id)/divitation-1-numOfTheBlock)*divitation);
    }
    private long numberLength(long id) {
        return String.valueOf(id).length();
    }


    public long lenght() {
        return this.ids_ranges.size();
    }

    public IdsValidator add(Stream<String> file) {
        file.forEach(this::add);
        return this;
    }
}
