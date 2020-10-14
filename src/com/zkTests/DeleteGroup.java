package com.zkTests;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;

public class DeleteGroup extends ConnectionWatcher{
	public void delete(String groupName) 
			throws KeeperException, InterruptedException {
		String path = "/" + groupName;
		try {
			List<String> children = zk.getChildren(path, false);
			if (!children.isEmpty()) {
				for (String child : children) {
					zk.delete(path + "/" + child, -1);
				}
			}
			zk.delete(path, -1);
			
		} catch (KeeperException.NoNodeException nne) {
			System.out.printf("Group %s does not exist\n", groupName);
			System.exit(1);
		}
	}
	
	public static void main(String[] args) 
			throws IOException, InterruptedException, KeeperException {
		DeleteGroup deleteGroup = new DeleteGroup();
		deleteGroup.connect("localhost");
		deleteGroup.delete("zoo");
		deleteGroup.close();
	}
}
