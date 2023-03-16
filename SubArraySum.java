import java.util.ArrayList;
import java.util.Arrays;

public class SubArraySum {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 20, 3, 10, 5};
//        int sum = 33;
//        System.out.println(subArraySum(arr, sum));
        int[] arr = {1,2,3,5};
        System.out.println(MissingNumber(arr, arr.length));
    }
    static int maxSubarrayProduct(int[] arr, int n) {

        int max_ending_here = arr[0];
        int min_ending_here = arr[0];
        int max_so_far = arr[0];
        for (int i = 1; i < n; i++) {
            int temp = Math.max(
                    Math.max(arr[i], arr[i] * max_ending_here),
                    arr[i] * min_ending_here);
            min_ending_here = Math.min(
                    Math.min(arr[i], arr[i] * max_ending_here),
                    arr[i] * min_ending_here);
            max_ending_here = temp;
            max_so_far
                    = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    private static int MissingNumber(int[] array, int n) {
        // Your Code Here
        Arrays.sort(array);
        int missing = -1;
        for(int i=1;i<=n;i++){
            if(array[i] != i+1){
                return i+1;
            }
        }
        return -1;
    }
    private static boolean subArraySum(int[] arr, int sum) {
        int n = arr.length;
        int currentSum = arr[0], start = 0;
        for (int i = 1; i <= n; i++) {
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println("Sum found between indexes : " + start + ", " + p);
                return true;
            }
            if (i < n) {
                currentSum = currentSum + arr[i];
            }
        }
        System.out.println("No subArray found..");
        return false;
    }

    private static ArrayList<Integer> subArrayGivenSum(int[] arr, int n, int s){
        return new ArrayList<>();
    }
}
