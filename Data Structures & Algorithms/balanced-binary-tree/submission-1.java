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
    public boolean isBalanced(TreeNode root) {
        boolean[] b = new boolean[1];
        b[0] = true;
        findHeight(root, b);
        return b[0];
    }

    public int findHeight(TreeNode root, boolean[] isBalanced) {
        if (root==null) {
            return 0;
        }

        int leftHeight = findHeight(root.left, isBalanced);
        int rightHeight = findHeight(root.right, isBalanced);

        if((Math.abs(leftHeight-rightHeight)>1)) {
            isBalanced[0] = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
