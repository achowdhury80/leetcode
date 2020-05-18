package comp.prep2019;
import java.util.*;
public class Prob1234 {
	public int balancedString(String s) {
        int[] expected = new int[4];
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0); map.put('W', 1); map.put('E', 2);map.put('R', 3); 
        for(char c : s.toCharArray()){
            expected[map.get(c)]++;
        }
        boolean allGood = true;
        for(int i = 0; i < 4; i++){
            if(expected[i] > (n / 4)) {
                allGood = false;
                expected[i] -= (n / 4);
            }
            else expected[i] = 0;
        }
        if(allGood) return 0;
        int[] check = new int[4];
        int j = 0, ans = s.length();
        for(int i = 0; i < n; i++){
            check[map.get(s.charAt(i))]++;
            while(valid(check, expected) && j <= i){
                ans = Math.min(ans, i + 1 - j);
                check[map.get(s.charAt(j++))]--;
            }
        }
        return ans;
    }
    
    boolean valid(int[] actual, int[] expected){
        for(int i = 0; i < 4; i++){
            if(expected[i] > 0 && expected[i] > actual[i]) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Prob1234 prob = new Prob1234();
		System.out.println(prob.balancedString("WQWRQQQW"));
	}
}
