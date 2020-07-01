package com.codurance;

public class GameOfLife extends Checker {

  private final boolean[][] nextGenBoard;

  public GameOfLife(boolean[][] board) {
    super(board);
    nextGenBoard = new boolean[rowCount][columnCount];
  }

  public void nextGen(){
    for(int x = 0; x < rowCount; x++){
      for(int y = 0; y < columnCount; y++){
        updateCell(x, y);
      }
    }
  }

  private void updateCell(int x, int y) {
    if(aliveLessThanTwoLiveNeighbours(x, y)){
      setAlive(x, y, false);
    }else if(aliveWithTwoOrThreeLiveNeighbours(x, y)){
      setAlive(x, y, true);
    }else if(aliveMoreThanThreeLiveNeighbours(x, y)){
      setAlive(x, y, false);
    }else if(deadExactlyThreeLiveNeighbours(x, y)){
      setAlive(x, y, true);
    }else {
      setAlive(x, y, false);
    }
  }

  private void setAlive(int x, int y, boolean b) {
    nextGenBoard[x][y] = b;
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
