package software.aoc.day04.a.model;

public interface Tile {
    TileType type();
    Position position();
    record Position(int x, int y){}
    enum TileType{
        EMPTY('.'),
        RollOfPaper('@'),
        RollOfPaperAccessible('x');

        private final char tile;
        TileType(char tile) {
            this.tile=tile;
        }

        public static TileType of(char tile) {
            for (TileType type : TileType.values()) {
                if (type.tile==tile) return type;
            }
            return EMPTY;
        }
    }

}

