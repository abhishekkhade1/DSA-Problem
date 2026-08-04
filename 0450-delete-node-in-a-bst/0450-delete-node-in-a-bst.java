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
    public TreeNode deleteNode(TreeNode root, int key) {
        // this function delete the key node from given tree and return the updated root

        if(root == null) return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right , key);
        }
        else{
            // found key node to be delete
            // case 1:Both child nodes of key node are null
            if(root.right == null && root.left == null) return null;

            else{
                // case 3: Both child of key node are non-null
                if(root.right != null && root.left != null){
                    int inSuccesser = inorderSuccesser(root);
                    root.val = inSuccesser;
                    root.right = deleteNode(root.right , inSuccesser);
                }
                else{
                    // case 2:one child are non-null;
                    if(root.right!=null){
                        return root.right;
                    }
                    if(root.left!=null){
                        return root.left;
                    }
                }
            }
        }
        return root;
    }

    private int inorderSuccesser(TreeNode node) {
    TreeNode curr = node.right;

    while (curr.left != null) {
        curr = curr.left;
    }

    return curr.val;
}
}