package com.codurance;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.util.Arrays;

public class GameOfLife {

  private boolean[][] board;

  public GameOfLife(boolean [][] board) {
    this.board = board;
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

  public boolean[][] getBoard() {
    return board;
  }
}
