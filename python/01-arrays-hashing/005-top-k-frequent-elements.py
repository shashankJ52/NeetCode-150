"""
NeetCode 150 - Problem 5: Top K Frequent Elements

Approach:
1. Use a dictionary to count the frequency of each number.
2. Create a bucket list where index represents frequency.
   Each bucket stores numbers that appear that many times.
3. Traverse the bucket list from highest frequency to lowest
   and collect the top k frequent elements.

Time Complexity: O(n)
Space Complexity: O(n)
"""

from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Step 1: Frequency map
        count = {}
        freq = [[] for _ in range(len(nums) + 1)]

        for n in nums:
            count[n] = 1 + count.get(n, 0)

        # Step 2: Bucket placement
        for n, c in count.items():
            freq[c].append(n)

        # Step 3: Collect top k elements
        res = []
        for i in range(len(freq) - 1, 0, -1):
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    return res

        return res
