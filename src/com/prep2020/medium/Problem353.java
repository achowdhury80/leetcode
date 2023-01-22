package com.prep2020.medium;
import java.util.*;
public class Problem353 {
	private List<int[]> body;
	private Set<Integer> occupied;
	private int w, h;
	private int[][] food;
	private int foodIndex;
	private int score = 0;
	public Problem353(int width, int height, int[][] food) {
        w = width;
        h = height;
        this.food = food;
        foodIndex = 0;
        body = new ArrayList<>();
        occupied = new HashSet<>();
        occupied.add(0);
        body.add(new int[] {0, 0});
    }
    
    public int move(String direction) {
    	if (score == -1) return -1;
        int[] cur = body.get(body.size() - 1);
        int [] next = null;
        if (direction.equals("U")) next = new int[] {cur[0] - 1, cur[1]};
        else if (direction.equals("D")) next = new int[] {cur[0] + 1, cur[1]};
        else if (direction.equals("L")) next = new int[] {cur[0], cur[1] - 1};
        else next = new int[] {cur[0], cur[1] + 1};
        if (next[0] < 0 || next[0] == h || next[1] < 0 || next[1] == w) return -1;
        if (foodIndex == food.length || food[foodIndex][0] != next[0] 
        		|| food[foodIndex][1] != next[1]) {
        	int[] lastBodyPart = body.remove(0);
        	occupied.remove(encode(lastBodyPart));
        } else {
        	foodIndex++;
        	score++;
        }
        int encodedNext = encode(next);
        if (occupied.contains(encodedNext)) {
        	score = -1;
        	return -1;
        }
        body.add(next);
        occupied.add(encodedNext);
        return score;
    }
    
    private int encode(int[] pos) {
    	return (pos[0] << 12) | pos[1]; 
    }
}
