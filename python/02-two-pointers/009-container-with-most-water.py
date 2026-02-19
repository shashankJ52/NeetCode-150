"""
NeetCode 150 - Container With Most Water

Approach:
Use two pointers starting from both ends.
At each step, compute the area formed by the two lines:
area = (right - left) * min(height[left], height[right]).
Move the pointer at the smaller height inward,
since the smaller height limits the area.

Time Complexity: O(n)
Space Complexity: O(1)
"""

from typing import List

class Solution:
    def maxArea(self, heights: List[int]) -> int:
        
        left, right = 0, len(heights) - 1
        bestArea = 0

        while left < right:
            currArea = (right - left) * min(heights[left], heights[right])
            bestArea = max(bestArea, currArea)

            if heights[left] <= heights[right]:
                left += 1
            else:
                right -= 1

        return bestArea
