import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    BinaryTree(){
        root = null;
    }
    public static void main(String[] args) {
        /*
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);

        TraversalOfTree traversal = new TraversalOfTree();
        traversal.zigZagTraversal(tree.root);

        *********************************************************************
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        ViewOfTree view = new ViewOfTree();
        view.rightView(tree.root);
        ArrayList<Integer> rightViewList = new ArrayList<>();
        view.rightView1(tree.root, rightViewList);
        System.out.println(rightViewList);
        *********************************************************************
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(15);
        tree.root.right.left = new Node(12);
        tree.root.right.right.left = new Node(14);
        ViewOfTree view = new ViewOfTree();
        view.leftView(tree.root);
        System.out.println();
        view.printLeftView(tree.root);

        *********************************************************************
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder of original tree: ");
        inOrder(tree.root);
        Node mirror = makeMirror1(tree.root);
        System.out.print("\nInorder of mirror tree: ");
        inOrder(mirror);
        *********************************************************************
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : " + diameter(tree.root));
         *********************************************************************
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Level Order traversal of binary tree:");
//        printLevelOrder(tree.root);
        printLevelOrder1(tree.root);
        System.out.println();
        reverseLevelOrder(tree.root);
        *********************************************************************
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.left.right = new Node(12);
        root.left.right.left = new Node(9);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(11);

        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        postInPreOrders(root, post, pre, in);
        System.out.println("PreOrder ..." + pre);
        System.out.println("InOrder ..." + in);
        System.out.println("PostOrder ..." + post);
        *********************************************************************

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Level Order traversal of binary tree:");
        tree.printLevelOrder();
         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.right = new Node(7);
        System.out.println(LevelOrderTraversal.reverseLevelOrder(tree.root));
    }

    private static Node createNode(int val){
        return new Node(val);
    }
    private static Node makeMirror1(Node root){
        if (root == null)
            return null;
        Node left = makeMirror1(root.left);
        Node right = makeMirror1(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
    private static Node makeMirror(Node root){
        if(root==null){return null;}
        Node mirror = createNode(root.data);
        mirror.right = makeMirror(root.left);
        mirror.left = makeMirror(root.right);
        return mirror;
    }
    int diameterOpt(Node root, Height height) {
        Height lh = new Height(), rh = new Height();

        if (root == null) {
            height.h = 0;
            return 0; // diameter is also 0
        }
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }
    // A wrapper over diameter(Node root)
    int diameter() {
        Height height = new Height();
        return diameterOpt(root, height);
    }
    private static int diameter(Node root){
        if(root == null){return 0;}
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(leftHeight + rightHeight + 1 ,
                Math.max(leftDiameter, rightDiameter));
    }
    /*
           1
          / \
         2   3
        /\   /\
       4  5 6  7
     /   /    / \
    8   9    10  11
     \
      12
     */
    private static void reverseLevelOrder(Node root){
        int h = height(root);
        for(int i=h;i>=1;i--){
            printCurrentLevel(root,i);
        }
    }
    private static void printLevelOrder1(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
    }
    private static int height2(Node root){
        if(root == null){return 0;}
        return (1 + Math.max(height2(root.left), height2(root.right)));
    }
    private static int height1(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int height = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if (temp.right != null){
                    q.add(temp.right);
                }
            }
            height++;
        }
        return height;
    }
    private static int height(Node root){
        if(root == null){
            return 0;
        }else{
            int leftHeight = height(root.left);
            int rightHeight =height(root.right);
            if(leftHeight > rightHeight){
                return leftHeight+1;
            }else{
                return rightHeight+1;
            }
        }
    }
    private static int maxDepthOrHeight(Node root){
        if(root == null){return 0;}
        int leftDepth = maxDepthOrHeight(root.left);
        int rightDepth = maxDepthOrHeight(root.right);
        if(leftDepth > rightDepth){
            return (leftDepth + 1);
        }else{
            return (rightDepth + 1);
        }
    }
    private static void printLevelOrder(Node root){//bfs of tree
        int h = height(root);
        int i;
        for(i=1;i<=h;i++){
            printCurrentLevel(root, i);
        }
    }
    private static void printCurrentLevel(Node root, int level){
        if(root == null){return;}
        if(level==1){
            System.out.print(root.data + " ");
        }else if(level > 1){
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }
}