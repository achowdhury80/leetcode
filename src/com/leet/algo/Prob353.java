package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob353 {
  private int[][] food;
  private int width, height;
  private int foodIndex;
  private int length;
  private List<int[]> body;

  /** Initialize your data structure here.
   @param width - screen width
   @param height - screen height
   @param food - A list of food positions
   E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
  public Prob353(int width, int height, int[][] food) {
    this.food = food;
    this.width = width;
    this.height = height;
    if (food != null && food.length > 0) foodIndex = 0;
    length = 0;
    body = new ArrayList<>();
    body.add(new int[]{0, 0});
  }

  /** Moves the snake.
   @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   @return The game's score after the move. Return -1 if game over.
   Game over when snake crosses the screen boundary or bites its body. */
  public int move(String direction) {
    int[] nextPosition = new int[]{body.get(0)[0], body.get(0)[1]};
    switch (direction) {
      case "U":
        nextPosition[0]--;
        break;
      case "D":
        nextPosition[0]++;
        break;
      case "L":
        nextPosition[1]--;
        break;
      case "R":
        nextPosition[1]++;
        break;
    }
    if (nextPosition[0] < 0 || nextPosition[0] >= height || nextPosition[1] < 0 || nextPosition[1] >= width) return -1;
    if (foodIndex < food.length && nextPosition[0] == food[foodIndex][0] && nextPosition[1] == food[foodIndex][1]) {
      body.add(0, nextPosition);
      foodIndex++;
      length++;
      return length;
    }
    for (int i = 0; i < body.size() - 1; i++) {
      if (nextPosition[0] == body.get(i)[0] && nextPosition[1] == body.get(i)[1]) return -1;
    }
    body.add(0, nextPosition);
    body.remove(body.size() - 1);
    return length;
  }

  public static void main(String[] args) {
    Prob353 snake = null;
    snake = new Prob353(3, 2, new int[][]{{1,2},{0,1}});
    System.out.println(snake.move("R"));
    System.out.println(snake.move("D"));
    System.out.println(snake.move("R"));
    System.out.println(snake.move("U"));
    System.out.println(snake.move("L"));
    System.out.println(snake.move("U"));

    //snake =
  }


}
