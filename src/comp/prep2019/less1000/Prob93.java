package comp.prep2019.less1000;
import java.util.*;
public class Prob93 {
	public List<String> restoreIpAddresses(String s) {
		int n = s.length();
		if(n < 4 || n > 12) return new ArrayList<>();
		return validate(s, 4);
    }
	
	private List<String> validate(String s, int count) {
		List<String> result = new ArrayList<>();
		int n = s.length();
		if(n < count || n > 3 * count) return result;
		if (count == 1) {
			if(isValid(s)) result.add(s);
			return result;
		}
		for (int i = 0; i < Math.min(3, n - count + 1); i++) {
			String start = s.substring(0, i + 1);
			if(!isValid(start)) continue;
			List<String> parts = validate(s.substring(i + 1), count - 1);
			if (parts == null) continue;
			for (String part : parts) result.add(start + "." + part);
		}
		return result;
	}
	
	private boolean isValid(String s) {
		if (!"0".equals(s) && s.startsWith("0")) return false;
		int i = Integer.parseInt(s);
		if (i > 255) return false;
		return true;
	}
}
