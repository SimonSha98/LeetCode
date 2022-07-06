class Solution {
    public boolean backspaceCompare(String s, String t) {
        int indexs = s.length()-1, indext = t.length()-1;
        int skips = 0, skipt = 0;
        while(indexs >= 0 || indext >= 0){
            while(indexs >= 0){
                if(s.charAt(indexs) == '#'){
                    skips ++;
                    indexs --;
                }
                else if (skips > 0){
                    skips --;
                    indexs --;
                }
                else
                    break;
            }
            while(indext >= 0){
                if(t.charAt(indext) == '#'){
                    skipt ++;
                    indext --;
                }
                else if (skipt > 0){
                    skipt --;
                    indext --;
                }
                else
                    break;
            }
            if(indexs >= 0 != indext >= 0)
                return false;
            if(indexs < 0 && indext < 0)
                break;
            if(s.charAt(indexs) != t.charAt(indext))
                return false;
            indexs --;
            indext --;
        }
        return true;
    }
}
