class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(){}

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class DlinkedList{ // tail is least recently used cache
    Node head;
    Node tail;

    public DlinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    public void inserthead(Node n){
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }
    public int removeTail(){
        int key = tail.prev.key;
        remove(tail.prev);
        return key;
    }
}
class LRUCache {
    Map<Integer, Node> cache;
    DlinkedList list;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        list = new DlinkedList();
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        Node n = cache.get(key);
        list.remove(n);
        list.inserthead(n);
        //cache.put(key, n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if(cache.containsKey(key)){
            list.remove(cache.get(key));
        }
        else if(cache.size() >= capacity){
            int k = list.removeTail();
            cache.remove(k);
        }
        list.inserthead(n);
        cache.put(key, n);
    }
}
