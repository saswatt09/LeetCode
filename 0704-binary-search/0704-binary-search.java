class Solution {
     public int search(int[] nums, int target) {
// Iterative Approach
//         int i = 0;
//         int j = nums.length-1;
//         while(i<=j) {
//             int mid = i + (j-i) /2;
//         if( nums[mid] == target ){
//             return mid;
//         }else if(nums[mid] < target){
//             i = mid+1;
//         }else{
//             j = mid-1;
//         }
//         }
//         return -1;
//     }
// }

// Recursion
return bSearch(nums, 0, nums.length - 1, target);
    }
    public int bSearch(int[] nums, int l, int r, int target) {
        if (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target) {
                return bSearch(nums, m+1, r, target);
            } else {
                return bSearch(nums, l, m - 1, target);
            }
        }
        return -1;
    }
}