class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int [] result = new int[nums.length];
        int left = 0, right = nums.length-1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                result[left] = nums[i];
                left++;
            }
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > pivot) {
                result[right] = nums[j];
                right--;
            }
        }

        while (left <= right) {
            result[left] = pivot;
            left++;
        }

        return result;
    }
}