package comp.prep2019;

public class Prob308 {
	private int[] bIndexTreeArr;
	private int col;
	private int[][] matrix;
  public Prob308(int[][] matrix) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
    col = matrix[0].length;
    this.matrix = matrix;
    bIndexTreeArr = constructBIndexTree(matrix);
  }

  public void update(int row, int col, int val) {
    int incr = val - matrix[row][col];
    matrix[row][col] = val;
    increment(row, col, incr);
  }

  public void increment(int row, int col, int incr) {
    int index = findIndex(row, col);
    int next = index + 1;
    do {
      bIndexTreeArr[next] += incr;
      next = findNext(next);
    } while (next < bIndexTreeArr.length);
  }

  private int prefixSum(int index) {
    int sum = 0;
    int next = index + 1;
    do {
      sum += bIndexTreeArr[next];
      next = findParent(next);
    } while (next > 0);
    return sum;
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; i++) {
      int leftIndex = findIndex(i, col1);
      int rightIndex = findIndex(i, col2);
      sum += prefixSum(rightIndex) - (leftIndex == 0 ? 0 : prefixSum(leftIndex - 1));
    }
    return sum;
  }

  private int[] constructBIndexTree(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    bIndexTreeArr = new int[m * n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        increment(i, j, matrix[i][j]);
      }
    }
    return bIndexTreeArr;
  }

  private int findIndex(int r, int c) {
    return r * col + c;
  }

  private int findParent(int index) {
    return index - (index & (~index + 1));
  }

  private int findNext(int index) {
    return index + (index & (~index + 1));
  }
    
}
