class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        int maxl = -1;
        String ans = "";
        for(int i = 0; i < l; i ++){
            for(int j = 0; j < l - i; j ++){
                if(i == 0)
                    dp[j][j+i] = true;
                else if(i == 1)
                    dp[j][j+i] = s.charAt(j) == s.charAt(j+i);
                else
                    dp[j][j+i] = s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1];
                if(dp[j][j+i] && i > maxl){
                    maxl = i;
                    ans = s.substring(j, j+i+1);
                }
            }
        }
        return ans;

    }
}
