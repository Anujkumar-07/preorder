package PreOrder;

public class Preorder {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int idx = -1; // make it global to keep track during recursion
    public static Node buildTree(int[] nodes){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }
    public static void printingPreorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        printingPreorder(root.left);
        printingPreorder(root.right);

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        System.out.println(root.data); // prints 1
        printingPreorder(root);
        
    }
}
