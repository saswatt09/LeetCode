class Twitter {

    private Map<Integer, Set<Integer>> userMap; // userId & followeeIds
    private List<Pair<Integer, Integer>> tweetList; // List containining pair of userId and tweetId

    public Twitter() {
        userMap = new HashMap<>();
        tweetList = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {

        userMap.computeIfAbsent(userId, k -> new HashSet<>());
        tweetList.add(new Pair(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return list;
        }

        int index = tweetList.size() - 1;

        while(list.size() < 10 && index >= 0) {
            Pair<Integer, Integer> pair = tweetList.get(index--);
            if(pair.getKey() == userId || userMap.get(userId).contains(pair.getKey())) {
                list.add(pair.getValue());
            }
        }
        
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        userMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */