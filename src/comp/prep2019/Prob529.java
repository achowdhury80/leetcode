package comp.prep2019;
import java.util.*;

public class Prob529 {
	public char[][] updateBoard(char[][] board, int[] click) {
	    if(board[click[0]][click[1]] == 'M'){
	      board[click[0]][click[1]] = 'X';
	      return board;
	    }
	    int adjacentMineCount = mineCountInNeighborhood(board, new Position(click[0], click[1]));
	    if(adjacentMineCount > 0){
	      board[click[0]][click[1]] = (char)(adjacentMineCount + '0');
	      return board;
	    }
	    List<Position> adjacents = findAdjacent(board, new Position(click[0], click[1]));
	    board[click[0]][click[1]] = 'B';
	    for(Position position : adjacents){
	      if(board[position.getX()][position.getY()] == 'E') board = updateBoard(board, new int[]{position.getX(), position.getY()});
	    }
	    return board;
	  }

	  private List<Position> findAdjacent(char[][] board, Position position){
	    List<Position> list = new ArrayList<>();
	    for(int i = position.getX() - 1; i < position.getX() + 2; i++){
	      if(i < 0 || i == board.length) continue;
	      for(int j = position.getY() - 1; j < position.getY() + 2; j++){
	        if(j < 0 || j == board[i].length || (i == position.getX() && j == position.getY())) continue;
	        list.add(new Position(i, j));
	      }
	    }
	    return list;
	  }

	  private int mineCountInNeighborhood(char[][] board, Position position){
	    List<Position> adjacents = findAdjacent(board, position);
	    int result = 0;
	    for(Position pos : adjacents){
	      if(board[pos.getX()][pos.getY()] == 'M') result++;
	    }
	    return result;
	  }

	  class Position {
	    int x, y;
	    public Position(int x, int y){
	      this.x = x;
	      this.y = y;
	    }

	    public int getX(){
	      return x;
	    }

	    public int getY(){
	      return y;
	    }
	  }
}
