package com.codurance;

public class GameOfLife {

  protected final int rowCount;
  protected final int columnCount;
  protected final boolean[][] world;
  private final boolean[][] nextGenWorld;

  public GameOfLife(boolean[][] world) {
    this.world = world;
    rowCount = world.length;
    columnCount = world[0].length;
    nextGenWorld = new boolean[rowCount][columnCount];
  }

  public void nextGen(){
    for(int x = 0; x < rowCount; x++){
      for(int y = 0; y < columnCount; y++){
        updateCell(x, y);
      }
    }
  }

  private void updateCell(int x, int y) {
    if(aliveLessThanTwoLiveNeighbours(x, y)){
      setDead(x, y);
    }else if(aliveWithTwoOrThreeLiveNeighbours(x, y)){
      setAlive(x, y);
    }else if(aliveMoreThanThreeLiveNeighbours(x, y)){
      setDead(x, y);
    }else if(deadExactlyThreeLiveNeighbours(x, y)){
      setAlive(x, y);
    }else {
      setDead(x, y);
    }
  }

  private void setAlive(int x, int y) {
    nextGenWorld[x][y] = true;
  }

  private void setDead(int x, int y){
    nextGenWorld[x][y] = false;
  }

  private boolean aliveWithTwoOrThreeLiveNeighbours(int x, int y){
    int count = countLiveNeighbours(x, y);
    return (count == 2 || count == 3) && world[x][y];
  }

  private boolean deadExactlyThreeLiveNeighbours(int x, int y) {
    return countLiveNeighbours(x, y) == 3 && !world[x][y];
  }

  private boolean aliveLessThanTwoLiveNeighbours(int x, int y) {
    return countLiveNeighbours(x, y) < 2 && world[x][y];
  }

  private boolean aliveMoreThanThreeLiveNeighbours(int x, int y){
    return countLiveNeighbours(x, y) > 3 && world[x][y];
  }

  public boolean[][] getNextGenWorld() {
    return nextGenWorld;
  }

  public int countLiveNeighbours(int x, int y) {
    int[][] cellsToCheck = new int[][]{
        {x - 1, y - 1},
        {x - 1, y},
        {x - 1, y + 1},
        {x, y + 1},
        {x + 1, y + 1},
        {x + 1, y},
        {x + 1, y - 1},
        {x, y - 1}
    };

    int liveNeighbours = 0;

    for (int[] ints : cellsToCheck) {
      int rowToCheck = ints[0];
      int colToCheck = ints[1];

      if (isInTheWorld(rowToCheck, colToCheck) && isAlive(rowToCheck, colToCheck)) {
        liveNeighbours++;
      }
    }
    return liveNeighbours;
  }

  private boolean isAlive(int row, int col) {
    return world[row][col];
  }

  private boolean isInTheWorld(int row, int col) {
    return row >= 0 && col >= 0 && row < rowCount && col < columnCount;
  }
}
