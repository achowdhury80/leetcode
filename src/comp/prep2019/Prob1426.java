package comp.prep2019;

public class Prob1426 {
	public int countElements(int[] arr) {
        boolean[] num = new boolean[1002];
        for (int i : arr) num[i] = true;
        int result = 0;
        for (int i : arr) if (num[i + 1]) result++;
        return result;
    }
}
