class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int num = 0;
        int sign = 1;
        int result = 0;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num *= 10;
                num += c-'0';
            }
            else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                result += sign * num;
                sign = stack.pop();
                num = stack.pop();
                result = result * sign + num;
                num = 0;
                sign = 1;
            }
        }
        return result + num * sign;
    }
}
