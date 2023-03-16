import java.util.*;

public class ViewOfTree {
    public void bottomView(Node root) {
    }
    public  void rightView1(Node root, ArrayList<Integer> list){
        if(root == null){return;}
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                Node current = q.peek();
                q.remove();
                /*
                same as Node temp =  q.poll();
                 */
                if(i==n-1){
                    list.add(current.data);
//                    System.out.print(current.data + " ");
                }
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
        }
    }
    public void rightView(Node root){
        maxLevel = 0;
        rightViewUtil(root, 1);
    }
    private void rightViewUtil(Node root, int level){
        if(root == null){
            return;
        }
        if(maxLevel < level){
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        rightViewUtil(root.right, level+1);
        rightViewUtil(root.left, level+1);
    }
    public void printLeftView(Node root){
        if(root == null){return;}
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=1;i<=n;i++){
                Node temp = q.poll();
                if(i==1){
                    System.out.print(temp.data + " ");
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
    }
    public void leftView(Node root) {
        maxLevel = 0;
        leftViewUtil(root, 1);
    }
    private int maxLevel = 0;
    private void leftViewUtil(Node root, int level){
        if(root == null){
            return;
        }
        if(maxLevel < level){
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        leftViewUtil(root.left, level+1);
        leftViewUtil(root.right, level+1);
    }
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
}
