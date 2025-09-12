package PreOrder;
import java.util.*;

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
    static int idx = -1;
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
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        
        return Math.max(lh,rh) + 1;

    }
    public static void printingPreorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        printingPreorder(root.left);
        printingPreorder(root.right);
    }
    public static void printingInorder(Node root){
        if(root == null){
            return;
        }
        printingInorder(root.left);
        System.out.print(root.data+" ");
        printingInorder(root.right);
    }
    public static void printingpostorder(Node root){
        if(root == null){
            return;
        }
        printingpostorder(root.left);
        printingpostorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void printingLeverorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int height_count  = 0;
        Node root = buildTree(nodes);
        System.out.println(root.data);
        printingPreorder(root);
        System.out.println();
        printingInorder(root);
        System.out.println();
        printingpostorder(root);
        System.out.println();
        printingLeverorder(root);
        heightOfTree(root);
        System.out.println(heightOfTree(root));
    }
}
