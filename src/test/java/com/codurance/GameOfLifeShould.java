package com.codurance;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class GameOfLifeShould {

  @Test
  void dead_board_remains_dead() {
    boolean[][] world = {
        {false, false, false},
        {false, false, false},
        {false, false, false}
    };

    boolean[][] nextWorld = {
        {false, false, false},
        {false, false, false},
        {false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(world);
    gameOfLife.nextGen();
    System.out.println(Arrays.deepToString(gameOfLife.getWorld()));
    assertArrayEquals(nextWorld, gameOfLife.getWorld());
  }

  @Test
  void block_stays_the_same() {
    boolean[][] world = {
        {false, false, false, false},
        {false, true, true, false},
        {false, true, true, false},
        {false, false, false, false}
    };

    boolean[][] nextWorld = {
        {false, false, false, false},
        {false, true, true, false},
        {false, true, true, false},
        {false, false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(world);
    gameOfLife.nextGen();
    assertArrayEquals(nextWorld, gameOfLife.getWorld());
  }

  @Test
  void change_blinker_state() {
    boolean[][] world = {
        {false, true, false},
        {false, true, false},
        {false, true, false}
    };

    boolean[][] nextWorld = {
        {false, false, false},
        {true, true, true},
        {false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(world);
    gameOfLife.nextGen();
    assertArrayEquals(nextWorld, gameOfLife.getWorld());
  }

  @Test
  void change_toad_state() {
    boolean[][] world = {
        {false, false, false, false, false, false},
        {false, false, false, false, false, false},
        {false, false, true, true, true, false},
        {false, true, true, true, false, false},
        {false, false, false, false, false, false},
        {false, false, false, false, false, false}
    };

    boolean[][] nextWorld = {
        {false, false, false, false, false, false},
        {false, false, false, true, false, false},
        {false, true, false, false, true, false},
        {false, true, false, false, true, false},
        {false, false, true, false, false, false},
        {false, false, false, false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(world);
    gameOfLife.nextGen();
    System.out.println(Arrays.deepToString(gameOfLife.getWorld()));
    assertArrayEquals(nextWorld, gameOfLife.getWorld());
  }

  @Test
  void live_cell_with_less_than_two_living_neighbours_dies() {
    boolean[][] world = {
        {false, false, false},
        {false, true, false},
        {false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(world);
    assertEquals(0, gameOfLife.countLiveNeighbours(1, 1));
  }

  @Test
  void generate_two_consecutive_worlds() {
    boolean[][] verticalBlinker = {
        {false, true, false},
        {false, true, false},
        {false, true, false}
    };

    boolean[][] horizontalBlinker = {
        {false, false, false},
        {true, true, true},
        {false, false, false}
    };

    GameOfLife gameOfLife = new GameOfLife(verticalBlinker);
    gameOfLife.nextGen();
    assertArrayEquals(horizontalBlinker, gameOfLife.getWorld());
    gameOfLife.nextGen();
    assertArrayEquals(verticalBlinker, gameOfLife.getWorld());
  }
}
