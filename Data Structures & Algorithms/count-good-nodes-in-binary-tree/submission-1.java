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
    public int goodNodes(TreeNode root) {
        return traverseNode(root, Integer.MIN_VALUE);
    }

    public int traverseNode(TreeNode root, int currentMax) {
        if (root == null) {
            return 0;
        }

        int currentAnswer = 0;
        if (root.val>=currentMax) {
            currentMax = root.val;
            currentAnswer = 1;
        }

        int left = traverseNode(root.left, currentMax);
        int right = traverseNode(root.right, currentMax);

        return left+right+currentAnswer;
    }
}
