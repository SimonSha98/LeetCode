class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i = nums.length - 1; i >= 1; i --){
            if(nums[i] > nums[i-1]){
                index = i - 1;
                break;
            }
        }
        for(int i = nums.length - 1; i > index; i --){
            if(index == -1)
                break;
            if(nums[i] > nums[index]){
                swap(nums, index, i);
                break;
            }
        }
        int l = index+1, r = nums.length-1;
        while(l <= r){
            swap(nums, l, r);
            l ++;
            r --;
        }
    }
    private void swap(int[] nums, int i, int j){
        int mid = nums[i];
        nums[i] = nums[j];
        nums[j] = mid;
    }
}
