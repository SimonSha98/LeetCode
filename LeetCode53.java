class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int cur = -100000;
        int max = -100000;
        for(int i = 0; i < nums.length; i ++){
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
    public static void main(String[] args){
        // tests
        LeetCode53 test = new LeetCode53();
        System.out.println(test.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
