package comp.prep2019;

public class Prob1118 {
	public int numberOfDays(int Y, int M) {
        int[] m = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (M != 2) return m[M - 1];
        if (Y % 4 != 0 || (Y % 100 == 0 && Y % 400 != 0)) return m[1];
        return m[1] + 1;
    }
}
