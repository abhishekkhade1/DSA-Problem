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
    class Answer{
        boolean res  = true;
    }
    public boolean isBalanced(TreeNode root) {
        Answer ans = new Answer();
        dfsHeight(root,ans);
        return ans.res;
    }
    private int dfsHeight(TreeNode node, Answer ans){
        // if(node == null) return 0;

        // int leftHeight = dfsHeight(node.left);
        // if(leftHeight == -1) return -1;

        // int rightHeight = dfsHeight(node.right);
        // if(rightHeight == -1) return -1;

        // if(Math.abs(leftHeight - rightHeight) > 1){
        //     return -1;
        // }

        if(!ans.res) return 0;
        if(node == null) return -1;

        int l_height = dfsHeight(node.left,ans);
        int r_height = dfsHeight(node.right, ans);

        if(Math.abs(l_height - r_height)> 1) ans.res = false;
        

        return 1 + Math.max(l_height, r_height);
    }
}