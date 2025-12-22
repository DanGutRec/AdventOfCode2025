package test;

import org.junit.Test;
import software.aoc.day03.a.application.BankOfBatteriesDeserializer;
import software.aoc.day03.a.application.BatteriesSelector;
import software.aoc.day03.a.application.BatteryDeserializer;
import software.aoc.day03.a.model.BankOfBatteries;
import software.aoc.day03.a.model.Battery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class Day03ATest {
    @Test
    public void Batteries_creation_Tests() {
        assertThat(Battery.create(2).joltage()).isEqualTo(2);
        assertThrows(IllegalArgumentException.class,()->Battery.create(10).joltage());
        assertThrows(IllegalArgumentException.class,()->Battery.create(0).joltage());
    }
    @Test
    public void Batteries_deserialize_Tests() {
        assertThat(BatteryDeserializer.deserialize("4").toList().get(0).joltage())
                .isEqualTo(4);
        assertThrows(IllegalArgumentException.class,
                ()->BatteryDeserializer.deserialize("10").toList().get(0).joltage());
        assertThrows(IllegalArgumentException.class,
                ()->BatteryDeserializer.deserialize("0").toList().get(0).joltage());

    }
    @Test
    public void BankBatteries_creation_test() {
        Battery b1=new Battery(4);
        assertThat(BankOfBatteries.create().size()).isEqualTo(0);
        assertThat(BankOfBatteries.create().addBattery(b1).size()).isEqualTo(1);
    }

    @Test
    public void BankBatteries_deserialize_Tests() {
        Battery b1=new Battery(4);
        assertThat(BankOfBatteriesDeserializer.deserialize("123").size()).isEqualTo(3);
        assertThat(BankOfBatteriesDeserializer.deserialize("123").addBattery(b1).size()).isEqualTo(4);
    }
    @Test
    public void BatteriesSelector_Tests() {
        BankOfBatteries deserialize = BankOfBatteriesDeserializer.deserialize("123");
        assertThat(BatteriesSelector.largestPossibleVoltage(deserialize)).isEqualTo(23);
        assertThat(BatteriesSelector.largestPossibleVoltage(deserialize.addBattery(BatteryDeserializer.deserialize("32")))).isEqualTo(33);

    }
}
