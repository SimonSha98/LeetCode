import java.util.*;
class LeetCode202 {
    public boolean isHappy(int n) {
        Set<Integer> num = new HashSet<Integer>();
        num.add(n);
        int sum = squaresum(n);
        if(sum == 1)
            return true;
        while(!num.contains(sum)){
            if(sum == 1)
                return true;
            num.add(sum);
            sum = squaresum(sum);
        }
        return false;
    }
    private int squaresum(int n) {
        int res = 0;
        while(n > 0){
            int k = n % 10;
            res += k * k;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args){
        // tests
        LeetCode202 test = new LeetCode202();
        System.out.println(test.isHappy(2));
        System.out.println(test.isHappy(19));
    }
}
