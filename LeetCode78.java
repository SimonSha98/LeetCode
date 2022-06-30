class Solution {
    private List<List<Integer>> ans;
    private List<Integer> cur;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        cur = new ArrayList();
        find(nums, 0);
        return ans;
    }
    private void find(int[] nums, int k){
        if(k == nums.length){
            ans.add(new ArrayList(cur));
            return;
        }
        for(int i = k; i < nums.length; i ++){
            cur.add(nums[i]);
            find(nums, i + 1);
            cur.remove(cur.size()-1);
        }
        ans.add(new ArrayList(cur));
    }
}
