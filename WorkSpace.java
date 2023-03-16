public class WorkSpace {
    public static void main(String[] args) {
        System.out.println(2&(2));
        System.out.println(2&6&(2));
        System.out.println(2&6&2&(2));
        System.out.println(6&2&(2));
        System.out.println(2&2);
        System.out.println(2&6&6&4&(2));
//        long[] a = {2, 6, 2};
//        System.out.println(totalSubArrays(a, a.length, 2));
//        System.out.println("For nxt ");
//        long[] a1 = {2, 6, 6, 4};
//        System.out.println(totalSubArrays(a1, a1.length, 2));
    }
    public static long totalSubArrays(long[] a, int n, long x){
        long count = 0;
        for(int i=0;i<n;i++){
            if(a[i]==2){
                count++;
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((a[i]&a[j])==x){
                    System.out.println(a[i] + " " + a[j]);
                    count++;
                }
            }
        }
        return count;
    }
}
