class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Map<Integer, Node> map = new HashMap();
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        map.put(node.val, new Node(node.val, new ArrayList()));
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            for(Node i : cur.neighbors){
                if(!map.containsKey(i.val)){
                    map.put(i.val, new Node(i.val, new ArrayList()));
                    queue.add(i);
                }
                map.get(cur.val).neighbors.add(map.get(i.val));
            }
        }
        return map.get(1);
    }
}
