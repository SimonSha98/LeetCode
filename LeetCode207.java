class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        //boolean visited[] = new boolean[numCourses];
        boolean v[] = new boolean[numCourses];
        int numv = 0;
        int count = 0;
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int i = 0; i < prerequisites.length; i ++){
            v[prerequisites[i][0]] = true;
            v[prerequisites[i][1]] = true;
            indeg[prerequisites[i][0]] ++;
            if(!graph.containsKey(prerequisites[i][1]))
                graph.put(prerequisites[i][1], new ArrayList(Arrays.asList(prerequisites[i][0])));
            else
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            if(!graph.containsKey(prerequisites[i][0]))
                graph.put(prerequisites[i][0], new ArrayList());
        }
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i ++){
            if(indeg[i] == 0 && v[i])
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int q = queue.remove();
            count ++;
            for(int j : graph.get(q)){
                indeg[j] --;
                if(indeg[j] == 0)
                    queue.add(j);
            }
        }
        if(count == graph.size())
            return true;
        return false;
    }
}
