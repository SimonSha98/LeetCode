class LeetCode201 {
    public static void main(String[] args){
        // tests
        LeetCode201 test = new LeetCode201();
        System.out.println(test.rangeBitwiseAnd(1,2));
        System.out.println(test.rangeBitwiseAnd(5,7));
        System.out.println(test.rangeBitwiseAnd(1,2147483647));
    }
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right){
            left >>= 1;
            right >>= 1;
            shift ++;
        }
        left <<= shift;
        return left;
    }
}
