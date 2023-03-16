public class LargestTree {
    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 50, 23, 90};
        largestTree(arr);
    }
    private static void largestTree(int[] arr){
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for(int i:arr){
            if(i > first){
                third = second;
                second = first;
                first = i;
            }
            else if(i> second && i!=first){
                third = second;
                second = i;
            }
            else if(i > third && i!=second){
                third = i;
            }
        }
        System.out.println("first : " + first);
        System.out.println("second : " + second);
        System.out.println("third : " + third);
    }

}
