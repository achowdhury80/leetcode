package comp.prep2019.less2000;
import java.util.*;
public class Prob1436 {
	/**
	 * o(N) time and space
	 * @param paths
	 * @return
	 */
	public String destCity(List<List<String>> paths) {
        Set<String> destSet = new HashSet<>();
        Set<String> nonDestSet = new HashSet<>();
        for (List<String> path : paths) {
        	nonDestSet.add(path.get(0));
        	destSet.remove(path.get(0));
        	if (!nonDestSet.contains(path.get(1))) destSet.add(path.get(1));
        }
        return destSet.toArray(new String[destSet.size()])[0];
    }
}
