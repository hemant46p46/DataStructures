import java.util.ArrayList;
import java.util.Arrays;

public class Rotation {
    public static void main(String[] args) {
//        leftRotationOn(new int[] {2, 5, 7, 9, 10}, 3);
//        leftRotate(new int[] {2, 5, 7, 9, 10}, 3);
//        rightRotate();
        int[] a = {5, 1, 15, 20, 25};
        int i, j, k;
        i = ++a[1];
        System.out.println(i);
        j = a[1]++;
        k = a[i++];
        System.out.println((i) + " : " + (j) + " : " + k);
    }
    static void rightRotate(){
        int[] arr = {1, 2, 3, 4, 5};
        //5, 1, 2, 3, 4
        System.out.println(Arrays.toString(arr));
        int step = 2;
        ///*************************

        for(int j=0;j<2;j++){
            int n = arr.length;
            int temp = arr[n - 1];
            for (int i = n - 1; i >= 1; i--) {
                arr[i] = arr[i - 1];
            }
            // 1, 1, 2, 3, 4
            arr[0] = temp;
        }
        // 5, 1, 2, 3, 4
        //4, 5, 1, 2, 3
        System.out.println(Arrays.toString(arr));

    }

    private static void leftRotationOn(int[] arr, int k){
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> ar = new ArrayList<>();
        int mod = k%n;
        for(int i=0;i<n;i++){
            ar.add(arr[(mod+i)%n]);
        }
        System.out.println(ar);
    }
//*****************************************************************************
    private static void leftRotate(int[] arr, int k){
        if(k==0){return;}
        int n = arr.length;
        k = k%n;
       reverse(arr, 0, k-1);
       reverse(arr, k, n-1);
       reverse(arr, 0, n-1);
       System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int[] arr, int i, int j){
        int temp;
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
    //*****************************************************************************
}
