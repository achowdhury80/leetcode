package comp.prep2019.less1000;
import java.util.*;
public class Prob353 {
	private int width, height, idx;
	private List<int[]> snake;
	private int[][] food;
	private int score;
	/** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	public Prob353(int width, int height, int[][] food) {
	    this.width = width;
	    this.height = height;
	    snake = new ArrayList<>();
	    this.food = food;
	    snake.add(new int[] {0, 0});
	    idx = 0;
	}
	
	/** Moves the snake.
	    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
	    @return The game's score after the move. Return -1 if game over. 
	    Game over when snake crosses the screen boundary or bites its body. */
	public int move(String direction) {
		int[] cur = snake.get(0);
		int[] newPos = new int[] {cur[0], cur[1]};
		if ("U".equals(direction)) newPos[0]--;
		else if ("D".equals(direction)) newPos[0]++;
		else if ("L".equals(direction)) newPos[1]--;
		else newPos[1]++;
		if (newPos[0] < 0 || newPos[0] == height || newPos[1] < 0 || newPos[1] == width) return -1;
		if(idx < food.length && food[idx][0] == newPos[0] && food[idx][1] == newPos[1]) {
			score++;
			idx++;
		} else {
			snake.remove(snake.size() - 1);
			for (int[] arr : snake) {
				if (arr[0] == newPos[0] && arr[1] == newPos[1]) return -1;
			}
		}
		snake.add(0, newPos);
		return score;
	}
}
