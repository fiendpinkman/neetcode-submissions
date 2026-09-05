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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverseNode(root, 0, res);
        return res;
    }

    public TreeNode traverseNode(TreeNode root, int level, List<Integer> res) {
        if (root==null) {
            return root;
        }
        
        if(res.size()==level) {
            res.add(root.val);
        }

        level = level + 1;

        traverseNode(root.right, level, res);
        traverseNode(root.left, level, res);

        return root;
    }
}
