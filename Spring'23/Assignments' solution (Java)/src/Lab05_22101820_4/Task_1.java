package Lab05_22101820_4;
import java.util.*;
public class Task_1 {
    public static class array_stack{
        String[][] stack;
        int size;
        array_stack(int capacity) {this.stack= new String[capacity][2];}


        void push(String[] element){
            stack[size]= element;
            size++;
        }

        Object pop(){
            String[] rem_val= stack[size-1];
            stack[size-1]= null;
            size--;
            return rem_val;
        }

        String[] peek() {return stack[size-1];}

        boolean empty_checker() {return size== 0;}

        boolean pair_matching(char x, char y) {
            if (x == '(' && y == ')') return true;
            if (x == '{' && y == '}') return true;
            if (x == '[' && y == ']') return true;
            return false;
        }
    }

    public static String checker(String string){
        int capacity= string.length();
        array_stack shelby= new array_stack(capacity);
        for (int i= 0; i< string.length(); ++i){
            if (string.charAt(i)== '('||  string.charAt(i)== '{'|| string.charAt(i)== '[') shelby.push(new String[]{String.valueOf(string.charAt(i)), String.valueOf(i+1)});
            else if (string.charAt(i)== ')'||  string.charAt(i)== '}'|| string.charAt(i)== ']'){
                if (!shelby.empty_checker()){    //checking Stack Underflow
                    String[] peek_checker= shelby.peek();
                    if (shelby.pair_matching(peek_checker[0].charAt(0), string.charAt(i))){
                        shelby.pop();
                    }
                    else{
                        return new Formatter().format("%s\nThis expression is NOT correct.\nError at character # %s. ‘%s‘- not closed.\n", string, peek_checker[1], peek_checker[0]).toString();
                    }
                }
                else return new Formatter().format("%s\nThis expression is NOT correct.\nError at character # %s. ‘%s‘- not opened.\n", string, i+1, string.charAt(i)).toString();
            }

        }
        if (shelby.empty_checker()) return new Formatter().format("%s\nThis expression is correct.\n", string).toString();
        String[] peek_checker= shelby.peek();
        return new Formatter().format("%s\nThis expression is NOT correct.\nError at character # %s. ‘%s‘- not closed.\n", string, peek_checker[0], peek_checker[1]).toString();
    }
    public static void main(String[] shelby){
        System.out.println(checker("1+2*(3/4)"));
        System.out.println(checker("1+2*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14"));
        System.out.println(checker("1+2*[3*3+{4–5(6(7/8/9)+10)}–11+(12*8)/{13+13}]+14"));
        System.out.println(checker("1+2]*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14"));
    }
}
