"""
LeetCode #42 - Trapping Rain Water

Pattern:
Two Pointers + Greedy (Process smaller boundary)

Approach:
1. Use two pointers: left and right.
2. Maintain leftMax and rightMax.
3. Always process the side with smaller max boundary.
4. Add trapped water accordingly.

Time Complexity: O(n)
Space Complexity: O(1)
"""

from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0

        left = 0
        right = len(height) - 1

        leftMax = height[left]
        rightMax = height[right]

        water = 0

        while left < right:

            if leftMax < rightMax:
                left += 1
                leftMax = max(leftMax, height[left])
                water += leftMax - height[left]
            else:
                right -= 1
                rightMax = max(rightMax, height[right])
                water += rightMax - height[right]

        return water
