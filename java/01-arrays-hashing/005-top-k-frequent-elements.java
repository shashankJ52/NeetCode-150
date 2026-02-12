/*
 * NeetCode 150 - Problem 5: Top K Frequent Elements
 *
 * Approach:
 * 1. Use a HashMap to count the frequency of each number.
 * 2. Create a bucket array where the index represents the frequency.
 *    Each bucket stores numbers that appear that many times.
 * 3. Traverse the bucket array in reverse (highest frequency first)
 *    and collect the top k frequent elements.
 *
 * This avoids using a heap and achieves linear time complexity.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array (index = frequency)
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // Step 3: Collect top k frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
