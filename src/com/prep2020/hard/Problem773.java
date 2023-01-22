package com.prep2020.hard;
import java.util.*;
public class Problem773 {
	/**
	 * O(6 * 5!) time and space
	 * @param board
	 * @return
	 */
	public int slidingPuzzle(int[][] board) {
        String startState = boardState(board);
        Queue<String> q = new LinkedList<>();
        q.offer(startState);
        String endState = "123450";
        if (startState.equals(endState)) return 0;
        int result = 0;
        Set<String> visited = new HashSet<>();
        visited.add(startState);
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		String cur = q.poll();
        		List<String> nextStates = findNextStates(cur);
        		for (String state : nextStates) {
        			if (state.equals(endState)) return result;
        			if (visited.contains(state)) continue;
        			visited.add(state);
        			q.offer(state);
        		}
        	}
        }
        return -1;
    }
	
	private List<String> findNextStates(String cur) {
		List<String> result = new ArrayList<>();
		char[] arr = cur.toCharArray();
		int zeroIndex = -1;
		for (int i = 0; i < 6; i++) {
			if (arr[i] == '0') {
				zeroIndex = i;
				break;
			}
		}
		if (zeroIndex < 3) {
			char[] next = Arrays.copyOf(arr, arr.length);
			next[zeroIndex + 3] = arr[zeroIndex];
			next[zeroIndex] = arr[zeroIndex + 3];
			result.add(new String(next));
		}
		if (zeroIndex > 2) {
			char[] next = Arrays.copyOf(arr, arr.length);
			next[zeroIndex - 3] = arr[zeroIndex];
			next[zeroIndex] = arr[zeroIndex - 3];
			result.add(new String(next));
		}
		if (zeroIndex != 2 && zeroIndex != 5) {
			char[] next = Arrays.copyOf(arr, arr.length);
			next[zeroIndex + 1] = arr[zeroIndex];
			next[zeroIndex] = arr[zeroIndex + 1];
			result.add(new String(next));
		}
		if (zeroIndex != 0 && zeroIndex != 3) {
			char[] next = Arrays.copyOf(arr, arr.length);
			next[zeroIndex -1] = arr[zeroIndex];
			next[zeroIndex] = arr[zeroIndex - 1];
			result.add(new String(next));
		}
		return result;
	}
	
	private String boardState(int[][] board) {
		String result = "";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				result += board[i][j];
			}
		}
		return result;
	}
}
