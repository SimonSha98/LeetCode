class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 1; i <= amount; i ++){
            dp[i] = 100000;
        }
        for(int i = 1; i <= amount; i ++){
            for(int j = 0; j < coins.length; j ++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == 100000 ? -1 : dp[amount];
    }
}
