class Solution {
    public int maxSubArray(int[] num) {
        int currsum = num[0];
        int maxsum = num[0];
        for ( int i = 1; i< num.length; i++){
            currsum = Math.max(num[i], num[i]+currsum);

            maxsum = Math.max(currsum, maxsum);
            }
        return maxsum;
    }
}
