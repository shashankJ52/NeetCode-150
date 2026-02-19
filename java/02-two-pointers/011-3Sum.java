/*
 * LeetCode #15 - 3Sum
 *
 * Approach:
 * 1. Sort the array.
 * 2. Fix one element (i).
 * 3. Use two pointers (left and right) to find pairs
 *    that sum to -nums[i].
 * 4. Skip duplicates for i, left, and right.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) (excluding result list)
 */

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optimization: If current number > 0, break
            if (nums[i] > 0) break;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // Skip duplicates on left
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    // Skip duplicates on right
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

