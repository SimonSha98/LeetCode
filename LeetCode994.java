class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                if(grid[i][j] == 1)
                    fresh ++;
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
            }
        }
        if(fresh == 0)
            return 0;
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0; i < l; i ++){
                int[] cor = queue.remove();
                int x = cor[0];
                int y = cor[1];
                if(x-1 >= 0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    fresh --;
                    queue.add(new int[]{x-1,y});
                }
                if(y-1 >= 0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    fresh --;
                    queue.add(new int[]{x,y-1});
                }
                if(x+1 < r && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    fresh --;
                    queue.add(new int[]{x+1,y});
                }
                if(y+1 < c && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    fresh --;
                    queue.add(new int[]{x,y+1});
                }
            }
            time ++;
        }
        if(fresh != 0)
            return -1;
        return time - 1;
    }
}
