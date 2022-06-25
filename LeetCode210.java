class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Kahn's algorithm
        int[] indeg = new int[numCourses];
        boolean[] v = new boolean[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();
        int[] res = new int[numCourses];
        int numv = 0;
        for(int i = 0; i < prerequisites.length; i ++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            indeg[to] ++;
            v[to] = true;
            v[from] = true;
            if(map.containsKey(from))
                map.get(from).add(to);
            else
                map.put(from, new ArrayList(Arrays.asList(to)));
            if(!map.containsKey(to))
                map.put(to, new ArrayList());
        }
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i ++){
            if(indeg[i] == 0 && v[i])
               queue.add(i);
        }
        int index = 0;
        while(!queue.isEmpty()){
            int p = queue.remove();
            res[index++] = p;
            for(int j : map.get(p)){
                indeg[j] --;
                if(indeg[j] == 0)
                    queue.add(j);
            }
        }
        if(index != map.size())
            return new int[]{};
        for(int i = 0; i < numCourses; i ++){
            if(!v[i])
                res[index++] = i;
        }
        return res;
    }
}
