import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBinary {
    public static void main(String[] args) {
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
        view.inOrder(tree.root);
        System.out.println();
        DeletionInBinary del = new DeletionInBinary();
        del.delete(tree.root, 6);
        view.inOrder(tree.root);

    }
    void delete(Node root, int key){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right==null){
            if(root.data == key){
                root = null;
                return;
            }else{
                return;
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null, keyNode = null;
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.data == key){
                keyNode = temp;
            }
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        if(keyNode != null){
            int x = temp.data;
            deleteDeepest(root, temp);
            keyNode.data = x;
        }
    }
    void deleteDeepest(Node root, Node delNode){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp == delNode){
                temp = null;
                return;
            }
            if(temp.right != null){
                if(temp.right == delNode){
                    temp.right = null;
                    return;
                }else{
                    q.add(temp.right);
                }
            }
            if(temp.left != null){
                if(temp.left == delNode){
                    temp.left = null;
                    return ;
                }else{
                    q.add(temp.left);
                }
            }
        }
    }
}
