class ListNode:
    def __init__(self, val = 0, prev = None, next = None, key = None):
        self.val = val
        self.prev = prev
        self.next = next
        self.key = key
class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head = ListNode()
        self.tail = ListNode()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.length = 0
        self.cache = {}

    def get(self, key: int) -> int:
        if self.cache.get(key) == None:
            return -1
        else:
            node = self.cache.get(key)
            node.prev.next = node.next
            node.next.prev = node.prev
            node.next = self.head.next
            node.next.prev = node
            self.head.next = node
            node.prev = self.head
            return node.val

    def put(self, key: int, value: int) -> None:
        if self.length == self.capacity and self.cache.get(key) == None:
            node = self.tail.prev
            node.prev.next = self.tail
            self.tail.prev = node.prev
            self.cache.pop(node.key)
            self.length -= 1

        if self.cache.get(key) != None:
            node = self.cache.get(key)
            node.next.prev = node.prev
            node.prev.next = node.next
            node.prev = self.head
            node.next = self.head.next
            node.next.prev = node
            self.head.next = node
            node.val = value
        else:
            node = ListNode()
            node.val = value
            node.key = key
            node.prev = self.head
            node.next = self.head.next
            node.next.prev = node
            self.head.next = node
            self.cache[key] = node
            self.length += 1

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
