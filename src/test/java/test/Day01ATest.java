package test;

import org.junit.Test;
import software.aoc.day01.a.Dial;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ATest {
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

    }
}
