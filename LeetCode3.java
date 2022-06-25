class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] dic = new int[256];
        int left = 0;
        int maxs = 0;
        for(int right = 0; right < s.length(); right ++){
            char c = s.charAt(right);
            dic[c] ++;
            while(dic[c] > 1){
                char c2 = s.charAt(left);
                dic[c2] --;
                left ++;
            }
            maxs = Math.max(maxs, right - left + 1);
        }
        return maxs;
    }
}
