package comp.prep2019.less2000;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Prob1117 {
	private Semaphore hSem, oSem;
	private AtomicInteger hCount = new AtomicInteger(0);
	public Prob1117() {
        hSem = new Semaphore(2);
        oSem = new Semaphore(0);
       
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hSem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (hCount.incrementAndGet() == 2) {
        	hCount.set(0);
        	oSem.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSem.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		hSem.release(2);
    }
}
