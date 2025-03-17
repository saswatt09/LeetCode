class Solution {
    Map<Integer, Integer> cache  = new HashMap<>();
    public int climbStairs(int n) {
        return dp(n);
    }
    int dp(int i){
        //Base case
        if(i<=2) return i;
        //Recurrence Relation
        if(cache.containsKey(i)){
            return cache.get(i);
        }else{
            int res = dp(i-1) + dp(i-2);
            cache.put(i, res);
            return res;
        }
    }
}