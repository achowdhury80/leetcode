package comp.prep2019.less2000;
import java.util.*;
public class Prob1441 {
	public List<String> buildArray(int[] target, int n) {
        int i = 0;
        List<String> list = new ArrayList<>();
        int last = 0;
        while(i < target.length) {
        	int cur = target[i];
        	while(last + 1 < cur) {
        		last++;
            	list.add("Push");
            	list.add("Pop");
        	}
        	last++;
        	list.add("Push");
        	i++;
        }
        return list;
    }
}
