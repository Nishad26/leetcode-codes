package binaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        if (isBalancedOrNot(root) == -1) {
            return false;
        }
        return true;
    }

    public int isBalancedOrNot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightLeft = isBalancedOrNot(root.left);
        int heightRight = isBalancedOrNot(root.right);

        if (heightRight == -1 || heightLeft == -1) {
            return -1;
        }
        if (Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        }
        int height = 1 + Math.max(heightLeft, heightRight);
        return height;
    }
}
