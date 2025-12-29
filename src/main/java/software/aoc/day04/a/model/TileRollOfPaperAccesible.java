package software.aoc.day04.a.model;

public class TileRollOfPaperAccesible implements Tile {
    private final TileType tile = TileType.RollOfPaperAccessible;
    private final Position position;
    public TileRollOfPaperAccesible(Position position) {
        this.position = position;
    }
    public static TileRollOfPaperAccesible create(Position position) {
        return new TileRollOfPaperAccesible(position);
    }
    @Override
    public TileType type() {
        return tile;
    }

    @Override
    public Position position() {
        return position;
    }
}
