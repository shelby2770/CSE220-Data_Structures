package Lab07_22101820_4;
import java.util.*;

class KeyIndex{
    int arr[];
    KeyIndex(int[] a) {
        int max_val= a[0], min_val= a[0];
        for (int i: a) {
            if (i<min_val) min_val= i;
            if (i>max_val) max_val= i;
        }
        this.arr= new int[max_val-min_val+2]; //aux_arr +1 because indexing starts from 0 and another +1 to store min_val
        for (int i: a) {
            this.arr[i-min_val]++;
        }
        this.arr[this.arr.length-1]= min_val; //storing min_val at the last pos of array
    }

    boolean search(int val){
        int idx= val-arr[arr.length-1];
        if (idx>= arr.length-1 || idx<0) return false;
        return arr[idx]!= 0;
    }
    int[] sort(){
        int idx= 0; int[] sorted_arr= new int[arr.length];
        for (int i=0; i<sorted_arr.length-1; ++i){
            int total_elem= arr[i];
            for (int j= 0; j<total_elem; ++j){
                sorted_arr[idx]= i+arr[arr.length-1];
                idx++;
            }
        }

        int[] resized_sorted_arr= new int[idx];
        for (int i= 0; i< idx; ++i){
            resized_sorted_arr[i]= sorted_arr[i];
        }
        return resized_sorted_arr;
    }
}

public class Task_1 {
    public static void main(String[] shelby){
        int[] k= {-4, 8, 3, 4, -1, 5, 2, -9, -7, 5, -1};
        KeyIndex obj= new KeyIndex(k);
        System.out.println(obj.search(5));
        System.out.println(Arrays.toString(obj.sort()));
    }
}
