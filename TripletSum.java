import java.util.Arrays;
import java.util.HashSet;

public class TripletSum {
    public static void main(String[] args) {
        TripletSum triplet = new TripletSum();
        int[] A = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        triplet.find3Numbers(A, arr_size, sum);
        triplet.find3Numbers1(A, arr_size, sum);
    }
     private boolean find3Numbers1(int[] arr, int n, int sum){
        for(int i=0;i<n-2;i++){
            HashSet<Integer> set = new HashSet<>();
            int currSum = sum-arr[i];
            for(int j=i+1;j<n;j++){
                if(set.contains(currSum-arr[j])){
                    System.out.println("Triplets : " + arr[i] + ", " + arr[j] + ", " + (currSum-arr[j]));
                    return true;
                }
                set.add(arr[j]);
            }
        }
        return false;
    }
    boolean find3Numbers(int[] arr, int n, int sum){
        Arrays.sort(arr);
        int left, right;
        for(int i=0;i<n-2;i++){
            left = i+1;
            right = n-1;
            while(left<right){
                if(arr[i] + arr[left] + arr[right]==sum){
                    System.out.println("Triplet is : " + arr[i] +
                            " : " + arr[left] +" : "  + arr[right]);
                    return true;
                }else if(arr[i]+arr[left]+arr[right] < sum){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return false;
    }
}
