class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(ListNode i : lists){
            ans = merge(ans, i);
        }
        return ans;
    }
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode res = new ListNode();
        ListNode cur = res;
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        while(node1 != null && node2 != null){
            if(node1.val > node2.val){
                cur.next = node2;
                node2 = node2.next;
            }
            else {
                cur.next = node1;
                node1 = node1.next;
            }
            cur = cur.next;
        }
        if(node1 == null)
            cur.next = node2;
        else
            cur.next = node1;

        return res.next;
    }
}
