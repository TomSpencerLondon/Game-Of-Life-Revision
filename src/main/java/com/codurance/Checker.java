package com.codurance;

public class Checker {

  protected final int rowCount;
  protected final int columnCount;
  protected final boolean[][] board;

  public Checker(boolean[][] board) {
    this.rowCount = board.length;
    this.columnCount = board[0].length;
    this.board = board;
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

      if (isInTheGrid(rowToCheck, colToCheck) && isAlive(rowToCheck, colToCheck)) {
        liveNeighbours++;
      }
    }
    return liveNeighbours;
  }

  private boolean isAlive(int row, int col) {
    return board[row][col];
  }

  private boolean isInTheGrid(int row, int col) {
    return row >= 0 && col >= 0 && row < rowCount && col < columnCount;
  }
}
