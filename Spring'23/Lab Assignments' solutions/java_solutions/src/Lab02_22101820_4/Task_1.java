package Lab02_22101820_4;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class Task_1 {
    static void left_rotate(char[] source, int k){
        int fr= k;
        for (int i=0; i< source.length; ++i){
            System.out.print(source[fr]);
            fr--; if (fr<0) fr= source.length-1;
        }
        System.out.println();
    }
    static void right_rotate(char[] source, int l){
        int fr= l;
        for (int i=0; i< source.length; ++i){
            System.out.print(source[fr]);
            fr= (++fr)%source.length;
        }
        System.out.println();
    }
    static int[] cap_finder(char[] source){
        int sc = 0, si = 0;
        for (int i=0; i< source.length; ++i){
            if ('A'<= source[i] && source[i]<= 'Z') {sc= (int) source[i]; si= i;}
        }
        return new int[]{sc, si};
    }
    static void bilboard(String s1, String s2, Scanner input){
        char[][] mul_arr= new char[10][10];

        for (int i=0; i<s1.length(); ++i) mul_arr[0][i]= s1.charAt(i);
        for (int i=0; i<s2.length(); ++i) mul_arr[1][i]= s2.charAt(i);

        int[] top_start_char_index= cap_finder(mul_arr[0]),
        bottom_start_char_index= cap_finder(mul_arr[1]);

        System.out.printf("""
                Top Board Start Character: %s
                Top Board Start Index: %d
                Bottom Board Start: %s
                Bottom Board Start Index: %d""", (char) top_start_char_index[0], top_start_char_index[1],
                (char) bottom_start_char_index[0], bottom_start_char_index[1]);

        int k= top_start_char_index[1], l= bottom_start_char_index[1];
        while (input.hasNextLine()){
            System.out.println("Press any key and then press enter to continue!!!");
            String key= input.nextLine();
            if (key.equals("q")||key.equals("Q")){
                int[] top_start_checker= cap_finder(mul_arr[0]),
                bottom_start_checker= cap_finder(mul_arr[1]);
                System.out.printf("""
                        Top Board Start Character: %s
                        Top Board Start Index: %d
                        Bottom Board Start: %s
                        Bottom Board Start Index: %d""", (char) top_start_checker[0], top_start_checker[1],
                        (char) bottom_start_checker[0], bottom_start_checker[1]);
                break;
            }
            left_rotate(mul_arr[0], k);
            right_rotate(mul_arr[1], l);
            k--; if (k<0) k= mul_arr[0].length-1;
            l--; if (l<0) l= mul_arr[1].length-1;
        }

    }
    public static void main(String[] shelby){
        Scanner input= new Scanner(System.in);
        String string_1= input.next();
        if (string_1.length()>10) System.out.println("Invalid Input Size");
        else{
            String string_2= input.next();
            if (string_2.length()>10) System.out.println("Invalid Input Size");
            else{
                System.out.println("Your input is valid. Press any key and then press enter to continue!!!");
                bilboard(string_1, string_2, input);
            }
        }
    }
}
