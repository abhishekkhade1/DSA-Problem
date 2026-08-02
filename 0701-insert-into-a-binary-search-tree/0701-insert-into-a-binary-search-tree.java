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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        
        if(root == null){
            root = newNode;
            return root;
        }

        if(root.val < val){
            if(root.right == null){
                root.right = newNode;
            }
            insertIntoBST(root.right, val);
        }
        else{
            if(root.val > val){
                if(root.left == null){
                    root.left = newNode;
                }
                insertIntoBST(root.left , val);
            }
        }
        return root;
    }
}