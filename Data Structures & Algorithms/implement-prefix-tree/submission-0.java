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
        return this.flag;
    }
}

class PrefixTree {

    private static Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char currentWord = word.charAt(i);
            if (!node.contains(currentWord)) {
                node.put(currentWord, new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setFlag(true);
    }

    public boolean search(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isFlag();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i=0; i<prefix.length(); i++) {
            if (!node.contains(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}
