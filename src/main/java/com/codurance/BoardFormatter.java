package com.codurance;

public class BoardFormatter {
  private boolean[][] nextBoard;

  public BoardFormatter(boolean[]... nextBoard) {
    this.nextBoard = nextBoard;
  }

  public void invoke() {
    for(int j = 0; j < nextBoard.length; j++){
      StringBuilder builder = new StringBuilder();
      for(int k = 0; k < nextBoard[j].length; k++){
        if(nextBoard[j][k]) builder.append("X"); else builder.append("0");
      }
      System.out.println(builder.toString());
    }
    System.out.println("------------------------------");
  }
}
