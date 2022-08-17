# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None or head.next == None:
            return head
        left, right = self.split(head)
        sortedLeft = self.sortList(left)
        sortedRight = self.sortList(right)
        ans = self.merge(sortedLeft, sortedRight)
        return ans

    def split(self, head):
        slow = head
        fast = head
        prev = head
        while fast != None and fast.next != None:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        prev.next = None
        return head, slow

    def merge(self, left, right):
        head = ListNode()
        cur = head
        while left != None and right != None:
            cur.next = left if left.val < right.val else right
            cur = cur.next
            if left.val < right.val:
                left = left.next
            else:
                right = right.next
        cur.next = left if left != None else right
        return head.next
