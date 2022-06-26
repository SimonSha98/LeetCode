class Solution {
    private int count = 0;
    private char[][] grid;
    private boolean[][] visited;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count ++;
                    search(i, j);
                }
            }
        }
        return count;
    }
    private void search(int i, int j){
        visited[i][j] = true;
        if(i-1>=0 && grid[i-1][j] == '1' && !visited[i-1][j])
            search(i-1,j);
        if(i+1<grid.length && grid[i+1][j] == '1' && !visited[i+1][j])
            search(i+1,j);
        if(j-1>=0 && grid[i][j-1] == '1' && !visited[i][j-1])
            search(i,j-1);
        if(j+1<grid[0].length && grid[i][j+1] == '1' && !visited[i][j+1])
            search(i,j+1);
    }
}
