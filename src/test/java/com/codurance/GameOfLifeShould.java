package com.codurance;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class GameOfLifeShould {

  @Test
  void change_board_from_initial_state() {
    boolean [][] board = {
        {false, false, false},
        {false, false, false},
        {false, false, false}
    };

    boolean [][] nextBoard = {
        {false, false, false},
        {false, false, false},
        {false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(board);
    gameOfLife.nextGen();
    assertArrayEquals(nextBoard, gameOfLife.getNextGenBoard());
  }

  @Test
  void block_stays_the_same() {
    boolean [][] board = {
        {false, false, false, false},
        {false, true, true, false},
        {false, true, true, false},
        {false, false, false, false}
    };


    boolean [][] nextBoard = {
        {false, false, false, false},
        {false, true, true, false},
        {false, true, true, false},
        {false, false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(board);
    gameOfLife.nextGen();
    assertArrayEquals(nextBoard, gameOfLife.getNextGenBoard());
  }

  @Test
  void change_blinker_state() {
    boolean [][] board = {
        {false, true, false},
        {false, true, false},
        {false, true, false}
    };

    boolean [][] nextBoard = {
        {false, false, false},
        {true, true, true},
        {false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(board);
    gameOfLife.nextGen();
    assertArrayEquals(nextBoard, gameOfLife.getNextGenBoard());
  }

  @Test
  void change_toad_state() {
    boolean [][] board = {
        {false, false, false, false, false, false},
        {false, false, false, false, false, false},
        {false, false, true, true, true, false},
        {false, true, true, true, false, false},
        {false, false, false, false, false, false},
        {false, false, false, false, false, false}
    };

    boolean [][] nextBoard = {
        {false, false, false, false, false, false},
        {false, false, false, true, false, false},
        {false, true, false, false, true, false},
        {false, true, false, false, true, false},
        {false, false, true, false, false, false},
        {false, false, false, false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(board);
    gameOfLife.nextGen();
    System.out.println(Arrays.deepToString(gameOfLife.getNextGenBoard()));
    assertArrayEquals(nextBoard, gameOfLife.getNextGenBoard());
  }

  @Test
  void live_cell_with_less_than_two_living_neighbours_dies() {
    boolean [][] board = {
        {false, false, false},
        {false, true, false},
        {false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(board);
    assertEquals(0, gameOfLife.countLiveNeighbours(1, 1));
  }
}
