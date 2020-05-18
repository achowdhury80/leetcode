package comp.prep2019;

public class Prob1232 {
	public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) return true;
        if (coordinates[0][0] == coordinates[1][0]) {
        	for (int i = 1; i < coordinates.length; i++) {
        		if (coordinates[i - 1][0] != coordinates[i][0]) return false;
        	}
        	return true;
        }
        double slope = (coordinates[1][1] - coordinates[0][1] + 0.0) 
        		/ (coordinates[1][0] - coordinates[0][0]);
        for (int i = 1; i < coordinates.length; i++) {
        	if (slope != (coordinates[i][1] - coordinates[i - 1][1] + 0.0) 
        		/ (coordinates[i][0] - coordinates[i - 1][0])) return false;
        }
        return true;
    }
}
