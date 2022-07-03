class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        int[] dict = new int[128];
        for(int i = 0; i < t.length(); i++)
            dict[t.charAt(i)] ++;
        int l = 0, r = 0, i = 0, j = 0;
        int missing = t.length();
        while(r < s.length()){
            if(dict[s.charAt(r)] > 0)
                missing --;
            dict[s.charAt(r)]--;
            r ++;
            while(missing == 0){
                if(j == 0 || (r - l) < (j - i)){
                    j = r;
                    i = l;
                }
                dict[s.charAt(l)]++;
                if(dict[s.charAt(l)] > 0)
                    missing++;
                l++;
            }
        }
        return s.substring(i, j);
    }
}
