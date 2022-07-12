class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = {};
        for s in strs:
            si = ''.join(sorted(s))
            if si in dic:
                dic[si].append(s);
            else:
                dic[si] = [s]
        return dic.values()
