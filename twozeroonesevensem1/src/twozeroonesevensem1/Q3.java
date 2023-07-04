/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twozeroonesevensem1;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word to be reversed: ");
        String input = sc.next();
        Stack stack = new Stack(input.length());
        
        for (char c : input.toCharArray()){
            stack.push(c);
        }
        
        StringBuilder reverse = new StringBuilder();
        while (!stack.isStackEmpty()){
            reverse.append(stack.pop());
        }
        
        System.out.println("Original word: " + input);
        System.out.println("Reversed word: " + reverse.toString());
    }
}

class Stack{
    private int maxSize;
    private char [] stackArray;
    private int top;
    
    public Stack(int size){
        maxSize = size;
        stackArray = new char [maxSize];
        top = -1;
    }
    
    public void push (char c){
        if (!isStackFull()){
            stackArray[++top] = c;
        }else{
            System.out.println("The stack is full!");
        }
    }
    
    public char pop(){
        if (!isStackEmpty()){
            return stackArray[top--];
        }else{
            System.out.println("The stack is empty!");
            return '0';
        }
    }
    
    public char peek(){
        if(!isStackEmpty()){
            return stackArray[top];
        }else{
            System.out.println("The stack is empty!");
            return '0';
        }
    }
    
    public boolean isStackFull(){
        return (top == maxSize - 1);
    }
    
    public boolean isStackEmpty(){
        return (top == -1);
    }
}
