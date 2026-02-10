/*
 * NeetCode 150 - Problem 2: Contains Duplicate
 *
 * Approach:
 * Use a HashSet to keep track of elements seen so far.
 * Iterate through the array and check if the current element already exists
 * in the set. If it does, a duplicate is found. Otherwise, add the element
 * to the set and continue.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
*/


import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Step 1: Create a Set to keep track of the distinct Elements
        Set<Integer> seen = new HashSet<>();

        // Step 2: loop through the nums Array and check if ele. is already seen before
        for(int num : nums){
            if(seen.contains(num)) return true; // Duplicate Found.

            seen.add(num);
        }

        // Step 3: Final Result, No duplicates in Array
        return false;
    }

}