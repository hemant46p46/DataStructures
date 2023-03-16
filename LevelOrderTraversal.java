import java.util.ArrayList;
import java.util.*;

public class LevelOrderTraversal {

    public static ArrayList<Integer> reverseLevelOrder(Node root) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            s.add(temp);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }

        }
        while(!s.isEmpty()){
            Node node = s.peek();
            list.add(node.data);
            s.pop();
        }
        return list;
    }
}
