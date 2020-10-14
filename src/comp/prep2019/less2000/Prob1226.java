package comp.prep2019.less2000;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Prob1226 {
	private Lock[] locks;
	public Prob1226() {
        locks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) locks[i] = new ReentrantLock();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = philosopher, rightFork = ((philosopher - 1) + 5) % 5;
        while (true) {
        	if (locks[leftFork].tryLock()) {
	        	try {
	        		if (locks[rightFork].tryLock()) {
	        			try {
	        				pickLeftFork.run();
	        				pickRightFork.run();
	        				eat.run();
	        				putLeftFork.run();
	        				putRightFork.run();
	        				return;
	        			}
	        			finally {
	        				locks[rightFork].unlock();
	        			}
	        		}
	        	} finally {
	        		locks[leftFork].unlock();
	        	}
        	}
        }
        
    }
}
