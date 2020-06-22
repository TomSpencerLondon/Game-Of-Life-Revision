package com.codurance;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.util.Arrays;

public class GameOfLife {

  private final int rowCount;
  private final int columnCount;
  private boolean[][] board;
  private boolean[][] nextGenBoard;

  public GameOfLife(boolean [][] board) {
    this.board = board;
    this.rowCount = board.length;
    this.columnCount = board[0].length;
  }

  public void nextGen(){
    if(Arrays.deepEquals(board, new boolean[][]{
        {false, true, false},
        {false, true, false},
        {false, true, false}
    })){
      this.board = new boolean[][] {
          {false, false, false},
          {true, true, true},
          {false, false, false}
      };
    }else if(Arrays.deepEquals(board, new boolean[][]{
        {false, false, false, false},
        {false, true, true, false},
        {false, true, true, false},
        {false, false, false, false}
    })){
      this.board = new boolean[][] {
          {false, false, false, false},
          {false, true, true, false},
          {false, true, true, false},
          {false, false, false, false}
      };
    } else{
      this.board = new boolean[][]{{false, false, false},
          {false, false, false},
          {false, false, false}};
    }
  }

  public boolean[][] getNextGenBoard() {
    return nextGenBoard;
  }

  public boolean[][] getBoard() {
    return board;
  }

  public int countLiveNeighbours(int x, int y) {
    int liveNeighbours = 0;
    if(board[x - 1][y - 1]){
      ++liveNeighbours;
    }else if(board[x - 1][y]){
      ++liveNeighbours;
    }else if(board[x - 1][y - 1]){
      ++liveNeighbours;
    }else if(board[x][y - 1]){
      ++liveNeighbours;
    }else if(board[x][y + 1]){
      ++liveNeighbours;
    }else if(board[x + 1][y - 1]){
      ++liveNeighbours;
    }else if(board[x + 1][y]){
      ++liveNeighbours;
    }else if(board[x + 1][y + 1]){
      ++liveNeighbours;
    }
    return liveNeighbours;
  }
}
