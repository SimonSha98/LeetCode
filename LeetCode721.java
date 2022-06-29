class DSU {
    int rep[];
    int rank[];
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
        else if(rank[repa] > rank[repb])
            rep[repb] = repa;
        else{
            rank[repa] ++;
            rep[repb] = repa;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int l = accounts.size();
        DSU union = new DSU(l);
        Map<String, Integer> map = new HashMap();
        for(int i = 0; i < l; i ++){
            int k = accounts.get(i).size();
            List<String> account_i = accounts.get(i);
            String name = account_i.get(0);
            for(int j = 1; j < k; j ++){
                String email = account_i.get(j);
                if(!map.containsKey(email)){
                    map.put(email, i);
                } else {
                    union.merge(i, map.get(email));
                }
            }
        }
        Map<Integer, List<String>> res = new HashMap();
        for(String email : map.keySet()){
            int group = map.get(email);
            int rep = union.find(group);
            if(!res.containsKey(rep)){
                res.put(rep, new ArrayList());
            }
            res.get(rep).add(email);
        }
        List<List<String>> ans = new ArrayList();
        for(int group : res.keySet()){
            List<String> emails = res.get(group);
            Collections.sort(emails);
            emails.add(0, accounts.get(group).get(0));
            ans.add(emails);
        }
        return ans;
    }
}
