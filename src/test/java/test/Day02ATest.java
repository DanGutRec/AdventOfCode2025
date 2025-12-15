package test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import software.aoc.day02.a.aplication.IdRangeDeserializer;
import software.aoc.day02.a.model.Id;
import software.aoc.day02.a.model.IdRanges;

import java.util.Iterator;

public class Day02ATest {
    @Test
    public void ID_test() {
        assertThat(new Id(3).id()).isEqualTo(3);
        assertThat(new Id(8).id()).isEqualTo(8);
    }
    @Test
    public void ID_deserializer_test() {
        assertThat(IdRangeDeserializer.instance().deserialize("24-25")[0].id()).isEqualTo(24);
        assertThat(IdRangeDeserializer.instance().deserialize("24-25")[1].id()).isEqualTo(25);
        assertThat(IdRangeDeserializer.instance().deserialize("24-25").length).isEqualTo(2);
    }
    @Test
    public void ID_ranges_test() {
        Iterator<Id> id_iterator=IdRanges.create("20-30",IdRangeDeserializer.instance()).iterator();
        assertThat(id_iterator.next().id()).isEqualTo(20);
        for (int x=0;x<9;x++)id_iterator.next();
        assertThat(id_iterator.next().id()).isEqualTo(30);
    }
}
