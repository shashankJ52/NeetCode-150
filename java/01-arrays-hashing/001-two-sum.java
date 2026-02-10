/*
 * NeetCode 150 - Problem 1: Two Sum
 *
 * Approach:
 * Use a HashMap to store numbers encountered so far along with their indices.
 * While iterating through the array, compute the complement (target - current number).
 * If the complement already exists in the map, return the indices of the two numbers.
 * This allows solving the problem in a single pass.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{ map.get(complement), i };
            }

            // Store current number with its index
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}

