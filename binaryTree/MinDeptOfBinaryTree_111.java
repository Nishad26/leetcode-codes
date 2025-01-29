package binaryTree;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class MinDeptOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
       
        int leftHeight=minDepth(root.left);
        int rightHeight=minDepth(root.right);
        leftHeight = (leftHeight == 0) ? rightHeight : leftHeight;
        rightHeight = (rightHeight == 0) ? leftHeight : rightHeight;
        return 1+Math.min(leftHeight,rightHeight); 
    }
    public int minDepthAnother(TreeNode root) {
        if(root==null){
            return 0;
        }
       
        int leftHeight=minDepth(root.left);
        int rightHeight=minDepth(root.right);
        if(leftHeight!=0 && rightHeight!=0){
            return 1+Math.min(leftHeight,rightHeight); 
        }
        return 1+Math.max(leftHeight,rightHeight);
    }
}
