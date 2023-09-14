package Lab07_22101820_4;

import java.util.*;
public class Task_2 {
    static String[] hashing(String[] arr){
        String[] hash_table= new String[9]; //Given, the String array will contain no more than 9 values
        for (String ele:arr){
            int total= 0;
            for (int j=0; j< ele.length(); ++j){
                if ((int) ele.charAt(j)>= 65 && (int) ele.charAt(j)<= 90 &&
                        !"AEIOU".contains(String.valueOf(ele.charAt(j)))){
                    total+= 24;
                }
                else if ((int) ele.charAt(j)>=48 && (int) ele.charAt(j)<= 57) total+= (int) ele.charAt(j)- '0';
            }
            int temp_idx= total%9; //Hash function calculation

            //linear probing
            while (hash_table[temp_idx]!= null){
                temp_idx= (temp_idx+1)%9;
            }
            hash_table[temp_idx]= ele;
        }
        return hash_table;
    }

    public static void main(String[] shelby){
        String[] s= {"ST1E89B8A32", "SL9HFJA5WEP", "E7BMQA6JD4W", "TLG82DEUB46", "85VDXBEFI9U", "ANMJCH7L193", "QKMR91NO2E6", "4R0EY6BPVLG", "DKX3YSJVOB1"};
        System.out.println(Arrays.toString(hashing(s)));
    }
}
