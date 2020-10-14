package threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Test {
	private AtomicLong count = new AtomicLong(0);
	
	ThreadLocal<String> StringHolder = new ThreadLocal<String>() {
		public String initialValue() {
			return "hello";
		}
	};
	
	/*public String get() {
		StringHolder.get();
	}*/
	public long getCount() {
		return count.incrementAndGet();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		CountDownLatch latch = new CountDownLatch(1);
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				try {
				latch.await();
				} catch (InterruptedException ie) {
					
				}
				for (int i = 0; i < 10; i++) System.out.println(test.getCount());
			}
		};
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		latch.countDown();
		t1.join();
		t2.join();
	}
}
