"""
NeetCode 150 - Problem 1: Two Sum

Approach:
Use a dictionary to store numbers encountered so far along with their indices.
While iterating through the list, compute the complement (target - current number).
If the complement already exists in the dictionary, return the indices of the two numbers.
This allows solving the problem efficiently in a single pass.

Time Complexity: O(n)
Space Complexity: O(n)
"""


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in seen:
                return [seen[complement], i]

            seen[num] = i
