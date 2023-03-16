import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
//        int[] arr1 = {11, 1, 13, 21, 3, 7};
//        int[] arr2 = {11, 3, 7, 1};
//        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] a2 = {1, 2, 3, 1};
//        System.out.println(isSubset(arr1, arr2));
//        System.out.println(isSubset(a1, a2));
//        System.out.println(isSubset1(arr1, arr2));
//        System.out.println(isSubset1(a1, a2));

        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        solve(nums, 0, nums.length-1, list);
        return ans;
    }
    static List<List<Integer>> ans = new ArrayList<>();
    private static void solve(int[] nums, int start, int end, List<Integer> per) {
        if (start == end) {
            ans.add(per);
            return;
        } else {
            for (int i = start; i <= end; i++) {
                nums = swap(nums, start, i);
                solve(nums, start + 1, end, per);
                nums = swap(nums, start, i);
            }
        }
    }
    private static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    private static boolean isSubset1(int[] arr1, int[] arr2){
        int m = arr1.length, n = arr2.length;
        Hashtable<Integer, Integer> fr = new Hashtable<>();
        for (int j : arr1) {
            fr.put(j, fr.getOrDefault(j, 0) + 1);
        }
        for(int i=0;i<n;i++){
            if(fr.getOrDefault(arr2[i], 0)>0){
                fr.put(arr2[i], fr.get(arr1[i])-1);
            }else{
                return false;
            }
        }
        return true;
    }
    private static boolean isSubset(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr1){
            set.add(i);
        }
        for(int i:arr2){
            if(!set.contains(i)){
                return false;
            }else{
                set.add(i);
            }
        }
        return true;
    }
}