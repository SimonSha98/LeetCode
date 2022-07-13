class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = -11
        curmax = 1
        curmin = 1
        for i in range(len(nums)):
            temp = max(nums[i], curmax * nums[i], curmin * nums[i])
            curmin = min(nums[i], curmax * nums[i], curmin * nums[i])
            curmax = temp
            ans = max(curmax, ans)

        return ans
