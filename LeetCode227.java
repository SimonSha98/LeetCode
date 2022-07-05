class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        char sign = '+';
        int num = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num *= 10;
                num += c - '0';
            }
            if((c != ' ' && (c < '0' || c > '9')) || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(num);
                    sign = c;
                    num = 0;
                }
                else if(sign == '-'){
                    stack.push(-num);
                    sign = c;
                    num = 0;
                }
                else if(sign == '*'){
                    stack.push(stack.pop()*num);
                    sign = c;
                    num = 0;
                }
                else if(sign == '/'){
                    stack.push(stack.pop()/num);
                    sign = c;
                    num = 0;
                }
            }
        }
        while(!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}
