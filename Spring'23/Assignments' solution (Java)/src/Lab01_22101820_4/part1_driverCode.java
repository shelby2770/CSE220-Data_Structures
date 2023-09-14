package Lab01_22101820_4;
import static Lab01_22101820_4.part1_code.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;


public class part1_driverCode {
    public static void main(String[] shelby){
        // This cell is the driver code
        //Run this cell after completion of above function.
        // You will see the status Accepted after completion if your code is correct.
        // If your function is wrong you will see wrong[correction percentage]
        // This is call unit testing if you are wondering the checking approach
        // No need to write or change any code here

        System.out.println("///  Test 01: Shift Left k cell  ///");
        int[] source1 = {10,20,30,40,50,60};
        int[] returned_value1 = shift_left(source1, 3); // This should return [40, 50, 60, 0, 0, 0]
        System.out.println(Arrays.toString(returned_value1));

        System.out.println("///  Test 02: Rotate Left k cell  ///");
        int[] source2 = {10,20,30,40,50,60};
        int[] returned_value2 = rotate_left(source2, 3); // This should return [40, 50, 60, 10, 20, 30]
        System.out.println(Arrays.toString(returned_value2));

        System.out.println("///  Test 03: Shift Right k cell  ///");
        int[] source3 = {10,20,30,40,50,60};
        int[] returned_value3 = shift_right(source3, 3); // This should return [0, 0, 0, 10, 20, 30]
        System.out.println(Arrays.toString(returned_value3));

        System.out.println("///  Test 04: Rotate Right k cell  ///");
        int[] source4 = {10,20,30,40,50,60};
        int[] returned_value4 = rotate_right(source4, 3); // This should return [40, 50, 60, 10, 20, 30]
        System.out.println(Arrays.toString(returned_value4));

        System.out.println("///  Test 05: Remove an element from an array  ///");
        int[] source5 = {10,20,30,40,50,0,0};
        int[] returned_value5 = remove(source5, 2); // This should return [10, 20, 40, 50, 0, 0, 0]
        System.out.println(Arrays.toString(returned_value5));

        System.out.println("///  Test 06: Remove all occurrences of a particular element from an array  ///");
        int[] source6 = {10,2,30,2,50,2,2,0,0};
        int[] returned_value6 = remove_all(source6, 2); // This should return [10, 30, 50, 0, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(returned_value6));

        System.out.println("///  Test 07: Splitting an Array  ///");
        int[] test_1 = {1, 1, 1, 2, 1}; // Here splitting is possible as summation of [1, 1, 1] = summation of [2,1]
        boolean returned_value_1 = split_array(test_1); // This should return true
        System.out.println(returned_value_1);
        int[] test_2 = {2, 1, 1, 2, 1}; // Here splitting is not possible
        boolean returned_value_2 = split_array(test_2); // This should return false
        System.out.println(returned_value_2);
        int[] test_3 = {10, 3, 1, 2, 10}; // Here splitting is possible as summation of [10, 3] = summation of [1,2,10]
        boolean returned_value_3 = split_array(test_3); // This should return true
        System.out.println(returned_value_2);

        System.out.println("///  Test 08: Max Bunch Count  ///");
        int returned_value__1 = max_bunch(new int[]{1, 2, 2, 3, 4, 4, 4}); // This should return 3
        System.out.println(returned_value__1);
        int returned_value__2 = max_bunch(new int[]{1, 1, 2, 2, 1, 1, 1, 1}); // This should return 4
        System.out.println(returned_value__2);
    }
}

