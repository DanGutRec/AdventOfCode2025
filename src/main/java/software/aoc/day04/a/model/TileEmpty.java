package software.aoc.day04.a.model;

public class TileEmpty implements Tile {
    private Position position;
    private final TileType tile = TileType.EMPTY;

    public TileEmpty(Position position) {
        this.position = position;
    }

    public static TileEmpty create(Position position) {
        return new TileEmpty(position);
    }

    @Override
    public Position position() {
        return position;
    }

    @Override
    public TileType type() {
        return tile;
    }
}
