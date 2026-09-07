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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            iMap.put(inorder[i], i);
        }
        return helperMethod(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1, iMap);
    }

    public TreeNode helperMethod(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> iMap) {
        // preorder 0th is the root
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode result = new TreeNode(preorder[pStart]);
        int iRoot = iMap.get(preorder[pStart]);
        int numsLeft = iRoot - iStart;

        //left
        result.left = helperMethod(preorder, pStart+1, pStart + numsLeft, inorder, iStart, iRoot-1, iMap);
        //right
        result.right = helperMethod(preorder, pStart + numsLeft+1, pEnd, inorder, iRoot+1, iEnd, iMap);

        return result;
    }
}
