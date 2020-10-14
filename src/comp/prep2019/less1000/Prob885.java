package comp.prep2019.less1000;

public class Prob885 {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] result = new int[R * C][2];
		int[] cur = new int[] {r0, c0};
		result[0] = cur;
		int i = 1;
		int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int dirIndex = 0;
		int maxDis = 1, curDis = 0;
        while (i < R * C) {
        	int[] next = new int[] {cur[0] + dirs[dirIndex][0], cur[1] + dirs[dirIndex][1]};
        	curDis++;
        	if (curDis == maxDis) {
        		dirIndex = (dirIndex + 1) % 4;
        		if (dirIndex % 2 == 0) maxDis++;
        		curDis = 0;
        	}
        	cur = next;
        	if(next[0] < 0 || next[0] >= R || next[1] < 0 || next[1] >= C)  continue;
        	result[i] = next;
        	cur = next;
        	i++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob885 prob = new Prob885();
		System.out.println(prob.spiralMatrixIII(1, 4, 0, 0));
	}
}
