class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        negpos = -1
        pospos = 0
        for i in range(len(nums)):
            if nums[i] < 0 and (i+1 == len(nums) or nums[i+1] >= 0):
                negpos = i
                pospos = i + 1
        curpos = 0
        ans = []
        while negpos >= 0 and pospos < len(nums):
            if abs(nums[negpos]) < nums[pospos]:
                ans.append(nums[negpos] ** 2)
                negpos -= 1
            else:
                ans.append(nums[pospos] ** 2)
                pospos += 1

        while negpos >= 0:
            ans.append(nums[negpos] ** 2)
            negpos -= 1
        while pospos < len(nums):
            ans.append(nums[pospos] ** 2)
            pospos += 1

        return ans
