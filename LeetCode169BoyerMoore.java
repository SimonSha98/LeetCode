class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int res = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            if(count == 0){
                res = nums[i];
                count ++;
            } else {
                if(res == nums[i])
                    count ++;
                else
                    count --;
            }
        }
        return res;
    }
}
