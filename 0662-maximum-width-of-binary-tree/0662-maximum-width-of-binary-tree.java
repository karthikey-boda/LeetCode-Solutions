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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int width=0;
        Queue<TreeNode> node=new LinkedList<>();
        Queue<Integer> index=new LinkedList<>();
        node.offer(root);
        index.offer(0);
        while(node.size()!=0){
            int size=node.size();
            int minIndex=index.peek();
            int first=0,last=0;
            for(int i=0;i<size;i++){
                TreeNode curr=node.poll();
                int currIndex=index.poll()-minIndex;
                if(i==0){
                    first=currIndex;
                }
                if(i==size-1){
                    last=currIndex;
                }
                if(curr.left!=null){
                    node.offer(curr.left);
                    index.offer(2*currIndex+1);
                }
                if(curr.right!=null){
                    node.offer(curr.right);
                    index.offer(2*currIndex+2);
                }
            }
            width=Math.max(width,last-first+1);
        } 
        return width;
    }
}