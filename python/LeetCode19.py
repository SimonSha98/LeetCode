class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        ans = ListNode(0, head)
        first = head
        prev = ans
        count = 0
        while(first != None):
            count += 1
            first = first.next
        count = count - n + 1
        first = head
        while(first != None):
            count -= 1
            if(count == 0):
                prev.next = first.next
                break
            prev = first
            first = first.next
        return ans.next
