"""
LeetCode #3 - Longest Substring Without Repeating Characters

Pattern:
Sliding Window + HashMap (last seen index)

Approach:
Use two pointers (left, right) for the window.
Track the last seen index of each character.
When a duplicate appears, jump left to:
left = max(left, lastSeen[ch] + 1)

Time Complexity: O(n)
Space Complexity: O(min(n, charset)) ~ O(1) for ASCII
"""

from typing import Dict

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_seen: Dict[str, int] = {}
        left = 0
        best = 0

        for right, ch in enumerate(s):
            if ch in last_seen:
                left = max(left, last_seen[ch] + 1)

            last_seen[ch] = right
            best = max(best, right - left + 1)

        return best
