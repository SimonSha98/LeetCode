class Solution {
    private Map<Integer, Integer> map;
    private List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        map = new HashMap<Integer, Integer>();
        res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < l; i ++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < l; i ++){
            if(nums[i] <= 0 && (i == 0 || nums[i] != nums[i-1]))
                find(nums, i, -nums[i]);
        }
        return res;
    }
    private void find(int[] nums, int k, int target){
        //Set<Integer> set = new HashSet();
        for(int i = k+1; i < nums.length; i ++){
            if(i != k+1 && nums[i] == nums[i-1])
                continue;
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) > k && map.get(target - nums[i]) > i){
                res.add(Arrays.asList(-target, nums[i], target - nums[i]));
                //set.add(nums[i]);
            }
        }
    }
}
