class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int prod_except0 = 1;
        int count0 = 0;
        for(int i = 0; i < nums.length; i ++){
            prod *= nums[i];
            prod_except0 *= nums[i] == 0 ? 1 : nums[i];
            count0 += nums[i] == 0 ? 1 : 0;
        }
        for(int i = 0; i < nums.length; i ++){
            if(count0 > 1){
                nums[i] = 0;
            } else if(count0 == 1){
                nums[i] = nums[i] == 0 ? prod_except0 : 0;
            } else
                nums[i] = prod / nums[i];
        }
        return nums;
    }
}
