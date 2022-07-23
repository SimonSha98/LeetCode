class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        count = 0
        odd_head = ListNode(0, None)
        even_head = ListNode(0, None)
        odd = odd_head
        even = even_head
        while head != None:
            count += 1
            if count % 2 == 1:
                odd.next = head
                odd = odd.next
            else:
                even.next = head
                even = even.next
            head = head.next
        odd.next = even_head.next
        even.next = None
        return odd_head.next
