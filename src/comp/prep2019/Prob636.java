package comp.prep2019;
import java.util.*;
public class Prob636 {
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (logs.size() == 0) return result;
        Stack<int[]> stack = new Stack<>();
        stack.push(parseLogLine(logs.get(0)));
        for (int i = 1; i < logs.size(); i++) {
        	int[] arr = parseLogLine(logs.get(i));
        	if (arr[1] == 1) {
        		int[] prev = stack.pop();
        		result[arr[0]] += arr[2] - prev[2] + 1;
        		if (!stack.isEmpty()) stack.peek()[2] = arr[2] + 1;
        	} else {
        		if (!stack.isEmpty()) {
        			int[] prev = stack.peek();
        			result[prev[0]] += arr[2] - prev[2];
        		}
        		stack.push(arr);
        	}
        }
        return result;
    }
	
	private int[] parseLogLine(String log) {
		int[] arr = new int[3];
		String[] strs = log.split(":");
		arr[0] = Integer.valueOf(strs[0]);
		arr[2] = Integer.valueOf(strs[2]);
		if ("end".equals(strs[1])) arr[1] = 1;
		return arr;
	}
}
