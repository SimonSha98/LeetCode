class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stacknum = new Stack();
        for(int i = 0; i < tokens.length; i ++){
            String s = tokens[i];
            if(isNum(s))
                stacknum.add(number(tokens[i]));
            else {
                char c = s.charAt(0);
                if(c == '+'){
                    int b = stacknum.pop();
                    int a = stacknum.pop();
                    stacknum.push(a+b);
                }
                if(c == '-'){
                    int b = stacknum.pop();
                    int a = stacknum.pop();
                    stacknum.push(a-b);
                }
                if(c == '*'){
                    int b = stacknum.pop();
                    int a = stacknum.pop();
                    stacknum.push(a*b);
                }
                if(c == '/'){
                    int b = stacknum.pop();
                    int a = stacknum.pop();
                    stacknum.push(a/b);
                }
            }
        }
        return stacknum.pop();
    }
    private boolean isNum(String s){
        if(s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/'))
            return false;
        return true;
    }
    private int number(String s){
        int num = 0;
        int l = 0;
        boolean neg = false;
        if(s.charAt(0) == '-'){
            neg = true;
            l = 1;
        }
        while(l < s.length()){
            num *= 10;
            int x = s.charAt(l) - '0';
            num += x;
            l ++;
        }
        return neg ? -num : num;
    }
}
