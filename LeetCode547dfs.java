class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ct = 0;
        boolean[] city = new boolean[n];
        for(int i = 0; i < n; i ++){
            if(!city[i]){
                ct ++;
                dfs(isConnected, city, i);
            }
        }
        return ct;
    }
    void dfs(int[][] g, boolean[] city, int i){
        int n = g.length;
        city[i] = true;
        for(int k = 0; k < n; k ++){
            if(g[i][k] == 1 && !city[k]){
                dfs(g, city, k);
            }
        }
        return;
    }
}
