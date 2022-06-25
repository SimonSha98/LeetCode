class Solution {
    Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        map = new HashMap();
        map.put(node.val, new Node(node.val, new ArrayList()));
        find(node);
        return map.get(1);
    }
    private void find(Node node){
        for(Node i : node.neighbors){
            if(!map.containsKey(i.val)){
                map.put(i.val, new Node(i.val, new ArrayList()));
                find(i);
            }
            map.get(node.val).neighbors.add(map.get(i.val));
        }
    }
}
