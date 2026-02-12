"""
NeetCode 150 - Problem 4: Group Anagrams

Approach:
Use a dictionary to group words by their character frequency count.
For each word, create a 26-length frequency array (for 'a' to 'z').
Convert this array into a tuple (since lists cannot be dictionary keys)
and use it as the key to group anagrams together.

Time Complexity: O(m * n)
    m = number of strings
    n = average length of each string

Space Complexity: O(m * n)
"""

from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)

        for word in strs:
            count = [0] * 26  # Frequency count for 'a' to 'z'

            for ch in word:
                count[ord(ch) - ord('a')] += 1

            res[tuple(count)].append(word)

        return list(res.values())
