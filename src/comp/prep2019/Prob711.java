package comp.prep2019;
import java.util.*;
public class Prob711 {
	/*int[][] grid;
    boolean[][] seen;
    ArrayList<Integer> shape;*/

    /*public void explore(int r, int c) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {
            seen[r][c] = true;
            shape.add(r * grid[0].length + c);
            explore(r+1, c);
            explore(r-1, c);
            explore(r, c+1);
            explore(r, c-1);
        }
    }*/

    public int numDistinctIslands2(int[][] grid) {
		int m, n;
        if ((m = grid.length) == 0 || (n = grid[0].length) == 0) return 0;
        Set<String> shapes = new HashSet<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			Queue<int[]> q = new LinkedList<>();
        			q.offer(new int[] {i, j});
        			grid[i][j] = -1;
        			List<Integer> shape = new ArrayList<>();
        			shape.add(i * n + j);
        			while(!q.isEmpty()) {
        				int[] cur = q.poll();
        				for (int[] dir : dirs) {
        					int[] next = new int[] {cur[0] + dir[0], 
        							cur[1] + dir[1]};
        					if (next[0] < 0 || next[0] == m || next[1] < 0 
        							|| next[1] == n || grid[next[0]][next[1]] != 1) 
        						continue;
        					grid[next[0]][next[1]] = -1;
        					shape.add(next[0] * n + next[1]);
        				}
        			}
        			shapes.add(findCanonical(shape, n));
        		}
        	}
        }
        return shapes.size();
    }
    
    private String findCanonical(List<Integer> shape, int n) {
		String result = "";
		for (int c = 0; c < 8; c++) {
            int[] xs = new int[shape.size()]; 
			int[] ys = new int[shape.size()]; 
			int[] out = new int[shape.size()];
			int t = 0;
            for (int z: shape) {
                int x = z / n, y = z % n;
                //x y, x -y, -x y, -x -y
                //y x, y -x, -y x, -y -x
                xs[t] = c < 2 ? x : (c < 4 ? -x : (c < 6 ? y : - y));
				ys[t] = c < 4 ? (c % 2 == 0 ? y : - y) :(c % 2 == 0 ? x : -x);
				t++;
            }
            int mx = Integer.MAX_VALUE, my = Integer.MAX_VALUE;
            for (int x: xs) mx = Math.min(mx, x);
            for (int y: ys) my = Math.min(my, y);

            for (int j = 0; j < shape.size(); j++) {
				out[j] = (xs[j] - mx) * n + (ys[j] - my);
			}
			Arrays.sort(out);
            String candidate = Arrays.toString(out);
			if (result.compareTo(candidate) < 0) result = candidate;
		}
		return result;
	}

    /*public int numDistinctIslands21(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<String>();

        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                shape = new ArrayList();
                explore(r, c);
                if (!shape.isEmpty()) {
                    shapes.add(findCanonical(shape, grid[0].length));
                }
            }
        }

        return shapes.size();
    }*/
}
