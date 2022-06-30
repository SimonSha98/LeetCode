class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        char dir = 'r';
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> ans = new ArrayList();
        boolean[][] visited = new boolean[r][c];
        int i = 0, j = 0;
        int count = 0;
        visited[0][0] = true;
        while(count < r*c){
            ans.add(matrix[i][j]);
            count ++;
            if(dir == 'r'){
                if(j+1 < c && !visited[i][j+1]){
                    visited[i][j+1] = true;
                    j ++;
                } else {
                    dir = 'd';
                    if(i+1 < r)
                        visited[i+1][j] = true;
                    i ++;
                }
            }
            else if(dir == 'd'){
                if(i+1 < r && !visited[i+1][j]){
                    visited[i+1][j] = true;
                    i ++;
                } else {
                    dir = 'l';
                    if(j-1 >= 0)
                        visited[i][j-1] = true;
                    j --;
                }
            }
            else if(dir == 'l'){
                if(j-1 >= 0 && !visited[i][j-1]){
                    visited[i][j-1] = true;
                    j --;
                } else {
                    dir = 'u';
                    if(i-1 >= 0)
                        visited[i-1][j] = true;
                    i --;
                }
            }
            else if(dir == 'u'){
                if(i-1 >= 0 && !visited[i-1][j]){
                    visited[i-1][j] = true;
                    i --;
                } else {
                    dir = 'r';
                    if(j+1 < c)
                        visited[i][j+1] = true;
                    j ++;
                }
            }
        }
        return ans;
    }
}
