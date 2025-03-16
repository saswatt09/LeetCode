class Solution {
    public int maxSubArray(int[] num) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;

        for ( int i = 0; i< num.length; i++){
                    currsum += num[i];
                
                if (maxsum < currsum){
                    maxsum = currsum;
                }
                if (currsum <0){
                    currsum = 0;
            }
        }
        return maxsum;
    }
}
