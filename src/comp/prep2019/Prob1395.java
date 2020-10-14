package comp.prep2019;

public class Prob1395 {
	/**
	 * O(N^2)
	 * @param rating
	 * @return
	 */
	public int numTeams(int[] rating) {
		int n = rating.length;
        if (n < 3) return 0;
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
        	int leftLarger = 0, leftSmaller = 0, rightLarger = 0, rightSmaller = 0;
        	for (int j = 0; j < i; j++) {
            	if (rating[i] > rating[j]) leftSmaller++;
            	else leftLarger++;
            }
        	for (int j = i + 1; j < n; j++) {
            	if (rating[i] < rating[j]) rightLarger++;
            	else rightSmaller++;
            }
        	result += (leftSmaller * rightLarger) + (leftLarger * rightSmaller);
        }
        return result;
    }
}
