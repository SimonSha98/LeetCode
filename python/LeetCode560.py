class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dic = {}
        cusum = 0
        count = 0
        dic[0] = 1
        for i in range(len(nums)):
            cusum += nums[i]
            if dic.get(cusum - k) != None:
                count += dic.get(cusum - k)
            dic[cusum] = (0 if dic.get(cusum) == None else dic.get(cusum)) + 1
        return count
            
