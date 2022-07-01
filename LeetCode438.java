class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList();
        if(s.length() < p.length())
            return ans;
        int start = 0;
        int end = p.length() - 1;
        int[] dicp = new int[26];
        int[] dics = new int[26];
        for(int i = 0; i < p.length(); i ++){
            dicp[p.charAt(i)-'a'] ++;
            dics[s.charAt(i)-'a'] ++;
        }
        while(end < s.length()-1){
            if(Arrays.equals(dics, dicp))
                ans.add(start);
            dics[s.charAt(++end)-'a'] ++;
            dics[s.charAt(start++)-'a'] --;
        }
        if(Arrays.equals(dics, dicp))
            ans.add(start);
        return ans;
    }
}
