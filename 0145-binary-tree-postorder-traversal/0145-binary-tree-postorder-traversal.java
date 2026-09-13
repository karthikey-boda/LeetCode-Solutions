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

    public List<Integer> postorderTraversal(TreeNode root) {
        // traverse(root);
        // return list;
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        if(root==null){
            return list;
        }
        st1.push(root);
        while(st1.size()!=0){
            TreeNode curr=st1.pop();
            st2.push(curr);
            if(curr.left!=null){
                st1.push(curr.left);
            }
            if(curr.right!=null){
                st1.push(curr.right);
            }
        }
        while(st2.size()!=0){
            list.add(st2.pop().val);
        }
        return list;
    }
    // private void traverse(TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //     traverse(root.left);
    //     traverse(root.right);
    //     list.add(root.val);
    // }
    
}