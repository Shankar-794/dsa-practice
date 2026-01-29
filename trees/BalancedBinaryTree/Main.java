class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    // returns height if balanced, -1 if not balanced
    static int checkHeight(Node root) {

        if (root == null)
            return 0;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);

        System.out.println("Is balanced? " + isBalanced(root));
    }
}
