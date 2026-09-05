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
        List<Integer> list = new ArrayList<>();
        traverseTree(root, list);
        if (k<=list.size()) {
            return list.get(k-1);
        }
        return -1;
    }

    public TreeNode traverseTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return root;
        }

        traverseTree(root.left, list);
        list.add(root.val);
        traverseTree(root.right, list);

        return root;
    }
}
