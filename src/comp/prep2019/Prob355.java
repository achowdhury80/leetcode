package comp.prep2019;
import java.util.*;
public class Prob355 {
	private Map<Integer, List<int[]>> tweetMap;
	private int timestamp;
	private Map<Integer, Set<Integer>> followMap;
	/** Initialize your data structure here. */
    public Prob355() {
    	timestamp = 0;
    	tweetMap = new HashMap<>();
    	followMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        List<int[]> tweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        tweets.add(new int[] {tweetId, timestamp});
        tweetMap.put(userId, tweets);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> result = new ArrayList<>();
    	Queue<int[]> q = new PriorityQueue<>((x, y) -> tweetMap.get(y[0]).get(y[1])[1] - tweetMap.get(x[0]).get(x[1])[1]);
    	if (tweetMap.containsKey(userId)) q.offer(new int[] {userId, tweetMap.get(userId).size() - 1});
    	if (followMap.containsKey(userId)) {
    		Set<Integer> set = followMap.get(userId);
    		for (int u : set) {
    			if (tweetMap.containsKey(u)) q.offer(new int[] {u, tweetMap.get(u).size() - 1});
    		}
    	}
    	while(!q.isEmpty() && result.size() < 10) {
    		int[] arr = q.poll();
    		result.add(tweetMap.get(arr[0]).get(arr[1])[0]);
    		arr[1]--;
    		if (arr[1] > -1) q.offer(arr);
    	}
    	return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if (followerId == followeeId) return;
    	Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
    	set.add(followeeId);
    	followMap.put(followerId, set);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (!followMap.containsKey(followerId)) return;
    	followMap.get(followerId).remove(followeeId);
    }
}
