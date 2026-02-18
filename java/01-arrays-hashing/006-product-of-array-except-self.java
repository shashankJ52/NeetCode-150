/*
 * NeetCode 150 - Problem 6: Product of Array Except Self
 *
 * Approach:
 * Use prefix and postfix multiplication.
 * First pass computes prefix products and stores them in result array.
 * Second pass multiplies postfix products into the result array.
 * This avoids division and uses constant extra space.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding output array)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}
