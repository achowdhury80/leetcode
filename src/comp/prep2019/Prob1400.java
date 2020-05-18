package comp.prep2019;

public class Prob1400 {
	public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) return true;
        if (n < k) return false;
        int[] arr = new int[26];
        int odd = 0;
        for (char c : s.toCharArray()) {
        	int idx = c - 'a';
        	arr[idx]++;
        	if (arr[idx] % 2 == 0) odd--;
        	else odd++;
        }
        return odd <= k;
    }
}
