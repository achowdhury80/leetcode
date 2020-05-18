package comp.prep2019;
import java.util.*;
public class Prob496 {
	/**
    find next greater elements of all element in the bigger arry - main trick
    put the info in a map
    use the map to find the answer
    */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i>=0; i--){
            while(!stack.empty() && nums[i]>stack.peek()) stack.pop();
            map.put(nums[i], (stack.empty())? -1 : stack.peek());
            stack.push(nums[i]);
        }
        for(int i = 0; i<findNums.length; i++){
            findNums[i] = map.get(findNums[i]);
        }
        return findNums;        
    }
}
