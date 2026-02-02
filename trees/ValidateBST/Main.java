class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validate(Node root, long min, long max) {

        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return validate(root.left, min, root.data) &&
               validate(root.right, root.data, max);
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(20);

        System.out.println("Is valid BST? " + isValidBST(root));
    }
}
