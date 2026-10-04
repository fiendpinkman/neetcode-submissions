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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        List<List<Integer>> levels = new ArrayList<>();
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentQueueSize = q.size();
            for (int i=0; i<currentQueueSize; i++) {
                TreeNode currentNode = q.poll();
                if (currentNode != null) {
                    level.add(currentNode.val);
                    q.add(currentNode.left);
                    q.add(currentNode.right);
                }
            }
            if (level.size() != 0) levels.add(level);
        }

        return levels;
        
    }
}
