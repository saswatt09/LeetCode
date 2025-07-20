class Solution {
    public boolean check(int[] nums) {
        int cnt = 0;
        int n = nums.length;

        for (int i = 0; i< n ; i++){
            int next= (i+1)%n;

            if(nums[i] > nums[next]){
                cnt++;
            }
        }
        return cnt<=1;
    }
}