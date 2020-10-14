package comp.prep2019.less1000;
import java.util.*;
public class Prob158 {
	private List<Character> prev = new ArrayList<>();
	private boolean eof = false;
	public int read(char[] buf, int n) {
        int idx = -1;
        int min = Math.min(prev.size(), n);
        for (int i = 0; i < min; i++) {
        	buf[++idx] = prev.remove(0);
        	n--;
        }
        char[] temp = new char[4];
        while(!eof && n > 0) {
        	int lastRead = read4(temp);
        	if (lastRead < 4) eof = true;
        	if (lastRead == 0) return idx + 1;
        	min = Math.min(lastRead, n);
        	for (int i = 0; i < min; i++) {
        		buf[++idx] = temp[i];
        	}
        	n -= min;
        	for (int i = min; i < lastRead; i++) {
        		prev.add(temp[i]);
        	}
        }
        return idx + 1;
    }
	
	int read4(char[] buf) {
		return 0;
	}
}
