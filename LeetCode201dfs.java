class Solution {
    private Stack<Integer> ans;
    private Map<Integer, List<Integer>> map;
    private boolean[] visited;
    private boolean[] v;
    private Set<Integer> path;
    private boolean cycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //DFS
        cycle = false;
        path = new HashSet();
        ans = new Stack();
        map = new HashMap();
        visited = new boolean[numCourses];
        v = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; i ++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            v[from] = true;
            v[to] = true;
            if(!map.containsKey(from))
                map.put(from, new ArrayList(Arrays.asList(to)));
            else
                map.get(from).add(to);
            if(!map.containsKey(to))
                map.put(to, new ArrayList());
        }
        for(int i = 0; i < numCourses; i ++){
            if(v[i] && !visited[i]){
                find(i);
            }
            if(!v[i])
                ans.push(i);
        }
        if(this.cycle)
            return new int[]{};
        int[] res = new int[numCourses];
        int index = 0;
        while(!ans.isEmpty())
            res[index++] = ans.pop();
        return res;

    }
    private void find(int i){
        if(path.contains(i)){
            this.cycle = true;
            return;
        }
        path.add(i);
        for(int j : map.get(i)){
            if(!visited[j]){
                find(j);
            }
        }
        visited[i] = true;
        path.remove(i);
        ans.push(i);
        return;
    }
}
