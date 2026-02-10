# NeetCode 150 - Problem 2: Contains Duplicate
#  
#   Approach:
#   Use a HashSet to keep track of elements seen so far.
#   Iterate through the array and check if the current element already exists
#   in the set. If it does, a duplicate is found. Otherwise, add the element
#   to the set and continue.
#  
#   Time Complexity: O(n)
#   Space Complexity: O(n)


class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        
        tempSet = set()
        for num in nums:
            if num in tempSet:
                return True
            tempSet.add(num)
        return False
         

