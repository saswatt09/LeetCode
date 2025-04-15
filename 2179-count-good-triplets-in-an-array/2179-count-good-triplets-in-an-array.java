import java.util.*;

public class Solution {
    public int goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> pos2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos2.put(nums2[i], i);
        }

        // Map nums1[i] to its position in nums2
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos2.get(nums1[i]);
        }

        BIT bitLeft = new BIT(n);
        BIT bitRight = new BIT(n);
        int[] rightCount = new int[n];

        // Count right side first
        for (int i = n - 1; i >= 0; i--) {
            rightCount[i] = bitRight.query(n - 1) - bitRight.query(mapped[i]);
            bitRight.update(mapped[i], 1);
        }

        int result = 0;

        // Count left and calculate triplets
        for (int i = 0; i < n; i++) {
            int left = bitLeft.query(mapped[i] - 1);
            int right = rightCount[i];
            result += left * right;
            bitLeft.update(mapped[i], 1);
        }

        return result;
    }

    static class BIT {
        private int[] tree;
        private int size;

        public BIT(int size) {
            this.size = size;
            this.tree = new int[size + 2];
        }

        public void update(int index, int delta) {
            index += 1;
            while (index <= size + 1) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            int result = 0;
            index += 1;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}