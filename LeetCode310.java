class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] deg = new int[n];
        Map<Integer, Set<Integer>> graph = new HashMap();
        Queue<Integer> queue = new ArrayDeque();
        List<Integer> ans = new ArrayList();
        int remain = n;//remaining nodes not checked
        if(n == 1){
            ans.add(0);
            return ans;
        }
        for(int i = 0; i < edges.length; i ++){
            deg[edges[i][0]] ++;
            deg[edges[i][1]] ++;
            if(!graph.containsKey(edges[i][0]))
                graph.put(edges[i][0], new HashSet());
            if(!graph.containsKey(edges[i][1]))
                graph.put(edges[i][1], new HashSet());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < n; i ++){
            if(deg[i] == 1)
                queue.add(i);
        }
        while(remain > 2){// at most 2 roots possible for MHT
            int k = queue.size();
            for(int i = 0; i < k; i ++){
                int node = queue.remove();
                remain --;
                for(int to : graph.get(node)){
                    deg[to] --;
                    if(deg[to] == 1)
                        queue.add(to);
                }
            }
        }
        while(!queue.isEmpty())
            ans.add(queue.remove());
        return ans;
    }
}
