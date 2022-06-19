import java.util.Random;
class LeetCode384 {
    private int[] array;
    private int[] original;
    private Random rand = new Random();
    public LeetCode384(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for(int i = 0; i < array.length; i ++){
            int mid = array[i];
            int j = rand.nextInt(array.length - i) + i;
            array[i] = array[j];
            array[j] = mid;
        }
        return array;
    }

    public static void main(String[] args){
        // tests
        LeetCode384 test = new LeetCode384(new int[]{1,2,3});
        for(int i : test.shuffle())
            System.out.println(i);

        LeetCode384 test2 = new LeetCode384(new int[]{1,2,3,4,5,6,7,8,9,10});
        for(int i : test2.shuffle())
            System.out.println(i);
    }
}
