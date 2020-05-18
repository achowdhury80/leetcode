package comp.prep2019;

public class Prob1395 {
	public int numTeams(int[] rating) {
		int n = rating.length;
        if (n < 3) return 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
        	int smaller = 0, larger = 0;
        	for (int j = i + 1; j < n; j++) {
        		if (rating[j] < rating[i]) smaller++;
        		else larger++;
        	}
        	arr[i][0] = smaller;
        	arr[i][1] = larger;
        }
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
        	for (int j = i + 1; j < n - 1; j++) {
        		if (rating[i] < rating[j]) {
        			if (arr[j][1] > 0) result += arr[j][1];
        		} else {
        			if (arr[j][0] > 0) result += arr[j][0];
        		}
        	}
        }
        return result;
    }
}
