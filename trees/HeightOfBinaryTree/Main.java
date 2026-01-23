class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
    int heightOfBinaryTree(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
public class Main{
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        int height = root.heightOfBinaryTree(root);
        System.out.println("Height of tree: " +height);
    }
}