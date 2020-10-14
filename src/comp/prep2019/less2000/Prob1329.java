package comp.prep2019.less2000;
import java.util.*;
public class Prob1329 {
	public int[][] diagonalSort(int[][] mat) {
		int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i > 0 && j > 0) continue;
        		sort(mat, i, j);
        	}
        }
        return mat;
    }
	
	private void sort(int[][] mat, int r, int c) {
		List<Integer> list = new ArrayList<>();
		int i = r, j = c;
		while(i < mat.length && j < mat[0].length) {
			list.add(mat[i][j]);
			i++;
			j++;
		}
		Collections.sort(list);
		i = r;
		j = c;
		int idx = 0;
		while(i < mat.length && j < mat[0].length) {
			mat[i][j] = list.get(idx++);
			i++;
			j++;
		}
	}
}
