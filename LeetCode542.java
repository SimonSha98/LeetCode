class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] ans = new int[r][c];
        //boolean[][] visited = new boolean[r][c];
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                if(mat[i][j] == 0)
                    queue.add(new int[]{i, j});
                else
                    ans[i][j] = 100000;
            }
        }
        while(!queue.isEmpty()){
            int[] pos = queue.remove();
            int i = pos[0];
            int j = pos[1];
            if(i-1 >= 0 && mat[i-1][j] == 1 && ans[i-1][j] > ans[i][j] + 1){
                ans[i-1][j] = ans[i][j] + 1;
                queue.add(new int[]{i-1, j});
            }
            if(i+1 < r && mat[i+1][j] == 1 && ans[i+1][j] > ans[i][j] + 1){
                ans[i+1][j] = ans[i][j] + 1;
                queue.add(new int[]{i+1, j});
            }
            if(j-1 >= 0 && mat[i][j-1] == 1 && ans[i][j-1] > ans[i][j] + 1){
                ans[i][j-1] = ans[i][j] + 1;
                queue.add(new int[]{i, j-1});
            }
            if(j+1 < c && mat[i][j+1] == 1 && ans[i][j+1] > ans[i][j] + 1){
                ans[i][j+1] = ans[i][j] + 1;
                queue.add(new int[]{i, j+1});
            }
        }
        return ans;
    }
}
