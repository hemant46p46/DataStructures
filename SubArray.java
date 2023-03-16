import java.math.BigInteger;
import java.util.*;

public class SubArray {
    public String addStrings(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1), n2 = new BigInteger(num2);
        return String.valueOf(n1.add(n2));
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
//        List<List<Integer>> permutes = permute(arr);
//        for(List<Integer> el : permutes){
//            System.out.println(el);
//        }
        System.out.println(Math.floor(Math.pow(2, -2)));
    }

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private static void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr){

        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<>(resultList));
        }
        else{
            for (int j : arr) {

                if (resultList.contains(j)) {
                    continue;
                }
                resultList.add(j);
                permuteHelper(list, resultList, arr);
                resultList.remove(resultList.size() - 1);
            }
        }
    }
    public static void findPowerSet(int []s, Deque<Integer> res, int n){
        if (n == 0){
            for (Integer element : res)
                System.out.print(element);
            System.out.println();
            return;
        }
        res.addLast(s[n - 1]);
        findPowerSet(s, res, n - 1);
        res.removeLast();
        findPowerSet(s, res, n - 1);
    }    private static void subArrays(int[] arr, int start, int end){
        if(end == arr.length){
            return;
        }
        else if(start > end){
            subArrays(arr, 0, end+1);
        }else{
            for(int i=start;i<end;i++){
                System.out.print(arr[i]);
            }
            System.out.println(arr[end]);
            subArrays(arr, start+1, end);
        }
    }
    private static void printPowerSet(int[] arr, int n){
        int limit = (int)Math.pow(2, n);
        for(int i=1;i<limit;i++){
            for(int j=0;j<n;j++){
                if(BigInteger.valueOf(i).testBit(j)){
                    System.out.print(arr[j]);
                }
            }
            System.out.println();
        }
    }
}
