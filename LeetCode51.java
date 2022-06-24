class Solution {
    private char[][] cur;
    private List<List<String>> ans;
    private boolean[][] visited;
    private int N;
    public List<List<String>> solveNQueens(int n) {
        cur = new char[n][n];
        ans = new ArrayList<List<String>>();
        visited = new boolean[n][n];
        this.N = n;
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                cur[i][j] = '.';

        find(0);
        return ans;
    }
    private void find(int row){
        if(row == N){
            List<String> s = new ArrayList();
            for(int i = 0; i < N; i ++){
                s.add(new String(cur[i]));
            }
            ans.add(s);
        }
        for(int col = 0; col < N; col ++){
            if(queen(row, col) && cur[row][col] == '.'){
                //visited[i][j] = true;
                cur[row][col] = 'Q';
                find(row + 1);
                //visited[i][j] = false;
                cur[row][col] = '.';
            }
        }
    }
    private boolean queen(int a, int b){
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                if(cur[i][j] == 'Q'){
                    if(i == a && j != b)
                        return false;
                    if(i != a && j == b)
                        return false;
                    if(i != a && j != b){
                        if(Math.abs(i - a) == Math.abs(j - b))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
