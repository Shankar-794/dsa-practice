class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LCAinBST {

    static Node lca(Node root, int p, int q) {

        if (root == null)
            return null;

        // Both nodes are smaller
        if (p < root.data && q < root.data)
            return lca(root.left, p, q);

        // Both nodes are greater
        if (p > root.data && q > root.data)
            return lca(root.right, p, q);

        // Split point
        return root;
    }

    public static void main(String[] args) {

        Node root = null;
        int[] values = {20, 8, 22, 4, 12, 10, 14};

        for (int val : values) {
            root = insert(root, val);
        }

        Node ans = lca(root, 10, 14);
        System.out.println("LCA: " + ans.data);
    }

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
