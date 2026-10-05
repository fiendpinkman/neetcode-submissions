class Node {
    Node[] links = new Node[26];
    boolean flag;
    int length = 0;

    public boolean contains(char c) {
        return links[c-'a'] != null;
    }

    public Node get(char c) {
        return links[c-'a'];
    }

    public void put(char c, Node node) {
        links[c-'a'] = node;
        length++;
    }

    public void setFlag(boolean flag) {
        this.flag = true;
    }

    public int getLength() {
        return length;
    }

    public boolean isFlag() {
        return flag;
    }
}

class WordDictionary {

    private static Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setFlag(true);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int start, Node root) {
        Node node = root;
        for (int i=start; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                if (node.length == 0) {
                    return false;
                } else {
                    for(Node child: node.links) {
                        if (child != null && dfs(word, i+1, child)) {
                            return true;
                        }
                    }
                    return false;
                }
            } else {
                if (node.contains(c)) {
                    node = node.get(c);
                } else {
                    return false;
                }
            }
        }
        return node.isFlag();
    }
}
