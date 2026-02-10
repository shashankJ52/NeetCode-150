"""
NeetCode 150 - Problem 2: Valid Anagram

Approach:
First check if both strings have the same length.
Use a dictionary to count the frequency of each character in string s.
Then iterate through string t and decrement the corresponding character
count. If a character is missing or its count goes below zero, it is not
a valid anagram.

Time Complexity: O(n)
Space Complexity: O(n)
"""

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # Step 1: Length check
        if len(s) != len(t):
            return False

        freq = {}

        # Step 2: Count characters in s
        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        # Step 3: Decrement counts using t
        for ch in t:
            if ch not in freq or freq[ch] == 0:
                return False
            freq[ch] -= 1

        # Step 4: Valid anagram
        return True
