import java.util.Arrays;

public class MoveAllZeroToEnd {
    public static void main(String[] args) {
        int[] arr =  {1, 2, 0, 4, 3, 0, 5, 0};
        int[] arr1  = {1, 2, 0, 0, 0, 3, 6};
//        moveZeroRight(arr);
//        moveZeroRight(arr1);

        moveZeroLeft(arr);
        moveZeroLeft(arr1);

    }
    private static void moveZeroLeft(int[] arr){

    }
    private static void moveZeroRight(int[] arr){

    }
    public static int countSetBits(int n){

        // Your code here
        int sum = 0;
        for(int num=1;num<=n;num++){
            sum += countSets(num);
        }
        return sum;
    }
    private static int countSets(int n){
        int count = 0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

}
