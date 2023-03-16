import java.util.ArrayList;
import java.util.Scanner;

public class NaturalNumberSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int annaChoice = sc.nextInt();
        int emmyChoice = sc.nextInt();
        System.out.println(getChoice(n, annaChoice, emmyChoice));
    }
    static int count = 0;
    private static int getChoice(int n, int annaChoice, int emmyChoice) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        getSubsequences(arr, 0, list, annaChoice, emmyChoice);
        return count;
    }
    public static void getSubsequences(int[] arr, int index, ArrayList<Integer> path, int annaChoice, int emmyChoice) {
        if (index == arr.length) {
            if (path.size()!=annaChoice && path.size()!=emmyChoice && path.size()!=0){
                count++;
            }
        } else {
            getSubsequences(arr, index + 1, path, annaChoice, emmyChoice);
            path.add(arr[index]);
            getSubsequences(arr, index + 1, path, annaChoice, emmyChoice);
            path.remove(path.size() - 1);
        }
    }

}
