package com.zkTests;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class JoinGroup extends ConnectionWatcher{
	public void join(String groupName, String memberName) 
			throws KeeperException, InterruptedException {
		String path = "/" + groupName + "/" + memberName;
		String createdPath = zk.create(path, null, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		System.out.println("Created " + createdPath);
	}
	
	public static void main(String[] args) 
			throws IOException, InterruptedException, KeeperException {
		JoinGroup joinGroup = new JoinGroup();
		joinGroup.connect("localhost");
		joinGroup.join("zoo", "goat");
		Thread.sleep(Long.MAX_VALUE);
	}
}
