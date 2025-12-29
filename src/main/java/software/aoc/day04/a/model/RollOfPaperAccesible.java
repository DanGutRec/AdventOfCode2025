package software.aoc.day04.a.model;

public class RollOfPaperAccesible implements Tile {
    private final TileType tile;

    public RollOfPaperAccesible() {
        this.tile = TileType.RollOfPaperAccessible;
    }

    @Override
    public TileType type() {
        return tile;
    }
}
