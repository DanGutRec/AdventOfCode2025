package test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import software.aoc.day02.a.aplication.IdRangeDeserializer;
import software.aoc.day02.a.aplication.IdsValidator;
import software.aoc.day02.a.model.Id;
import software.aoc.day02.a.model.IdRanges;
import test.io.TXTRotationsCombinationReader;

import javax.xml.validation.Validator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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
        IdRanges idRanges=IdRanges.create(IdRangeDeserializer.instance().deserialize("20-30"));
        assertThat(idRanges.start().id()).isEqualTo(20);
        assertThat(idRanges.end().id()).isEqualTo(30);
        List<Id> idList=idRanges.stream().toList();
        assertThat(idList.get(0).id()).isEqualTo(20);
        assertThat(idList.get(10).id()).isEqualTo(30);
    }
    @Test
    public void IdsValidator_Single_validation() {
        assertThat(IdsValidator.create(IdRangeDeserializer.instance()).add("11-22").countOfInvalids()).isEqualTo(33);
        assertThat(IdsValidator.create(IdRangeDeserializer.instance()).add("0101-0202").countOfInvalids()).isEqualTo(0);
        assertThat(IdsValidator.create(IdRangeDeserializer.instance()).add("1-16").countOfInvalids()).isEqualTo(11);
        assertThat(IdsValidator.create(IdRangeDeserializer.instance()).add("1188511880-1188511890").countOfInvalids()).isEqualTo(1188511885);
    }
    @Test
    public void IdsValidator_Multiple_IDS_ranges_validation() {
        assertThat(IdsValidator.create(IdRangeDeserializer.instance()).add("123122-123123,95-115").countOfInvalids()).isEqualTo(123222);
        assertThat(IdsValidator.create(IdRangeDeserializer.instance()).add("11-22,0101-0202,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124").countOfInvalids()).isEqualTo(1227775554);
        assertThat(IdsValidator.create(IdRangeDeserializer.instance()).add("38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124").countOfInvalids()).isEqualTo(38593859);

    }

    static void main(String[] args) {
        System.out.println(IdsValidator.create(IdRangeDeserializer.instance()).add(TXTRotationsCombinationReader.instance().getFile("src/test/java/TestData/Day02ATEST.txt")).countOfInvalids());
    }

}
