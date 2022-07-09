class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap();
        for(int i = 0; i < 9; i ++){
            map.put("c" + (char)(i+'0'), new HashSet<Character>());
            map.put("r" + (char)(i+'0'), new HashSet<Character>());
            map.put("" + (char)(i+'0'), new HashSet<Character>());
        }
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == '.')
                    continue;
                String r = "r" + (char)(i+'0');
                String c = "c" + (char)(j+'0');
                String b = box(i, j);
                if(map.get(r).contains(board[i][j]))
                    return false;
                if(map.get(c).contains(board[i][j]))
                    return false;
                if(map.get(b).contains(board[i][j]))
                    return false;
                map.get(r).add(board[i][j]);
                map.get(c).add(board[i][j]);
                map.get(b).add(board[i][j]);
            }
        }
        return true;
    }
    private String box(int i, int j){
        if(i >= 0 && i <= 2){
            if(j >= 0 && j <= 2)
                return "0";
            if(j >= 3 && j <= 5)
                return "1";
            else
                return "2";
        }
        else if(i >= 3 && i <= 5){
            if(j >= 0 && j <= 2)
                return "3";
            if(j >= 3 && j <= 5)
                return "4";
            else
                return "5";
        }
        else{
            if(j >= 0 && j <= 2)
                return "6";
            if(j >= 3 && j <= 5)
                return "7";
            else
                return "8";
        }
    }
}
