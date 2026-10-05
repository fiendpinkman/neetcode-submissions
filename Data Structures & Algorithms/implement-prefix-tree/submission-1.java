class Node {
    Node[] links = new Node[26];
    boolean flag;

    public boolean contains(char c) {
        return links[c-'a'] != null;
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
            char c = word.charAt(i);
            if(!node.contains(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setFlag(true);
    }

    public boolean search(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (node.contains(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }

        return node.isFlag();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.contains(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
