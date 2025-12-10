package test;

import org.junit.Test;
import software.aoc.day01.a.model.Dial;
import software.aoc.day01.a.model.Order;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ATest {
    @Test
    public void Order_test_creation() {
        assertThat(Order.create("R10").movement()).isEqualTo(10);
        assertThat(Order.create("L10").movement()).isEqualTo(-10);
    }
    @Test
    public void Dial_test_positions_simple_movements() {
        assertThat(Dial.create().position()).isEqualTo(50);
        assertThat(Dial.create().execution("R10").position()).isEqualTo(60);
        assertThat(Dial.create().execution("R49").position()).isEqualTo(99);
        assertThat(Dial.create().execution("R50").position()).isEqualTo(0);
        assertThat(Dial.create().execution("L10").position()).isEqualTo(40);
        assertThat(Dial.create().execution("L50").position()).isEqualTo(0);
        assertThat(Dial.create().execution("L51").position()).isEqualTo(99);
    }
    @Test
    public void Dial_test_positions_multiple_movements() {
        assertThat(Dial.create().execution("R10\nR10").position()).isEqualTo(70);
        assertThat(Dial.create().add("R10","R10").position()).isEqualTo(70);
        assertThat(Dial.create().execution("R50\nR50").position()).isEqualTo(50);
        assertThat(Dial.create().execution("L10\nL10").position()).isEqualTo(30);
        assertThat(Dial.create().add("L10","L10").position()).isEqualTo(30);
        assertThat(Dial.create().execution("L50\nL50").position()).isEqualTo(50);
    }
    @Test
    public void Dial_test_count_how_many_time_is_on_the_position_0() {
        assertThat(Dial.create().execution("R10\nR10").countPositionIsOn0()).isEqualTo(0);
        assertThat(Dial.create().execution("R50\nR10").countPositionIsOn0()).isEqualTo(1);
        assertThat(Dial.create().execution("L50\nL10").countPositionIsOn0()).isEqualTo(1);
        assertThat(Dial.create().execution("R50\nR100").countPositionIsOn0()).isEqualTo(2);
    }
}
