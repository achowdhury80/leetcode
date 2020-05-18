package comp.prep2019;

public class Prob705 {
	private boolean[] arr;
	/** Initialize your data structure here. */
    public Prob705() {
        arr = new boolean[1000001];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
    	arr[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}
