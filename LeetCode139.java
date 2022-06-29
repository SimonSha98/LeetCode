class Solution {
    Set<String> set;
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet();
        memo = new Boolean[s.length()];
        for(String word : wordDict){
            set.add(word);
        }
        return search(s, s.length()-1);

    }
    private boolean search(String s, int k){
        if(k < 0)
            return true;
        if(memo[k] != null)
            return memo[k];
        for(int i = 0; i <= k; i ++){
            if(set.contains(s.substring(i, k+1)) && search(s, i-1))
                return memo[k] = true;
        }
        return memo[k] = false;
    }
}
