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
    public int maxDepth(TreeNode root) {
        int leftMaxDepth = 1;
        int rightMaxDepth = 1;

        if (root == null) {
            return 0;
        }
        
        leftMaxDepth = leftMaxDepth + maxDepth(root.left);
        rightMaxDepth = rightMaxDepth + maxDepth(root.right);

        if (leftMaxDepth > rightMaxDepth) {
            return leftMaxDepth;
        } else {
            return rightMaxDepth;
        }
    }

}
