package software.aoc.day04.a.model;

import java.util.Arrays;
import java.util.Map;

public class Grid {
    private final Tile[] grid;

    private Grid(Tile[] grid) {
        this.grid = grid;
    }
    public static Grid createGrid(Tile[] grid) {
        return new Grid(grid);
    }
    public Tile[] getGrid() {
        return grid.clone();
    }
    public Tile getTile(int x) {
        return grid[x];
    }
    public int size() {
        return grid.length;
    }
}
