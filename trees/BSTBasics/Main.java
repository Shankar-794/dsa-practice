class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main{
    static Node insert(Node root, int val) {

        if (root == null)
            return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else if (val > root.data)
            root.right = insert(root.right, val);

        return root;
    }
    static boolean search(Node root, int key) {

        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
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

        int[] values = {8, 3, 10, 1, 6, 14};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        System.out.println("Search 6: " + search(root, 6));
        System.out.println("Search 7: " + search(root, 7));
    }
}


