class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        count = 0
        ans = ListNode(0, head)
        first = None
        second = None
        prev = ans
        while(head != None):
            count += 1
            if count % 2 == 1:
                first = head
                head = head.next
            else:
                second = head
                head = head.next
                second.next = first
                first.next = head
                prev.next = second
                prev = first
        return ans.next
