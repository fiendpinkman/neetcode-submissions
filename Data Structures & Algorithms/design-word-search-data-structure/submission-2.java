class Node {
    Node[] links = new Node[26];
    boolean flag;

    public boolean contains(char c) {
        return links[c-'a']!=null;
    }

    public void put(char c, Node node) {
        links[c-'a'] = node;
    }

    public Node get(char c) {
        return links[c-'a'];
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

}
class WordDictionary {

    public static Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i< word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.contains(currentChar)){
                node.put(currentChar,new Node());
            }
            node = node.get(currentChar);
        }
        node.setFlag(true);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    } 

    public boolean dfs(String word, int j, Node root) {
        Node cur = root;
        for (int i = j; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child:cur.links) {
                    if (child != null && dfs(word, i+1,child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(cur.contains(c)) {
                    cur = cur.get(c);
                } else {
                    return false;
                }
            }
        }
        return cur.isFlag();
    }
}
