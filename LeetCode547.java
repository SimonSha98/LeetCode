class DSU { // union find with path compression and rank
    int[] rep;
    int[] rank;
    public DSU(int size){
        rep = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i ++){
            rep[i] = i;
        }
    }
    public int find(int x){
        if(x == rep[x])
            return x;
        return rep[x] = find(rep[x]);
    }
    public void merge(int a, int b){
        int repa = find(a);
        int repb = find(b);
        if(rank[repa] < rank[repb])
            rep[repa] = repb;
        else if(rank[repb] < rank[repa])
            rep[repb] = repa;
        else {
            rep[repa] = repb;
            rank[repb] ++;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        DSU union = new DSU(isConnected.length);
        for(int i = 0; i < isConnected.length; i ++){
            for(int j = i+1; j < isConnected[0].length; j ++){
                if(isConnected[i][j] == 1)
                    union.merge(i, j);
            }
        }
        int count = 0;
        for(int i = 0; i < isConnected.length; i ++)
            if(union.find(i) == i)
                count ++;
        return count;
    }
}
