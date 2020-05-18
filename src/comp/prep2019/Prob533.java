package comp.prep2019;
import java.util.*;
public class Prob533 {
	public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length, n = picture[0].length;
        int[] rowBlackPixCount= new int[m], colBlackPixCount = new int[n];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
        	String rowString = "";
        	for (int j = 0; j < n; j++) {
        		if (picture[i][j] == 'B') {
        			rowBlackPixCount[i]++;
        			colBlackPixCount[j]++;
        		}
        		rowString += picture[i][j];
        	}
        	map.put(i, rowString);
        }
        int result = 0;
        for (int j = 0; j < n; j++) {
        	for (int i = 0; i < m; i++) {
        		if (picture[i][j] == 'B' && rowBlackPixCount[i] == N && colBlackPixCount[j] == N) {
        			int count = 0;
        			boolean flag = true;
        			for (int k = 0; k < m; k++) {
        				if (picture[k][j] == 'B') {
        					if (map.get(i).equals(map.get(k))) count++;
        					else {
        						flag = false;
            					break;
        					}
        				}
        			}
        			if(flag) result += count;
        			break;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob533 prob = new Prob533();
		System.out.println(prob.findBlackPixel(new char[][] {{'W', 'B', 'W', 'B', 'B', 'W'},    
			 {'W', 'B', 'W', 'B', 'B', 'W'},    
			 {'W', 'B', 'W', 'B', 'B', 'W'},    
			 {'W', 'W', 'B', 'W', 'B', 'W'}}, 3));
	}
}
