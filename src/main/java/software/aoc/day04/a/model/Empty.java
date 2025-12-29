package software.aoc.day04.a.model;

public class Empty implements Tile {
    private final TileType tile;

    public Empty() {
        this.tile = TileType.RollOfPaperAccessible;
    }

    @Override
    public TileType type() {
        return tile;
    }
}
