/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        int result = 0;
        if (k<=l.size()) {
            return l.get(k-1);
        }
        return -1;
    }

    public TreeNode dfs(TreeNode root, List l) {
        if (root == null) return root;

        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right,l);

        return root;

    }
}
