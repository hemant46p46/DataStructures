import java.util.Arrays;

public class CountInversion {
    public static void main(String[] args) {
        long[] arr = { 1, 20, 6, 4, 5 };

        System.out.println(
                msac(arr, 0, arr.length - 1));
    }
    private static long msac(long[] arr, long start, long end){
        long count = 0;
        if(start < end){
            long mid = (start+end)/2;
            count += msac(arr, start, mid);
            count += msac(arr, mid+1, end);
            count += mc(arr, start, mid, end);
        }
        return count;
    }
    private static long mc(long[] arr, long start, long mid, long end){
        long[] l = Arrays.copyOfRange(arr, (int) start, (int) (mid+1));
        long[] r = Arrays.copyOfRange(arr, (int) (mid+1), (int) (end+1));

        int i=0, j=0, k= (int) start;
        long swaps = 0;
        while(i<l.length && j<r.length){
            if(l[i] < r[j]){
                arr[k++] = l[i++];
            }else{
                arr[k++] = r[j++];
                swaps += (mid+1)-(start+i);
            }
        }
        while(i<l.length){
            arr[k++] = l[i++];
        }
        while(j<r.length){
            arr[k++] = r[j++];
        }
        return swaps;
    }

}
