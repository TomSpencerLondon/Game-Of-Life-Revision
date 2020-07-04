package com.codurance;

public class App {
  public static void main(String[] args) {
    boolean [][] initialWorld = {
        {false, false, false, false, false, false},
        {false, false, false, false, false, false},
        {false, false, true, true, true, false},
        {false, true, true, true, false, false},
        {false, false, false, false, false, false},
        {false, false, false, false, false, false}
    };
    GameOfLife gameOfLife = new GameOfLife(initialWorld);

    for (int i = 0; i < 20; i++) {
      gameOfLife.nextGen();
      boolean[][] world = gameOfLife.getNextGenWorld();
      new BoardFormatter(world).invoke();
    }
  }
}
