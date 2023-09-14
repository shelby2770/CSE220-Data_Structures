package Lab01_22101820_4;
public class part1_code {
    //task1
    static int[] shift_left(int[] source, int k) {
        for (int i = 0; i < source.length; ++i) {
            if (i < k) source[i] = 0;
            else {
                source[i - k] = source[i];
                source[i] = 0;
            }
        }
        return source;
    }

    static int[] rotate_left(int[] source, int k) {
        for (int i = 0; i < k; ++i) {
            int temp = source[0];
            for (int j = 1; j < source.length; ++j) {
                source[j - 1] = source[j];
            }
            source[source.length - 1] = temp;
        }
        return source;
    }

    static int[] shift_right(int[] source, int k) {
        for (int i= source.length-1; i>= 0; --i) {
            if (i-k<0) source[i] = 0;
            else source[i] = source[i-k];
        }
        return source;
    }

    static int[] rotate_right(int[] source, int k) {
        for (int i= 0; i< k; ++i) {
            int temp= source[source.length-1];
            for (int j= source.length-1; j>0; --j){
                source[j]= source[j-1];
            }
            source[0]= temp;
        }
        return source;
    }

    static int[] remove(int[] source, int idx){
        for (int i= idx; i<source.length-1; ++i){
            source[i]= source[i+1];
        }
        source[source.length-1]= 0;
        return source;
    }

    static int[] remove_all(int[] source, int element){
        int counter=0, ele_pos= 0;
        for (int i=0; i<source.length; ++i){
            if (source[i]!= element){
                source[counter]= source[i];
                counter++;
            }
            else{
                source[source.length-(++ele_pos)]= 0;
            }
        }
        return source;
    }

    static boolean split_array(int[] source){
        int sum1= 0;
        for (int i= 0; i< source.length-1; ++i){
            sum1+= source[i]; int sum2= 0;
            for (int j= i+1; j< source.length; ++j){
                sum2+= source[j];
            }
            if (sum1== sum2) return true;
        }
        return false;
    }

    static int max_bunch(int[] source){
        if (source.length== 0) return 0;
        int counter= 1, max_counter= 0, prev= source[0];
        for (int i=1; i< source.length; ++i){
            if (source[i]== prev) counter++;
            else{
                prev= source[i];
                if (counter> max_counter) max_counter= counter;
                counter= 1;
            }
        }
        return max_counter>=counter? max_counter: counter;
    }
}