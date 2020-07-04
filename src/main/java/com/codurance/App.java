package com.codurance;

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
    boolean[][] nextBoard = gameOfLife.getWorld();

    for (int i = 0; i < 20; i++) {
      GameOfLife nextGame = new GameOfLife(nextBoard);
      nextGame.nextGen();
      nextBoard = nextGame.getNextGenWorld();
      new BoardFormatter(nextBoard).invoke();
    }
  }
}
