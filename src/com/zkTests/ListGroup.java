package com.zkTests;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class ListGroup extends ConnectionWatcher{
	public void list(String groupName) 
			throws KeeperException, InterruptedException {
		String path = "/" + groupName;
		try {
			List<String> children = zk.getChildren(path, false);
			if (children.isEmpty()) {
				System.out.printf("No members in group %s\n", groupName);
				System.exit(1);
			}
			for (String child : children) {
				System.out.println(child);
			}
		} catch (KeeperException.NoNodeException nne) {
			System.out.printf("Group %s does not exist\n", groupName);
			System.exit(1);
		}
	}
	
	public static void main(String[] args) 
			throws IOException, InterruptedException, KeeperException {
		ListGroup listGroup = new ListGroup();
		listGroup.connect("localhost");
		listGroup.list("zoo");
		listGroup.close();
	}
}
