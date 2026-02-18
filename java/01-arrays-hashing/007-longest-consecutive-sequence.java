/*
 * NeetCode 150 - Problem 7: Longest Consecutive Sequence
 *
 * Approach:
 * 1. Insert all numbers into a HashSet for O(1) lookups.
 * 2. Only start counting when the current number is the beginning
 *    of a sequence (i.e., n - 1 is not in the set).
 * 3. Expand forward while consecutive numbers exist.
 *
 * This ensures each number is processed at most twice.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {

            // Only start counting if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {

                int currentNum = num;
                int length = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
