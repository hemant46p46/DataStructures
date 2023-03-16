public class BuySellStock {
    public static void main(String[] args) {

        int[] prices = {100, 180, 260, 310, 40, 535, 695 };
        int[] prices1 = {4, 2, 2, 2, 4};
        buySellStocks(prices, prices.length);
        buySellStocks(prices1, prices1.length);
    }
    private static void buySellStocks(int[] prices, int n){
        System.out.println("_________________________________________");
        int i=1, j=0;
        while(i<n){
            if(i==n-1){
                System.out.print("(" + j + " " + i + ")");
            }
            if(prices[i] >= prices[i-1]){
                i++;
            }
            else{
                if(j==(i-1)){
                    j=i;
                    i++;
                    continue;
                }
                System.out.print("("+ j + " " + (i - 1) + ") ");
                j=i;
                i++;
            }
        }
    }
}