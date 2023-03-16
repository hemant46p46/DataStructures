import java.util.Arrays;

public class SegregateEvenOdd {
    public static void main(String[] args) {
        arrayEvenOdd(new int[]{1, 3, 2, 4, 7, 6, 9, 10});
        arrayOddEven(new int[]{1, 3, 2, 4, 7, 6, 9, 10});
    }
    private static void arrayEvenOdd(int[] arr){
        int i=-1, j=0, n=arr.length, temp;
        while(j!=n){
            if(arr[j]%2==0){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void arrayOddEven(int[] arr){
        int i=-1, j=0, n=arr.length, temp;
        while(j!=n){
            if(arr[j]%2!=0){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
