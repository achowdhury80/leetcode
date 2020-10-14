package comp.prep2019.less2000;
import java.util.*;
public class Prob1352 {
	private List<Integer> product;
	private int lastZeroIndex;
	public Prob1352() {
		product = new ArrayList<>();
		lastZeroIndex = -1;
    }
    
    public void add(int num) {
        if (num == 0) {
        	product.add(1);
        	lastZeroIndex = product.size() - 1;
        } else {
        	if (product.size() == 0) product.add(num);
        	else product.add(num * product.get(product.size() - 1));
        }
    }
    
    public int getProduct(int k) {
        if (lastZeroIndex > -1 && product.size() - k <= lastZeroIndex) return 0;
        return product.get(product.size() - 1) / (k == product.size() ? 1 : product.get(product.size() - k - 1));
    }
}
