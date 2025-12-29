package software.aoc.day04.a.model;

public  class RollOfPaper implements Tile {
    private final TileType tile;

    public RollOfPaper() {
        this.tile = TileType.RollOfPaper;
    }

    @Override
    public TileType type() {
        return this.tile;
    }
}
