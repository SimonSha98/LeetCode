class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        dic = {};
        for s in strs:
            si = ''.join(sorted(s))
            if si in dic:
                dic[si].append(s);
            else:
                dic[si] = [s]
        return dic.values()

test = Solution()
print(test.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
