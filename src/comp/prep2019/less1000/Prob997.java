package comp.prep2019.less1000;

public class Prob997 {
	/**
	 * O(N) time N space
	 * @param N
	 * @param trust
	 * @return
	 */
	public int findJudge(int N, int[][] trust) {
		// arr[i] = -1 if i trusts somebody else arr[i] is the count of people 
		//trusts i
        int[] arr = new int[N + 1];
        for (int[] t : trust) {
        	arr[t[0]] = -1;
        	if (arr[t[1]] != -1) arr[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
        	if (arr[i] == N - 1) return i;
        }
        return -1;
    }
}
