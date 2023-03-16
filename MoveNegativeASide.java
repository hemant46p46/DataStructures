import java.util.Arrays;

public class MoveNegativeASide {
    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        System.out.println(Arrays.toString(arr));
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void rearrange(int[] arr){
        int j=0, temp, n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                if(i!=j){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }
}
