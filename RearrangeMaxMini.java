import java.util.Arrays;

public class RearrangeMaxMini {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr1 = {1,3,2,4,7,6,9,10};
        waveForm(arr);
    }
    public static void waveForm(int[] arr){//n*O(n)
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n-1;i+=2){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] =temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void leftRotate(int[] arr, int n, int d){
        int mod = d%n;
        for(int i=0;i<n;i++){
            System.out.print(arr[(i + mod)%n] + " ");
        }
        System.out.println();
    }

    public static void rotateArray(int[] arr, int d){
        if(d==0){return;}
        int n = arr.length;
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;end--;
        }
    }

    public static void segregateEvenOdd(int[] arr){
        int n = arr.length;
        int[] a = new int[n];
        int k=0;
        for(int i:arr){
            if(i%2==0){
                a[k++] = i;
            }
        }
        for(int i:arr){
            if(i%2!=0){
                a[k++] = i;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void evenGreaterThanOddPos(int[] arr){
        Arrays.sort(arr);
        int n = arr.length, p = 0, q = n-1;

        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            if((i+1)%2==0){
                temp[i] = arr[q--];
            }else{
                temp[i] = arr[p++];
            }
        }
        System.out.println(Arrays.toString(temp));
    }
    public static void arrange(int[] arr){
        int[] temp = arr.clone();
        int left = 0, right = arr.length-1;
        boolean flag = true;
        for(int i=0;i<arr.length;i++){
            if(flag){
                arr[i] = temp[left++];
            }else{
                arr[i] = temp[right--];
            }
            flag = !flag;
        }
        System.out.println(Arrays.toString(arr));
    }
}