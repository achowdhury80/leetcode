package com.leet.algo;

public class Prob1138 {
	public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int[] cur = new int[] {0, 0};
        for (char c : target.toCharArray()) {
        	int[] nextPos = pos(c);
        	if (c == 'z') {
        		for (int i = 0; i < Math.abs(nextPos[1] - cur[1]); i++) {
            		if (nextPos[1] - cur[1] > 0) {
                		sb.append("R");
                	} else if (nextPos[1] - cur[1] < 0) {
                		sb.append("L");
                	}
            	}
        	}
        	
        	for (int i = 0; i < Math.abs(nextPos[0] - cur[0]); i++) {
        		if (nextPos[0] - cur[0] > 0) {
            		sb.append("D");
            	} else if (nextPos[0] - cur[0] < 0) {
            		sb.append("U");
            	}
        	}
        	if (c != 'z') {
	        	for (int i = 0; i < Math.abs(nextPos[1] - cur[1]); i++) {
	        		if (nextPos[1] - cur[1] > 0) {
	            		sb.append("R");
	            	} else if (nextPos[1] - cur[1] < 0) {
	            		sb.append("L");
	            	}
	        	}
        	}
        	sb.append("!");
        	cur = nextPos;
        }
        return sb.toString();
    }
	
	private int[] pos(char c) {
		int dis = c - 'a';
		return new int[] {dis / 5, dis % 5};
	}
	
	public static void main(String[] args) {
		Prob1138 prob = new Prob1138();
		System.out.println(prob.alphabetBoardPath("leet"));
	}
}
