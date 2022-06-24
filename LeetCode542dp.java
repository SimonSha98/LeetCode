class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] ans = new int[r][c];
        int Max = 100000;
        //boolean[][] visited = new boolean[r][c];
        //Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                if(mat[i][j] == 1)
                    ans[i][j] = Max;
            }
        }
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                if(mat[i][j] == 1){
                    ans[i][j] = Math.min(ans[i][j], i-1 >= 0? ans[i-1][j]+1:Max);
                    ans[i][j] = Math.min(ans[i][j], j-1 >= 0? ans[i][j-1]+1:Max);
                }
            }
        }
        for(int i = r-1; i >= 0; i --){
            for(int j = c-1; j >= 0; j --){
                if(mat[i][j] == 1){
                    ans[i][j] = Math.min(ans[i][j], i+1 < r? ans[i+1][j]+1:Max);
                    ans[i][j] = Math.min(ans[i][j], j+1 < c? ans[i][j+1]+1:Max);
                }
            }
        }
        return ans;
    }
}
