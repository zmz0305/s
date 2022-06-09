import java.util.*;

public class Lc355 {
    class Twitter {
        public static int timestamp = 0;
        class Tweet {
            public int tweetId;
            public int time;
            public Tweet(int tweetId) {
                this.tweetId = tweetId;
                this.time = timestamp++;
            }
        }

        Map<Integer, LinkedList<Tweet>> userTweetMap = new HashMap<>();
        Map<Integer, Set<Integer>> followerFolloweeMap = new HashMap<>();

        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            userTweetMap.putIfAbsent(userId, new LinkedList<>());
            userTweetMap.get(userId).addLast(new Tweet(tweetId));
            while (userTweetMap.get(userId).size() > 10) {
                userTweetMap.get(userId).pollFirst();
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!userTweetMap.containsKey(userId)) {
                return res;
            }
            PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
            pq.addAll(userTweetMap.get(userId));
            Set<Integer> followees = followerFolloweeMap.get(userId);
            if (followees != null) {
                for (int followee : followees) {
                    pq.addAll(userTweetMap.get(followee));
                }
            }
            for (int i = 0; i < 10 && pq.size() > 0; i++) {
                res.add(pq.poll().tweetId);
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            followerFolloweeMap.putIfAbsent(followerId, new HashSet<>());
            followerFolloweeMap.get(followerId).add(followeeId);
            userTweetMap.putIfAbsent(followerId, new LinkedList<>());
            userTweetMap.putIfAbsent(followeeId, new LinkedList<>());
        }

        public void unfollow(int followerId, int followeeId) {
            if (followerFolloweeMap.containsKey(followerId)) {
                followerFolloweeMap.get(followerId).remove(followeeId);
            }
        }
    }

}
