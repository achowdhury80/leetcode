package com.zkTests;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;

public class ConfigWatcher implements Watcher{

	private ActiveKeyValueStore store;
	
	public ConfigWatcher(String hosts) throws IOException, InterruptedException {
		store = new ActiveKeyValueStore();
		store.connect(hosts);
	}
	
	public void displayConfig() throws KeeperException, InterruptedException {
		String value = store.read(ConfigUpdater.PATH, this);
		System.out.printf("Read %s as %s\n", ConfigUpdater.PATH, value);
	}
	
	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeDataChanged) {
			try {
				displayConfig();
			} catch(KeeperException ke) {
				System.err.printf("KeeperException: %s. Exiting.\n", ke);
			} catch(InterruptedException ie) {
				System.err.println("Interrupted. Exiting.");
				Thread.currentThread().interrupt();
			}
		}
		
	}

	public static void main(String[] args) 
			throws IOException, InterruptedException, KeeperException {
		ConfigWatcher configWatcher = new ConfigWatcher("localhost");
		configWatcher.displayConfig();
		
		Thread.sleep(Long.MAX_VALUE);
	}
}
