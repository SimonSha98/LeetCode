class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList);
        if(!set.contains(endWord))
            return 0;
        Queue<String> queue = new ArrayDeque();
        int step = 1;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0; i < l; i ++){
                String front = queue.remove();
                List<String> list = change(front);
                for(String s : list){
                    if(s.equals(endWord))
                        return step + 1;
                    if(set.contains(s)){
                        queue.add(s);
                        set.remove(s);
                    }
                }
            }
            step ++;
        }
        return 0;
    }
    private List<String> change(String word){
        char[] arr = word.toCharArray();
        List<String> ans = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            char arri = arr[i];
            for(char c = 'a'; c <= 'z'; c++){
                arr[i] = c;
                ans.add(String.valueOf(arr));
            }
            arr[i] = arri;
        }
        return ans;
    }
}
