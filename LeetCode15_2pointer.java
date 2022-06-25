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
        int left = k+1;
        int right = nums.length - 1;
        while(left < right){
            int add = nums[left] + nums[right];
            if(add == target){
                res.add(Arrays.asList(-target, nums[left], nums[right]));
                while(left + 1 < nums.length && nums[left] == nums[left+1])
                    left ++;
                left ++;
                right --;
            } else{
                if(add > target)
                    right --;
                else
                    left ++;
            }
        }
    }
}
