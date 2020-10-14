package comp.prep2019.less2000;

public class Prob1476 {
	private int[][] rectangle;
	public Prob1476(int[][] rectangle) {
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2,
    		int newValue) {
        for (int i = row1; i <= row2; i++) {
        	for (int j = col1; j <= col2; j++) {
        		rectangle[i][j] = newValue;
        	}
        }
    }
    
    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
