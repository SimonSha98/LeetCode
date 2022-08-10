class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        dic = {}
        while head != None:
            if dic.get(head) == None:
                dic[head] = True
            else:
                return True
            head = head.next
        
        return False
