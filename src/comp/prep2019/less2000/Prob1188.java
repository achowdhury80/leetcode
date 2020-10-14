package comp.prep2019.less2000;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Prob1188 {
	private int capacity, tail, head, count;
	private Lock lock;
	private Condition notFull, notEmpty;
	private int[] items;
	public Prob1188(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
        	while (count == items.length) 
        		notFull.await();
        	items[tail] = element;
        	if (++tail == items.length) tail = 0;
        	++count;
        	notEmpty.signal();
        } finally {
        	lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
    	lock.lock();
        try {
        	while (count == 0) 
        		notEmpty.await();
        	int element = items[head];
        	if (++head == items.length) head = 0;
        	--count;
        	notFull.signal();
        	return element;
        } finally {
        	lock.unlock();
        }
    }
    
    public int size() {
        return count;
    }
}
