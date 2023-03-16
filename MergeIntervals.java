import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        intervals = merge(intervals);
        for (int[] interval : intervals) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.print(interval[j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] merge(int[][] intervals){
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int[] interval : intervals){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1]<interval[0]){
                ans.add(interval);
            }else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size()-1)[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
