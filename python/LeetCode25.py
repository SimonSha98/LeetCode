# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        front = head
        count = 0
        while head != None and count < k:
            count += 1
            head = head.next
        reversed_head = None
        if count == k:
            reversed_head = self.reverse(front, k)
        else:
            return front
        front.next = self.reverseKGroup(head, k)
        return reversed_head
        
    def reverse(self, head, k):
        prev = None
        cur = head
        count = 0
        while cur != None and count < k:
            count += 1
            mid = cur.next
            cur.next = prev
            prev = cur
            cur = mid
        
        return prev
