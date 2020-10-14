package comp.prep2019.less1000;
import java.util.*;
public class Prob875 {
	public int minEatingSpeed(int[] piles, int H) {
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        int min = 1, max = Integer.MIN_VALUE;
        for (int pile : piles) {
        	q.offer(pile);
        	max = Math.max(max, pile);
        }
        int result = max;
        List<Integer> list = new ArrayList<>();
        while(min <= max) {
        	int mid = min + (max - min) / 2;
        	int hour = 0;
        	while(!q.isEmpty() && hour <= H) {
        		if (q.peek() <= mid)  {
        			hour += q.size();
        			break;
        		} else {
        			int pile = q.poll();
        			list.add(pile);
        			hour += pile / mid + (pile % mid == 0 ? 0 : 1);
        		}
        	}
        	Iterator<Integer> itr = list.iterator();
        	while(itr.hasNext()) {
        		q.offer(itr.next());
        		itr.remove();
        	}
        	if (hour <= H) {
        		result = mid;
        		max = mid - 1;
        	} else min = mid + 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob875 prob = new Prob875();
		System.out.println(prob.minEatingSpeed(new int[] {30, 11, 23, 4, 20},
				6));
	}
}
