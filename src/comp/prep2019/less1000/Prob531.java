package comp.prep2019.less1000;

public class Prob531 {
	public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        for (int i = 0; i < m; i++) {
        	int count = 0;
        	for (int j = 0; j < n; j++) {
        		if (picture[i][j] == 'B') count++;
        		if (count > 1) {
        			picture[i][0] = picture[i][0] == 'W' ? 'X' : 'Y';
        			break;
        		}
        	}
        }
        char top = 'W';
        for (int j = 0; j < n; j++) {
        	int count = 0;
        	for (int i = 0; i < m; i++) {
        		if (picture[i][j] == 'B' || picture[i][j] == 'Y') count++;
        		if (count > 1) {
        			if (j == 0) top = 'X';
        			else picture[0][j] = picture[0][j] == 'W' ? 'X' : 'Y';
        			break;
        		}
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (picture[i][j] == 'B' || picture[i][j] == 'Y') {
        			if (picture[i][0] != 'X' && picture[i][0] != 'Y' && (j == 0 ? 
        					(top != 'X') : (picture[0][j] != 'X' && picture[0][j] != 'Y'))) {
        				result++;
        			}
        			
        		}
        	}
        }
        return result;
    }
}
