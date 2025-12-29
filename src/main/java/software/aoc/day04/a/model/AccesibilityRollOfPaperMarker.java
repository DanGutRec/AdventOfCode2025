package software.aoc.day04.a.model;

import java.util.Arrays;

import java.util.stream.Stream;

public class AccesibilityRollOfPaperMarker {

    public Grid marker(Grid grid){
        return Grid.createGrid(Arrays.stream(grid.getGrid())
                .filter(d->rollsCounterAround(d,grid)<4)
                .map(d->TileRollOfPaperAccesible.create(d.position()))
                .toArray(Tile[]::new));
    }

    private int rollsCounterAround(Tile d,Grid grid) {
        return (int) getRelativePosition(d)
                .filter(position->isValidPosition(position,grid.size()))
                .map(grid::getTile)
                .filter(this::isARoll)
                .count();
    }
    private boolean isARoll(Tile tile){
        return tile.type() == Tile.TileType.RollOfPaper || tile.type() == Tile.TileType.RollOfPaperAccessible;
    }

    private boolean isValidPosition(Integer position,int size) {
        return position >= 0 && position < size;
    }

    private Stream<Integer> getRelativePosition(Tile d) {
        return getPositionsArounds(d.position()).map(position -> position.y() * 10 + position.x());
    }

    private Stream<Tile.Position> getPositionsArounds(Tile.Position d) {
        return Arrays.stream(getPositionsAroundsStream()).map(cellPosition->adaptPosition(cellPosition,d));
    }

    private Tile.Position adaptPosition(int[] cellPosition, Tile.Position d) {
        return new Tile.Position(d.x()+cellPosition[0],d.y()+cellPosition[1]);
    }

    private int[][] getPositionsAroundsStream() {
        return new int[][]{{-1,-1},{0,-1},{1,-1},
                            {-1,0},       {0,1},
                            {1,-1},{1,0},{1,1}};
    }

}
