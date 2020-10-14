package comp.prep2019.less1000;

public class Prob427 {
	
	public Node construct(int[][] grid) {
        if (grid == null) return null;
        return construct(grid, 0, 0, grid.length);
    }
    
    public Node construct(int[][] grid, int row, int col, int width) {
        boolean val = (grid[row][col] == 1);
        boolean flag= true;
        for (int i = row; i < row + width; i++) {
            for (int j = col; j < col + width; j++) {
                if (val != (grid[i][j] == 1)) {
                    flag = false;
                    break;
                } 
            }
        }
        Node node = new Node();
        if (flag == true) {
            node.isLeaf = true;
            node.val = (grid[row][col] == 1);
        } else {
            node.topLeft = construct(grid, row, col, width / 2);
            node.topRight = construct(grid, row, col + width / 2, width / 2);
            node.bottomLeft = construct(grid, row + width / 2, col, width / 2);
            node.bottomRight = construct(grid, row + width / 2, col + width / 2, width / 2);
        }
        return node;
    }
	
	class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    public Node() {}

	    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
	        val = _val;
	        isLeaf = _isLeaf;
	        topLeft = _topLeft;
	        topRight = _topRight;
	        bottomLeft = _bottomLeft;
	        bottomRight = _bottomRight;
	    }
	}

}
