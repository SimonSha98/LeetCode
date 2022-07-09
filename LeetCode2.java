class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        int add = 0;
        while(l1 != null || l2 != null){
            int sum = add + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            add = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(add > 0)
            cur.next = new ListNode(add, null);
        return ans.next;
    }
}
