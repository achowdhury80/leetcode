package com.leet.algo;
import java.util.*;
public class Prob403 {
	public boolean canCross(int[] stones) {
		if(stones.length < 2) return true;
		int last = stones[stones.length - 1];
        Set<Integer> positions = new HashSet<>();
        
        for (int stone : stones) positions.add(stone);
        Queue<Pair> q = new LinkedList<>();
        Pair start = new Pair(stones[0], 0);
        q.offer(start);
        Set<Pair> visited = new HashSet<>();
        visited.add(start);
        while(!q.isEmpty()) {
        	Pair pair = q.poll();
        	for (int i = -1; i < 2; i++) {
        		if (pair.lastJump + i > 0) {
        			Pair newPair = new Pair(pair.pos + pair.lastJump + i, pair.lastJump + i);
        			if(newPair.pos == last) return true;
        			if(newPair.pos > 0 && newPair.pos < last && positions.contains(newPair.pos) && !visited.contains(newPair)) {
        				visited.add(newPair);
        				q.offer(newPair);
        			}
        		}
        	}
        }
        return false;
    }
	class Pair {
		int pos, lastJump;
		Pair(int pos, int lastJump) {
			this.pos = pos;
			this.lastJump = lastJump;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + lastJump;
			result = prime * result + pos;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (lastJump != other.lastJump)
				return false;
			if (pos != other.pos)
				return false;
			return true;
		}
		
		
	}
}
