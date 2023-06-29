package twozeroonesix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Downloads\\BracMatch.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(checkMatchedBrackets(line));
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String checkMatchedBrackets(String inputString){
        if (inputString.isEmpty()){
            return "There is no bracket in the input";
        }

        Stack <Character> stack = new Stack <>();
        for (char c : inputString.toCharArray()){
            if(isLeftBracket(c)){
                stack.push(c);
            }else if (isRightBracket(c)){
                if(stack.isEmpty()){
                    return "Not all brackets are matched.";
                }
                char topBracket = stack.pop();
                if (!isMatchingBracket(topBracket,c)){
                    return "Not all brackets are matched";
                }
            }
        }
        if (!stack.isEmpty()){
            return "Not all brackets are matched.";
        }else{
            return "YES - all matched!";
        }
    }

    private static boolean isLeftBracket(char c){
        return c == '[' || c == '{' || c == '(' || c == '<';
    }

    private static boolean isRightBracket(char c){
        return c == ']' || c == '}' || c == ')' || c == '>';
    }

    private static boolean isMatchingBracket(char left, char right){
        return (left == '[' && right == ']')
                || (left == '{' && right == '}')
                || (left == '(' && right == ')')
                || (left == '<' && right == '>');
    }
}
