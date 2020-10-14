package comp.prep2019;
import java.util.*;

public class Prob1472 {
	private List<String> urlList;
	private int cur;
	public Prob1472(String homepage) {
		urlList = new ArrayList<>();
		urlList.add(homepage);
		cur = 0;
    }
    
    public void visit(String url) {
    	while(urlList.size() > cur + 1) urlList.remove(urlList.size() - 1);
        urlList.add(url);
        cur++;
    }
    
    public String back(int steps) {
        cur -= steps;
        if (cur < 0) cur = 0;
        return urlList.get(cur);
    }
    
    public String forward(int steps) {
        cur += steps;
        if (cur > urlList.size() - 1) cur = urlList.size() - 1;
        return urlList.get(cur);
    }
}
