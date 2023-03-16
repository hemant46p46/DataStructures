import java.util.Arrays;
import java.util.HashSet;

public class UnionInterSection {
    public static void main(String[] args) {
        int[] arr = {90, 100, 78, 89, 67};
        int[] arr1 = {56, 67, 30, 79};
        findMedian(arr);
        findMedian(arr1);
    }
    public static int doUnion(int a[], int n, int b[], int m) {
        //Your code here
        HashSet<Integer> set = new HashSet<>();
        for(int i:a){
            set.add(i);
        }
        for(int j:b){
            set.add(j);
        }
        return set.size();
    }
    private static void findMedian(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        if(n%2==0){
            System.out.println("Median : " + ((arr[(n/2)-1] + arr[(n/2)])/2));
        }else{
            System.out.println("Odd Length Median : " + arr[(n/2)]);
        }
    }
}
