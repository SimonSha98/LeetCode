class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            String rep = find(s);
            if(!map.containsKey(rep)){
                map.put(rep, new ArrayList());
                map.get(rep).add(s);
            } else
                map.get(rep).add(s);
        }
        //
        //for(Map.Entry<String, List<String>> pair : map.entrySet()){
        //    ans.add(pair.getValue());
        //}

        return new ArrayList(map.values());
    }
    private String find(String s){
        String ans = "";
        int[] ct = new int[26];
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            ct[c - 'a'] ++;
        }
        for(int i = 0; i < 26; i ++){
            ans += ct[i] + '0';
            ans += '#';
        }
        return ans;
    }
}
