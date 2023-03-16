import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {2, 2, 2, 2, 5, 5, 2, 3, 3};
        int[] a1 = {1, 3, 3, 3, 2};
        int[] a2 = {1, 3, 1, 3, 2};
        int[] a3 = { 1, 1, 2, 1, 3, 5, 1 };

        System.out.println(majorityElement(a, a.length) + " : " + a.length + " : " + (a.length/2));
        System.out.println(majorityElement(a1, a1.length) + " : " + a1.length + " : " + (a1.length/2));
        System.out.println(majorityElement(a2, a2.length) + " : " + a2.length + " : " + (a2.length/2));
        System.out.println(majorityElement(a3, a3.length) + " : " + a3.length + " : " + (a3.length/2));
    }
    private static int majorityElement(int[] arr, int n) {
        int i=0, j=0, majLimit;
        if(n%2==0){majLimit = n/2;}
        else{
            majLimit = (n/2)+1;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        while(j<n){
            if(arr[i] == arr[j]){
                j++;
                if(j-i+1 == majLimit){
                    return arr[i];
                }
            }else{
                ++j;
                i = j;
            }
        }
        return -1;
    }
}
