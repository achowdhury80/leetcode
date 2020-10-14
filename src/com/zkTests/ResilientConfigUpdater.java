package com.zkTests;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.KeeperException;

public class ResilientConfigUpdater {
	public static final String PATH = "/config";
	
	private ActiveKeyValueStore store;
	private Random random = new Random();
	
	public ResilientConfigUpdater(String hosts) 
			throws IOException, InterruptedException {
		store = new ActiveKeyValueStore();
		store.connect(hosts);
	}
	
	public void run() throws KeeperException, InterruptedException {
		while(true) {
			String value = random.nextInt(100) + "";
			store.write(PATH, value, 5);
			System.out.printf("Set %s to %s\n", PATH, value);
			TimeUnit.SECONDS.sleep(random.nextInt(10));
		}
	}
	
	public static void main(String[] args) throws Exception {
		while(true) {
			try {
				ResilientConfigUpdater configUpdater 
					= new ResilientConfigUpdater("localhost");
				configUpdater.run();
			} catch(KeeperException.SessionExpiredException see) {
				
			} catch(KeeperException ke) {
				ke.printStackTrace();
				break;
			}
		}
	}
}
