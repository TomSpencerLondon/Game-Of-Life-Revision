package com.codurance;

import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    boolean [][] board = {
        {false, false, false, false, false, false},
        {false, false, false, false, false, false},
        {false, false, true, true, true, false},
        {false, true, true, true, false, false},
        {false, false, false, false, false, false},
        {false, false, false, false, false, false}
    };
    GameOfLife gameOfLife = new GameOfLife(board);
    boolean[][] nextBoard = gameOfLife.getBoard();

    for (int i = 0; i < 20; i++) {
      GameOfLife nextGame = new GameOfLife(nextBoard);
      nextGame.nextGen();
      nextBoard = nextGame.getNextGenBoard();
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

}
