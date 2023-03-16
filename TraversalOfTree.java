import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraversalOfTree {
    public void zigZagTraversal1(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){return;}
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(q.size() > 0){
            int n=q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node current = q.poll();

            }
        }
    }
    public boolean isBalanced(Node root) {
        if(root == null){return true;}
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if((Math.abs(leftHeight-rightHeight)<=1) && (isBalanced(root.right)) && (isBalanced(root.left))){
            return true;
        }
        return false;
    }
    public int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public void zigZagTraversal(Node root){
        if(root == null){return;}
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currentLevel.push(root);
        boolean leftToRight = true;
        while(!currentLevel.isEmpty()){
            Node node = currentLevel.pop();
            System.out.print(node.data + " ");
            if(leftToRight){
                if(node.left != null){
                    nextLevel.push(node.left);
                }
                if(node.right!=null){
                    nextLevel.push(node.right);
                }
            }else{
                if(node.right!=null){
                    nextLevel.push(node.right);
                }
                if(node.left != null){
                    nextLevel.push(node.left);
                }
            }
            if(currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
    private static void postInPreOrders(Node root, ArrayList<Integer> post, ArrayList<Integer> pre, ArrayList<Integer> in){
        if(root!=null){
            pre.add(root.data);
            postInPreOrders(root.left, post, pre, in);
            in.add(root.data);
            postInPreOrders(root.right, post, pre, in);
            post.add(root.data);
        }
    }

    private static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    private static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    private static void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
