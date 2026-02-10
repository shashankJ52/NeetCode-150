/*
 * NeetCode 150 - Problem 3: Valid Anagram
 *
 * Approach:
 * First check if both strings have the same length.
 * Use a HashMap to count the frequency of each character in string s.
 * Then iterate through string t and decrement the corresponding character
 * count. If a character is missing or count goes below zero, it is not
 * a valid anagram.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {

        // Step 1: Length check
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Step 2: Count characters in s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 3: Decrement counts using t
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }

        // Step 4: Valid anagram
        return true;
    }
}
