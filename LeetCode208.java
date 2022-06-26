class Trie {
    Node root;
    public Trie() {
        root = new Node('1');
    }

    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.next[c-'a'] == null)
                cur.next[c-'a'] = new Node(c);
            cur = cur.next[c-'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.next[c-'a'] == null)
                return false;
            cur = cur.next[c-'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if(cur.next[c-'a'] == null)
                return false;
            cur = cur.next[c-'a'];
        }
        return true;
    }
}
class Node {
    char c;
    boolean end;
    Node[] next;
    public Node(char c){
        this.c = c;
        end = false;
        next = new Node[26];
    }
}
