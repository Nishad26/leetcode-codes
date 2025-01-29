package binaryTree;

import java.util.*;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node(int data) {
        this.data = data;
    }
}

class TreeInfo {
    int leftRightMax;
    int max;

    TreeInfo(int leftRightMax, int max) {
        this.leftRightMax = leftRightMax;
        this.max = max;
    }
}

public class MaximumPathSum {
    static int i = -1;

    public static void main(String[] args) {
        System.out.println("Hello World");
        int arr[] = { -20, -10, -20, -1, -1, -30, -1, -1, 1, 2, -1, -1, -3, -1, -1 };
        Node root = createTree(arr);
        System.out.println(root.data);
        System.out.println(root.left.data);

        System.out.println(maxSumPath(root).max);

    }

    public static TreeInfo maxSumPath(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftInfo = maxSumPath(root.left);
        TreeInfo rightInfo = maxSumPath(root.right);

        int left = leftInfo.leftRightMax + root.data;
        int right = rightInfo.leftRightMax + root.data;
        int dai = leftInfo.leftRightMax + rightInfo.leftRightMax + root.data;

        int leftRightMax = Math.max(left, right);
        int max = Math.max(dai, leftRightMax);
        max = Math.max(max, Math.max(leftInfo.max, rightInfo.max));

        return new TreeInfo(leftRightMax, max);

    }

    public static Node createTree(int arr[]) {
        i++;
        if (arr[i] == -1) {
            return null;
        }
        Node tempNode = new Node(arr[i]);
        tempNode.left = createTree(arr);
        tempNode.right = createTree(arr);

        return tempNode;
    }

}