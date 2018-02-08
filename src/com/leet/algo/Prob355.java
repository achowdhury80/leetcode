package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by ayanc on 2/4/18.
 */
public class Prob355 {

  private static int timeStamp=0;
  private Map<Integer, User> userMap;

  /** Initialize your data structure here. */
  public Prob355() {
    userMap = new HashMap<>();
  }

  class User {
    Tweet head;
    Set<Integer> followed;
    int id;
    User(int id) {
      this.id = id;
      followed = new HashSet<>();
      followed.add(id);
    }

    void follow(int id) {
      followed.add(id);
    }

    void unfollow(int id) {
      followed.remove(id);
    }

    void postTweet(int tweetId) {
      Tweet tweet = new Tweet(tweetId);
      tweet.next = head;
      head = tweet;
    }
  }

  private class Tweet {
    int tweetId;
    Tweet next;
    int time;
    Tweet(int tweetId) {
      this.tweetId = tweetId;
      this.time = timeStamp++;
    }
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    if (!userMap.containsKey(userId)) {
      User user = new User(userId);
      userMap.put(userId, user);
    }
    userMap.get(userId).postTweet(tweetId);
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList<>();
    if (!userMap.containsKey(userId)) return result;
    Set<Integer> followed = userMap.get(userId).followed;
    PriorityQueue<Tweet> priorityQueue = new PriorityQueue<Tweet>(followed.size(), (Tweet x, Tweet y) -> y.time - x.time);
    for (int user : followed) {
      Tweet tweet_head = userMap.get(user).head;
      if (tweet_head != null) priorityQueue.offer(tweet_head);
    }
    int n = 0;
    while (!priorityQueue.isEmpty() && n < 10) {
      Tweet tweet = priorityQueue.poll();
      result.add(tweet.tweetId);
      n++;
      if (tweet.next != null) priorityQueue.offer(tweet.next);
    }
    return result;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId)) {
      User user = new User(followerId);
      userMap.put(followerId, user);
    }

    if (!userMap.containsKey(followeeId)) {
      User user = new User(followeeId);
      userMap.put(followeeId, user);
    }

    userMap.get(followerId).follow(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId) || followeeId == followerId) return;
    userMap.get(followerId).unfollow(followeeId);
  }

  public static void main(String[] args) {
    Prob355 prob355 = new Prob355();
    prob355.postTweet(1, 5);
    System.out.println(prob355.getNewsFeed(1));
    prob355.follow(1,2);
    prob355.postTweet(2,6);
    System.out.println(prob355.getNewsFeed(1));
    prob355.unfollow(1, 2);
    System.out.println(prob355.getNewsFeed(1));
  }
}
