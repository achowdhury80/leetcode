package comp.prep2019.less1000;
import java.util.*;
public class Prob670 {
	
	public int maximumSwap(int num) {
        char[] arr = ("" + num).toCharArray();
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] == y[0] 
        		? y[1] - x[1] : y[0] - x[0]);
        for (int i = 0; i < arr.length; i++) {
        	q.offer(new int[] {arr[i], i});
        }
        for (int i = 0; i < arr.length - 1; i++) {
        	if (arr[i] == q.peek()[0]) {
        		int[] peek = q.poll();
        		if (!q.isEmpty() && q.peek()[0] == peek[0]) q.peek()[1] = peek[1];
        	} else {
        		char temp = arr[i];
        		arr[i] = (char)q.peek()[0];
        		arr[q.peek()[1]] = temp;
        		break;
        	}
        }
        return Integer.valueOf(new String(arr));
    }
	
	public int maximumSwap1(int num) {
        char[] arr = ("" + num).toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
        	int c = arr[i];
        	int pos = -1;
        	for (int j = i + 1; j < arr.length; j++) {
        		if (c < arr[j]) {
        			if (pos == -1 || arr[pos] <= arr[j])
        			pos = j;
        		}
        	}
        	if (pos > -1) {
        		char t = arr[i];
        		arr[i] = arr[pos];
        		arr[pos] = t;
        		return Integer.valueOf(new String(arr));
        	}
        }
        return num;
    }
	
	public static void main(String[] args) {
		Prob670 prob = new Prob670();
		System.out.println(prob.maximumSwap(2736));
	}
}
