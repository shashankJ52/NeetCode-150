/*
 * NeetCode 150 - Problem 4: Group Anagrams
 *
 * Approach 1:
 * Sort each word and use the sorted word as key.
 * Time Complexity: O(m * n log n)
 *
 * Approach 2 (Optimal):
 * Use a 26-length frequency count array for each word.
 * Convert the count array to a String key and group words
 * with the same frequency pattern using a HashMap.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */


import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> wordMap = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];

            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);

            wordMap.putIfAbsent(key, new ArrayList<>());
            wordMap.get(key).add(word);
        }

        return new ArrayList<>(wordMap.values());
    }
}
