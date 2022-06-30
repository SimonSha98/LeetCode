class Solution {
    public int myAtoi(String s) {
        List<Character> list = new ArrayList();
        Boolean plus = null;
        boolean num = false;
        int countsign = 0;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(digit(c)){
                list.add(c);
                num = true;
            } else {
                if(num){
                    break;
                } else{
                    if(c == ' ' && plus == null)
                        continue;
                    if(c == '+'){
                        if(countsign == 0){
                            countsign ++;
                            plus = true;
                        } else
                            break;
                    }
                    else if(c == '-'){
                        if(countsign == 0){
                            countsign ++;
                            plus = false;
                        } else
                            break;
                    }
                    else
                        break;
                }
            }
        }
        plus = plus == null? true : plus;
        boolean lead0 = true;
        int res = 0;
        for(char c : list){
            int i = c - '0';
            if(i == 0 && lead0)
                continue;
            if(i != 0)
                lead0 = false;
            if(plus){
                if(res < Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && i <= Integer.MAX_VALUE%10)){
                    res *= 10;
                    res += i;
                } else {
                    res = Integer.MAX_VALUE;
                    break;
                }
            } else {
                 if(res < Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && i <= Integer.MAX_VALUE%10)){
                    res *= 10;
                    res += i;
                } else {
                    res = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        if(!plus && res == Integer.MIN_VALUE)
            return res;
        return !plus? -res: res;
    }

    private boolean digit(char c){
        return c - '0' >= 0 && c - '0' <= 9;
    }
}
