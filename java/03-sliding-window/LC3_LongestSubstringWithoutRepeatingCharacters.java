/*
 * LeetCode #3 - Longest Substring Without Repeating Characters
 *
 * Pattern:
 * Sliding Window + HashMap (last seen index)
 *
 * Approach:
 * Use two pointers (left, right) for the window.
 * Maintain a map of each character to its last seen index.
 * If a character repeats inside the window, jump left to
 * max(left, lastSeen[char] + 1).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset)) ~ O(1) for ASCII
 */

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }

            lastSeen.put(ch, right);
            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}

