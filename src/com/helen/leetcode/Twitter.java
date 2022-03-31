package com.helen.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/discuss/82837/
 * I use a map to track the tweets for each user. When we need to generate a news feed,
 * I merge the news feed for all the followees and take the most recent 10. This is unlikely to perform,
 * but the code passes the OJ. I’m sure design interviews ask for performance trade-offs
 * and just posting this code in a design interview will not help you get an offer.
 * Created by Helen on 12/31/2017.
 */
public class Twitter {
    int cnt = 0;
    Map<Integer, Set<Integer>> fan = new HashMap<>();
    Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!fan.containsKey(userId)) {
            fan.put(userId, new HashSet<>());
        }
        fan.get(userId).add(userId); // do not forget to add userId in its own followees
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        tweets.get(userId).addFirst(new Tweet(tweetId, cnt++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!fan.containsKey(userId)) {
            return new LinkedList<>();
        }
        PriorityQueue<Tweet> queue = new PriorityQueue<>((t1, t2) -> (t2.timeline - t1.timeline));
        fan.get(userId).stream()
                .filter(f -> tweets.containsKey(f))
                .forEach(f -> tweets.get(f).forEach(queue::add));
        List<Integer> res = new LinkedList<>();
        while (queue.size() > 0 && res.size() < 10) {
            res.add(queue.poll().id);
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!fan.containsKey(followerId)) {
            fan.put(followerId, new HashSet<>());
        }
        fan.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (fan.containsKey(followerId) && followeeId != followerId) {
            fan.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        int timeline;
        int id;

        public Tweet(int tweetId, int timeline) {
            this.timeline = timeline;
            this.id = tweetId;
        }
    }
}
