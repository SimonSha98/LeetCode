import java.util.*;
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        // hashset solution
        Set<ListNode> s = new HashSet<>();
        while(head != null){
            if(s.contains(head))
                return true;
            s.add(head);
            head = head.next;
        }
        return false;
    }
    public static void main(String[] args){
        // tests
        LeetCode141 test = new LeetCode141();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        next.next = head;
        System.out.println(test.hasCycle(head));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
}
