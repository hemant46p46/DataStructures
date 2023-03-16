import java.util.LinkedList;
import java.util.Queue;


class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class Solutions {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);
        root.left.data = 35;
        root.right.data = 10;
        root.left.left.data = 2;
        root.left.right.data = 3;
        root.right.right.data = 2;
        root.right.left.data = 5;
        leftView(root);
    }

    public static void leftView(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=1;i<=n;i++){
                BinaryTreeNode<Integer> temp = null;

                temp = q.poll();
                if(i==1){
                    assert temp != null;
                    System.out.print(temp.data + " ");
                }
                assert temp != null;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
    }
}
