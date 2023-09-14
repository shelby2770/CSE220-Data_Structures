package Lab01_22101820_4;
import static Lab01_22101820_4.part2_code.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
public class part2_driverCode {
    public static void main(String[] shelby){
        int[] source= {10, 8, 13, 9, 14, 25, -5, 20, 7, 7, 4};
        System.out.println(mean(source));
        System.out.println(standard_dev(source));
        System.out.println(Arrays.toString(new_arr(source)));
    }
}
