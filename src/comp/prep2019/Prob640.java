package comp.prep2019;

public class Prob640 {
	public String solveEquation(String equation) {
		if(equation == null || equation.length() < 3) return "No solution";
	    if(equation.indexOf("=") < 1) return "No solution";
	    String[] exprs = equation.split("=");
	    if(exprs.length != 2) return "No solution";
	    int[] left = evaluateExpr(exprs[0]);
	    int[] right = evaluateExpr(exprs[1]);
	    if (left[0] == right[0] && left[1] == right[1]) return "Infinite solutions";
	    if (left[0] == right[0] && left[1] != right[1]) return "No solution";
	    return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }
	
	private int[] evaluateExpr(String expr) {
		int[] result = new int[2];
		int sign = 1, start = -1;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if(c == 'x') {
				if (start == -1) result[0] += sign;
				else result[0] += sign * Integer.parseInt(expr.substring(start, i));
				start = -1;
				sign = 1;
				continue;
			}
			if (c == '+' || c == '-') {
				if (start != -1) {
					result[1] += sign * Integer.parseInt(expr.substring(start, i));
					sign = 1;
				} 
				if (c == '-') sign = -1;
				start = -1;
			} else {
				if (start == -1) start = i;
			}
		}
		if (start != -1) result[1] += sign * Integer.parseInt(expr.substring(start, expr.length()));
		return result;
	}
}
