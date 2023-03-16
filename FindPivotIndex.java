import java.util.Arrays;

public class FindPivotIndex {
    public static void main(String[] args) {
        int count = 0;
        int n = 9;
        while(n>0){
            count+=(n&0);
            n = n>>1;
        }
        System.out.println(count);
//        int[] arr = {1, 7, 3, 6, 5, 6};
//        System.out.println(pivotIndex(arr));
    }
    private static int pivotIndex(int[] arr){
        int totalSum = Arrays.stream(arr).sum();
        int i=0, sum=0;
        while(i<=arr.length-1){
            if(sum==totalSum){
                return i+1;
            }
            sum += arr[i];
            System.out.println("sum : " + sum);
            totalSum-=sum;
            System.out.println("totalSum : " + totalSum);
            i++;
        }

        return  -1;
    }
}
