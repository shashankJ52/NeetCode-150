/*
 * NeetCode 150 - Container With Most Water
 *
 * Approach:
 * Use two pointers (left and right). Compute area formed by the two lines:
 * area = (right - left) * min(height[left], height[right]).
 * Move the pointer at the smaller height inward, since the smaller height
 * limits the area; moving the taller pointer cannot increase the min height.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int best = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = (right - left) * h;
            best = Math.max(best, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return best;
    }
}
