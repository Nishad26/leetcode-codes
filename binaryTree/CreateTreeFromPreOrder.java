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
    int height;
    int dai;

    TreeInfo(int height, int dai) {
        this.height = height;
        this.dai = dai;
    }
}

public class CreateTreeFromPreOrder {

    static int i = -1;

    public static void main(String[] args) {
        System.out.println("Hello World");
        int arr[] = { -10, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Node root = createTree(arr);
        System.out.println(root.data);
        System.out.println(root.left.data);
    }

    public static TreeInfo daimeterOfTreeAnother(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = daimeterOfTreeAnother(root.left);
        TreeInfo right = daimeterOfTreeAnother(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int dai1 = left.dai;
        int dai2 = right.dai;
        int dai3 = left.height + right.height + 1;

        int myDai = Math.max(Math.max(dai1, dai2), dai3);

        return new TreeInfo(myHeight, myDai);
    }

    public static int daimeterOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDai = daimeterOfTree(root.left);
        int rightDai = daimeterOfTree(root.right);
        int withRootDai = 1 + heightOfTree(root.left) + heightOfTree(root.right);

        return Collections.max(List.of(leftDai, rightDai, withRootDai));

    }

    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int height = 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
        return height;
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 1 + countOfNodes(root.left) + countOfNodes(root.right);
        return count;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
        return sum;
    }

    public static void levelOrder(Node root) {

        ArrayList<Node> queue = new ArrayList<Node>();

        queue.add(root);
        System.out.println("This is level order transversal");
        while (!queue.isEmpty()) {
            System.out.println(queue.get(0).data);
            if (queue.get(0).left != null) {
                queue.add(queue.get(0).left);
            }
            if (queue.get(0).right != null) {
                queue.add(queue.get(0).right);
            }
            queue.remove(0);
        }

    }

    public static void preOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.println(rootNode.data);
        preOrder(rootNode.left);
        preOrder(rootNode.right);
    }

    public static void inOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        inOrder(rootNode.left);
        System.out.println(rootNode.data);
        inOrder(rootNode.right);
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
