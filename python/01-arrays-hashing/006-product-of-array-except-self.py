"""
NeetCode 150 - Problem 6: Product of Array Except Self

Approach:
Use prefix and postfix multiplication.
First pass computes prefix products and stores them in result array.
Second pass multiplies postfix products into the result array.
Avoids division and uses constant extra space.

Time Complexity: O(n)
Space Complexity: O(1) (excluding output array)
"""

from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        res = [1] * len(nums)

        # Prefix pass
        prefix = 1
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]

        # Postfix pass
        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]

        return res
