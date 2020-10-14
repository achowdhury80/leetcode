package comp.prep2019.less1000;
import java.util.*;
public class Prob761 {
	public String makeLargestSpecial(String S) {
        char[] arr = S.toCharArray();
        int anchor = 0, bal = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '1') bal++;
        	else bal--;
        	if (bal == 0) {
        		list.add("1" + makeLargestSpecial(S.substring(anchor + 1, i)) + "0");
        		anchor = i + 1;
        	} 
        }
        Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }
}
