class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dic = {}
        count = 0
        maxl = 0
        dic[0] = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                count -= 1
            else:
                count += 1
            if dic.get(count) == None:
                dic[count] = i
            else:
                maxl = max(maxl, i - dic[count])
        return maxl
