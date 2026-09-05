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
        return traverseNode(root, 0, Integer.MIN_VALUE);
    }

    public int traverseNode(TreeNode root, int ans, int currentMax) {
        if (root == null) {
            return 0;
        }

        int currentAnswer = 0;
        if (root.val>=currentMax) {
            currentMax = root.val;
            currentAnswer = 1;
        }

        System.out.println(root.val);

        int left = traverseNode(root.left, ans, currentMax);
        int right = traverseNode(root.right, ans, currentMax);

        return left+right+currentAnswer;
    }
}
