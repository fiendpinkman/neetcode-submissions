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
        Queue<Integer> q = new LinkedList<>();
        dfs(root, q);
        int result = 0;
        while (k!=0) {
            result = q.poll();
            k--;
        }
        return result;
    }

    public TreeNode dfs(TreeNode root, Queue q) {
        if (root == null) return root;

        dfs(root.left, q);
        q.add(root.val);
        dfs(root.right,q);

        return root;

    }
}
