package Lab06_22101820_4;
public class FinalQ{
    public static void print(int[]array,int idx){
        if(idx<array.length){
            double profit=calcProfit(array[idx]);
            System.out.printf("%d. Investment: %d; Profit: %s\n", idx+1, array[idx], profit);
            print(array, idx+1);
        }
    }
    public static double calcProfit(int investment){
        if (investment<= 25000) return 0;
        return investment>25000 && investment<= 100000?45+calcProfit(investment-1000):80+calcProfit(investment-1000);
    }
    public static void main(String[] shelby) {
        int[] array = {25000, 100000, 250000, 350000};
        print(array, 0);
    }
}