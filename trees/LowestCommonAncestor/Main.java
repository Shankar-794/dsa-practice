class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static Node lca(Node root, int p, int q) {

        if (root == null)
            return null;

        // If either p or q is found
        if (root.data == p || root.data == q)
            return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        // If p and q found in different subtrees
        if (left != null && right != null)
            return root;

        // Otherwise return non-null
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node ans = lca(root, 4, 5);
        System.out.println("LCA: " + ans.data);
    }
}
