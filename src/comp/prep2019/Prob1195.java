package comp.prep2019;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Prob1195 {
	private int n;
	private Lock mutex = new ReentrantLock();
	private int count;

    public Prob1195(int n) {
        this.n = n;
        this.count = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true) {
        	mutex.lock();
        	if (count > n) {
        		mutex.unlock();
        		return;
        	}
        	if (count % 3 == 0 && count % 5 != 0) {
        		printFizz.run();
        		count++;
        	}
        	mutex.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
    	while(true) {
        	mutex.lock();
        	if (count > n) {
        		mutex.unlock();
        		return;
        	}
        	if (count % 3 != 0 && count % 5 == 0) {
        		printBuzz.run();
        		count++;
        	}
        	mutex.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    	while(true) {
        	mutex.lock();
        	if (count > n) {
        		mutex.unlock();
        		return;
        	}
        	if (count % 3 == 0 && count % 5 == 0) {
        		printFizzBuzz.run();
        		count++;
        	}
        	mutex.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	while(true) {
        	mutex.lock();
        	if (count > n) {
        		mutex.unlock();
        		return;
        	}
        	if (count % 3 != 0 && count % 5 != 0) {
        		printNumber.accept(count);
        		count++;
        	}
        	mutex.unlock();
        }
    }
    
    interface IntConsumer {
    	void accept(int x);
    }
}
