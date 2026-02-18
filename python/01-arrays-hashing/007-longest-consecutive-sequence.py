"""
NeetCode 150 - Problem 7: Longest Consecutive Sequence

Approach:
Convert the list into a set for O(1) lookups.
Only start counting a sequence if the current number is the
start of a sequence (i.e., n - 1 is not in the set).
Expand forward to count consecutive numbers.

Time Complexity: O(n)
Space Complexity: O(n)
"""

from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        numSet = set(nums)
        longest = 0

        for n in numSet:
            # Only start counting if n is the beginning of a sequence
            if (n - 1) not in numSet:
                length = 1
                while (n + length) in numSet:
                    length += 1
                
                longest = max(longest, length)

        return longest
