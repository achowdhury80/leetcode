package comp.prep2019.less1000;
import java.util.*;
public class Prob740 {
	public int deleteAndEarn(int[] nums) {
        if (nums.length < 1) return 0;
        int[] freq = new int[10001];
        int max = 0;
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, num);
        }
        if (max == 1) return freq[1];
        int[] dp = new int[2];
        dp[0] = freq[1];
        dp[1] = Math.max(dp[0], 2 * freq[2]);
        for (int i = 3; i <= max; i++) {
            int temp = Math.max(i * freq[i] + dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
        
    }
}
