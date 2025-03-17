class Solution {
    Map<Integer, Integer> cache  = new HashMap<>();
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length -1);
    }

    int dp (int i ){
        //Base Case
        if(i==0) return nums[0];
        if(i==1) return Math.max(nums[0], nums[1]);
        if(cache.containsKey(i)){
            return cache.get(i);
        }else{
            int doNotRob = dp(i-1);
            int rob = dp(i-2) + nums[i];

            int res = Math.max(doNotRob, rob);
            cache.put(i, res);
            return res;
        } 
    }
}