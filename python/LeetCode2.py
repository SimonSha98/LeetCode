class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        ans = ListNode()
        cur = ans
        prev = 0
        while l1 != None or l2 != None:
            cur.next = ListNode(((l1.val if l1 != None else 0) + (l2.val if l2 != None else 0) + prev) % 10)
            prev = ((l1.val if l1 != None else 0) + (l2.val if l2 != None else 0) + prev) // 10
            l1 = l1.next if l1 != None else None
            l2 = l2.next if l2 != None else None
            cur = cur.next

        if prev != 0:
            cur.next = ListNode(prev)

        return ans.next
