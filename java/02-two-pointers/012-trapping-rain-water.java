/*
 * LeetCode #42 - Trapping Rain Water
 *
 * Pattern:
 * Two Pointers + Greedy (Process Smaller Boundary)
 *
 * Approach:
 * 1. Use two pointers: left and right.
 * 2. Maintain leftMax and rightMax.
 * 3. Always process the side with the smaller max boundary.
 * 4. Update the boundary first, then calculate trapped water.
 *
 * Key Insight:
 * Water level at any index is determined by:
 * min(maxLeft, maxRight) - height[i]
 * We process the side with smaller max boundary because
 * that side limits the water level.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int water = 0;

        while (left < right) {

            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;
    }
}
