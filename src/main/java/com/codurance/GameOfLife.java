package com.codurance;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.util.ArrayList;
import java.util.Arrays;

public class GameOfLife {

  private final int rowCount;
  private final int columnCount;
  private boolean[][] board;
  private boolean[][] nextGenBoard;

  public GameOfLife(boolean[][] board) {
    this.board = board;
    this.rowCount = board.length;
    this.columnCount = board[0].length;
  }

  public void nextGen(){
    nextGenBoard = new boolean[rowCount][columnCount];

    for(int i = 0; i < rowCount; i++){
      for(int j = 0; j < columnCount; j++){
        if(lessThanTwoLiveNeighbours(i, j)){
          nextGenBoard[i][j] = false;
        }
      }
    }
  }

  private boolean lessThanTwoLiveNeighbours(int x, int y) {
    return countLiveNeighbours(x, y) < 2;
  }

  public boolean[][] getNextGenBoard() {
    return nextGenBoard;
  }

  public boolean[][] getBoard() {
    return board;
  }

  public int countLiveNeighbours(int x, int y) {
    int[][] cellsToCheck = new int[][]{
        {x - 1, y - 1},
        {x - 1, y},
        {x - 1, y - 1},
        {x, y - 1},
        {x, y + 1},
        {x + 1, y - 1},
        {x + 1, y},
        {x + 1, y + 1}
    };

    int liveNeighbours = 0;

    for(int i = 0; i < cellsToCheck.length; i++){
      int rowToCheck = cellsToCheck[i][0];
      int colToCheck = cellsToCheck[i][1];

      if(isInTheGrid(rowToCheck, colToCheck) && isAlive(rowToCheck, colToCheck)){
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
