class Solution {
    List<List<Integer>> ans;
    List<Integer> cur;
    public List<List<Integer>> permute(int[] nums) {
        ans = new LinkedList();
        //cur = new LinkedList();
        find(nums, 0);
        return ans;
    }
    private void find(int[] nums, int k){
        if(k == nums.length){
            cur = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i ++)
                cur.add(nums[i]);
            ans.add(cur);
            return;
        }
        for(int i = k; i < nums.length; i ++){
            int mid = nums[i];
            nums[i] = nums[k];
            nums[k] = mid;
            find(nums, k + 1);
            mid = nums[i];
            nums[i] = nums[k];
            nums[k] = mid;
        }
    }
}
