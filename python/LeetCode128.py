class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)
        longest = 0
        for item in s:
            if item - 1 not in s:
                curl = 1
                curitem = item
                while curitem + 1 in s:
                    curitem = curitem + 1
                    curl += 1
                longest = max(longest, curl)
        return longest
