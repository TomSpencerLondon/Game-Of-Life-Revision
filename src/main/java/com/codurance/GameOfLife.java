package com.codurance;

public class GameOfLife extends Checker {

  private final boolean[][] nextGenBoard;

  public GameOfLife(boolean[][] board) {
    super(board);
    nextGenBoard = new boolean[rowCount][columnCount];
  }

  public void nextGen(){
    for(int i = 0; i < rowCount; i++){
      for(int j = 0; j < columnCount; j++){
        checkCell(i, j);
      }
    }
  }

  private void checkCell(int i, int j) {
    if(aliveLessThanTwoLiveNeighbours(i, j)){
      live(i, j, false);
    }else if(aliveWithTwoOrThreeLiveNeighbours(i, j)){
      live(i, j, true);
    }else if(aliveMoreThanThreeLiveNeighbours(i, j)){
      live(i, j, false);
    }else if(deadExactlyThreeLiveNeighbours(i, j)){
      live(i, j, true);
    }else {
      live(i, j, false);
    }
  }

  private void live(int i, int j, boolean b) {
    nextGenBoard[i][j] = b;
  }

  private boolean aliveWithTwoOrThreeLiveNeighbours(int x, int y){
    int count = countLiveNeighbours(x, y);
    return (count == 2 || count == 3) && board[x][y];
  }

  private boolean deadExactlyThreeLiveNeighbours(int x, int y) {
    return countLiveNeighbours(x, y) == 3 && !board[x][y];
  }

  private boolean aliveLessThanTwoLiveNeighbours(int x, int y) {
    return countLiveNeighbours(x, y) < 2 && board[x][y];
  }

  private boolean aliveMoreThanThreeLiveNeighbours(int x, int y){
    return countLiveNeighbours(x, y) > 3 && board[x][y];
  }

  public boolean[][] getNextGenBoard() {
    return nextGenBoard;
  }

  public boolean[][] getBoard() {
    return board;
  }

}
