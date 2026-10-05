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

    int preIndex = 0;
    Map<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int l, int r) {

        if (l>r) return null;

        TreeNode currentNode = new TreeNode(preorder[preIndex]);  
        int rootIndex = indices.get(preorder[preIndex]);
        preIndex++;
        currentNode.left = buildTree(preorder, l, rootIndex - 1);
        currentNode.right = buildTree(preorder, rootIndex + 1, r);

        return currentNode;
        
    }
}
