package Lab06_22101820_4;
import Lab03_22101820_4.LinkedList;
import Lab03_22101820_4.Node;
import java.util.*;

public class Part_1 {
    static int fact(int num){
        return num== 1?1:num*fact(num-1);
    }

    static int fibonacci(int num){
        return num<= 1?num:fibonacci(num-1)+fibonacci(num-2);
    }

    static void print_arr(int[] arr, int pos){
        if (pos== arr.length) return;
        System.out.println(arr[pos]);
        print_arr(arr, pos+1);
    }

    static Object decimal_to_binary(int num){
        return num<=1? num:decimal_to_binary(num/2)+ Integer.toString(num%2);
    }
    static int powerN(int val, int n_pow){
        return n_pow== 1?val:val*powerN(val, n_pow-1);
    }

    static int sum_linked_list(Node k){
        return k.next== null?(int)k.element: (int)k.element+sum_linked_list(k.next);
    }

    static Object rev_linked_list(Node k){
        if (k.next== null) return k.element;
        System.out.println(rev_linked_list(k.next));
        return k.element;
    }

    static int hocBuilder(int height){
        if (height== 0) return 0;
        if (height== 1) return 8;
        return 5+ hocBuilder(height-1);
    }

    static String star_pattern(String outer_num){
        if (outer_num.equals("1")) return "1";
        return new Formatter().format("%s\n%s", star_pattern(Integer.toString(Integer.parseInt(outer_num)-1)), row(outer_num)).toString();
    }

    private static String row(String inner_num) {
            if (inner_num.equals("1")) return "1";
            return row(Integer.toString(Integer.parseInt(inner_num)-1))+ inner_num;
    }

    static void rev_star_pattern(int num1, int num2){
        if (num1== 0) return;
        spacePrint(num1-1);
        pattern(num2-num1+1, 1);
        rev_star_pattern(num1-1, num2);
    }

    private static void pattern(int i, int num) {
        if (i== 0) {
            System.out.println();
            return;
        }
        System.out.print(num);
        pattern(i-1, i+1);
    }

    private static void spacePrint(int i) {
        if (i== 0) return;
        System.out.print(" ");
        spacePrint(i-1);
    }

    public static void main(String shelby[]){
        System.out.println(fact(6));
        System.out.println(fibonacci(21));

        int[] arr= {10, 20, 30, 40, 50, 60, 70};
        print_arr(arr, 0);

        int val= 2, n_pow= 7;
        System.out.println(powerN(val, n_pow));
        System.out.println(decimal_to_binary(2345));

        Object[] a1= {10, 20, 30, 40};
        LinkedList l= new LinkedList(a1);
        System.out.println(sum_linked_list(l.head));
        System.out.println(rev_linked_list(l.head));

        System.out.println(hocBuilder(3));

        System.out.println(star_pattern(Integer.toString(5)));
        rev_star_pattern(5,5);
    }
}
