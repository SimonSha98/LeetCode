class Solution {
    private List<List<Integer>> ans;
    private List<Integer> cur;
    private int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.cur = new LinkedList();
        this.ans = new LinkedList();
        this.target = target;
        find(candidates, 0, 0);
        return ans;
    }
    private void find(int[] candidates, int sum, int n){
        if(sum == target){
            ans.add(new LinkedList(cur));
            return;
        }
        for(int i = n; i < candidates.length; i ++){
            if(sum + candidates[i] <= target){
                cur.add(candidates[i]);
                find(candidates, sum + candidates[i], i);
                cur.remove(cur.size()-1);
            }
        }
    }
}
