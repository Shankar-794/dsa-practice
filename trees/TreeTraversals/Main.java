class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }

    void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    void inorder(Node root){
        if(root==null){
            return;
        }
        preorder(root.left);
        System.out.print(root.data+" ");
        preorder(root.right);
    }
    void postorder(Node root){
        if(root==null){
            return;
        }
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data+" ");
    }
}

public class Main{
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.print("Preorder: ");
        root.preorder(root);
        System.out.println();
        System.out.print("Inorder: ");
        root.inorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        root.postorder(root);
        System.out.println();
    }
}