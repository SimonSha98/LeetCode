class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode res = new ListNode();
        ListNode cur = res;
        while(!stack.empty()){
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return res.next;
    }
}
