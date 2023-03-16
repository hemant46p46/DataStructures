import java.util.Arrays;

public class SortingAlgo {
    public static void main(String[] args) {
        int[] data = { -2, 45, 0, 11, -9 };
        System.out.println(Arrays.toString(data));
//        bubbleSort(data);
//        bubbleSortOptimized(data);
//        selectionSort(data);
//        insertionSort(data);
//        mergeSort(data, 0, data.length-1);
        quickSort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
    private static void quickSort(int[] arr, int start, int end){
        if(start < end){
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi-1);
            quickSort(arr, pi+1, end);
        }
    }
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start-1;
        for(int j=start;j<end;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return (i+1);
    }
    private static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    private static void merge(int[] arr, int start, int mid, int end){
        int l1 = mid+1-start;
        int l2 = end-mid;
        int[] left = new int[l1];
        int[] right = new int[l2];
        for(int i=0;i<l1;i++){
            left[i] = arr[start+i];
        }
        for(int i=0;i<l2;i++){
            right[i] = arr[mid+1+i];
        }
        int i=0, j=0, k=start;
        while(i<l1 && j<l2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while (i<l1){
            arr[k++] = left[i++];
        }
        while (j<l2){
            arr[k++] = right[j++];
        }
    }
    private static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
        }
    }
    private static void selectionSort(int[] arr){
        int n = arr.length, min, temp;
        for(int i=0;i<n-1;i++){
            min = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    private static void bubbleSortOptimized(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            boolean swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    private static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
