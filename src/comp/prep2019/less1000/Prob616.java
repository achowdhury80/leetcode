package comp.prep2019.less1000;

public class Prob616 {
	public String addBoldTag(String s, String[] dict) {
		int n;
	    if (s == null || (n = s.length()) < 1 || dict.length < 1) return s;
        boolean[] arr = new boolean[n];
        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
        	if (i > end) {
        		start = -1;
        		end = -1;
        	}
        	for (String w : dict) {
        		if (s.startsWith(w, i)) {
        			if (start == -1) start = i;
        			if (end < i + w.length() - 1) end = i + w.length() - 1;
        		}
        	}
        	if (i >= start && i <= end) arr[i] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	if (!arr[i]) sb.append(s.charAt(i));
            else {
              start = i;
              while (i < s.length() && arr[i]) i++;
              sb.append("<b>");
              sb.append(s.substring(start, i));
              sb.append("</b>");
              i--;
            }
        }
        return sb.toString();
    }
}
