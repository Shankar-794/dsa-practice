class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    // Find minimum value in a BST
    static int minValue(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    static Node delete(Node root, int key) {

        if (root == null)
            return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        }
        else if (key > root.data) {
            root.right = delete(root.right, key);
        }
        else {
            // Case 1 & 2: node with 0 or 1 child
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            // Case 3: node with 2 children
            int successor = minValue(root.right);
            root.data = successor;
            root.right = delete(root.right, successor);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Before deletion: ");
        inorder(root);
        System.out.println();

        root = delete(root, 3);

        System.out.print("After deletion: ");
        inorder(root);
    }

    // reuse insert from previous lesson
    static Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else if (val > root.data)
            root.right = insert(root.right, val);

        return root;
    }
}
