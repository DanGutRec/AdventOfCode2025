package software.aoc.day02.a.aplication;

import software.aoc.day02.a.model.Id;
import software.aoc.day02.a.model.IdRanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IdsValidator {
    private final List<IdRanges> ids_ranges;
    private final IdRangeDeserializer deserialize;
    private IdsValidator(IdRangeDeserializer idRangeDeserializer) {
        this.ids_ranges = new ArrayList<IdRanges>();
        this.deserialize = idRangeDeserializer;
    }
    public static IdsValidator create(IdRangeDeserializer deserialize){
        return new IdsValidator(deserialize);
    }

    private static Stream<String> splitLine(String line) {
        return Arrays.stream(line.split(","));
    }

    public IdsValidator add(String line){
        splitLine(line).map(idRanges->IdRanges.create(deserialize.deserialize(idRanges))).forEach(ids_ranges::add);
        return this;
    }
    public long countOfInvalids(){
        return this.ids_ranges.stream().mapToLong(this::IdRangeValidation).sum();
    }

    private long IdRangeValidation(IdRanges ids) {
        return  ids.stream().mapToLong(this::isValidID).sum();
    }

    private long isValidID(Id id) {
        if (numberLength(id.id())%2!=0) return 0;
        return (id.id()/(long)Math.pow(10, numberLength(id.id())/2))==(id.id()%(long)Math.pow(10, numberLength(id.id())/2)) ? id.id():0;
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
