public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int sum = 23;
        subArraySum(arr, sum);
    }
    private static void subArraySum(int[] arr, int sum){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int currentSum = arr[i];
            if(currentSum == sum){
                System.out.println("Sum found at index : " + i);
                return ;
            }
            else{
                for(int j=i+1;j<n;j++){
                    currentSum += arr[j];
                    if(sum == currentSum){
                        System.out.println("sum found between " + i + " and " + j);
                        return;
                    }
                }
            }
        }
    }
}
