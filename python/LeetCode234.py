# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None:
            return True
        first_end = self.find_first_end(head)
        second_start = self.reverse(first_end.next)
        first = head
        second = second_start
        result = True
        while result and second != None:
            if(first.val != second.val):
                result = False
            first = first.next
            second = second.next

        first_end.next = self.reverse(second_start)

        return result

    def find_first_end(self, head):
        fast = head
        slow = head
        while fast.next != None and fast.next.next != None:
            fast = fast.next.next
            slow = slow.next
        return slow
    def reverse(self, head):
        prev = None
        cur = head
        while cur != None:
            node = cur.next
            cur.next = prev
            prev = cur
            cur = node
        return prev
