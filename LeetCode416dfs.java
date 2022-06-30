class Solution {
    private Boolean[][] dp;
    private int sum;
    private int[] nums;
    public boolean canPartition(int[] nums) {
        sum = 0;
        this.nums = nums;
        for(int i = 0; i < nums.length; i ++)
            sum += nums[i];
        if(sum % 2 == 1)
            return false;
        sum /= 2;
        dp = new Boolean[nums.length][sum + 1];
        for(int i = 0; i < nums.length; i ++){
            dp[i][0] = true;
        }
        find(nums.length-1, sum);
        return dp[nums.length-1][sum];
    }
    private boolean find(int k, int n){
        if(dp[k][n] != null)
            return dp[k][n];
        if(k == 0){
            dp[k][n] = n == nums[0];
        }
        else if(nums[k] <= n){
            dp[k][n] = find(k-1, n - nums[k]) || find(k-1, n);
        } else
            dp[k][n] = find(k-1, n);
        return dp[k][n];
    }
}
