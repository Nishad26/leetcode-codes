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

public class SymmetricTree_101 {
	public boolean compare(TreeNode leftRoot, TreeNode rightRoot) {
		if (leftRoot != null && rightRoot == null) {
			return false;
		}
		if (leftRoot == null && rightRoot != null) {
			return false;
		}
		if (leftRoot == null && rightRoot == null) {
			return true;
		}
		if (leftRoot.val != rightRoot.val) {
			return false;
		}
		boolean leftTruth = true;
		boolean rightTruth = true;

		leftTruth = compare(leftRoot.left, rightRoot.right);
		rightTruth = compare(leftRoot.right, rightRoot.left);

		return leftRoot.val == rightRoot.val && leftTruth && rightTruth;

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null && root.right != null) {
			return compare(root.left, root.right);
		}
		return false;
	}
}
