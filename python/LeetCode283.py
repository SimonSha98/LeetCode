class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        curpos = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[curpos] = nums[i]
                curpos += 1
        for i in range(curpos, len(nums)):
            nums[i] = 0
