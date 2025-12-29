package software.aoc.day04.a.model;

public  class TileRollOfPaper implements Tile {
    private final TileType tile = TileType.RollOfPaper;;
    private final Position position;
    public TileRollOfPaper(Position position) {
        this.position = position;
    }

    @Override
    public TileType type() {
        return this.tile;
    }

    @Override
    public Position position() {
        return position;
    }
}
