package Lab01_22101820_4;

public class part2_code {
    static double mean(int[] source){
        double total= 0;
        for (int i: source) total+= i;
        return total/source.length;
    }

    static double standard_dev(int[] source){
        double mean_= mean(source), total= 0;
        for (int i: source) total+= Math.pow((i-mean_),2);
        return Math.sqrt(total/(source.length-1));
    }

    static int[] new_arr(int[] source){
        double mean_= mean(source), standard_dev_= standard_dev(source),
        upper_bound= mean_+standard_dev_*1.5, lower_bound= mean_-standard_dev_*1.5;
        int[] arr= new int[source.length];
        int counter= 0;

        for (int i: source){
            if (i>upper_bound || i< lower_bound){
                arr[counter]= i; counter++;
            }
        }
        if (counter== 0) return null;

        int[] re_arr= new int[counter];
        for (int i=0; i< counter; ++i) re_arr[i]= arr[i];
        return re_arr;
    }
}
