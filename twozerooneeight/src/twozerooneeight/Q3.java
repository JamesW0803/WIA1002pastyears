/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twozerooneeight;

/**
 *
 * @author User
 */

//hard lehh

public class Q3 {
    public static void main(String[] args) {
//        StackTest stack1 = new StackTest(4);
//        stack1.push("one");
//        stack1.push("two");
//        stack1.push("three");
//        stack1.push("four");
//        stack1.displayInReverse();
//        stack1.popAll();
//        stack1.displayInReverse();
          StackWithGeneric <String> stack1 = new StackWithGeneric <String> (4);
          stack1.push("one");
          stack1.push("two");
          stack1.push("three");
          stack1.push("four");
          System.out.println(stack1.peek());
          stack1.display();
          stack1.displayInReverse();
          stack1.popAll();
          
          StackWithGeneric <Integer> stack2 = new StackWithGeneric <Integer> (4);
          stack2.push(100);
          stack2.push(200);
          stack2.push(300);
          stack2.push(400);
          System.out.println(stack2.peek());
          stack2.display();
          stack2.displayInReverse();
          stack2.popAll();
    }
}

class StackWithGeneric <E>{
    private E [] stack;
    private int top;
    
    public StackWithGeneric(int capacity){
        stack = (E[]) new Object [capacity];
        top = -1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public E peek(){
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }
    
    public void push(E data){
        if (top == stack.length - 1){
            System.out.println("Stack is full");
            return;
        }
        top ++;
        stack[top] = data;
        System.out.println("Push item into stack: " + data);
    }
    
    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        E data = stack[top];
        stack[top] = null;
        top --;
        return data;
    }
    
    public void popAll(){
        System.out.println("\nPop all item in stack: ");
        while (!isEmpty()){
            E data = pop();
            System.out.println("Removing data: " + data +" . .");
        }
        for (int i = 0; i < stack.length; i++) {
            stack[i] = null;
        }
    }
    
    public void display(){
        System.out.println("\nDisplay stack: ");
        for (int i = 0; i <= top; i++){
            System.out.println(stack[i]);
        }
    }
    
    public void displayInReverse(){
        System.out.println("\nDisplay stack in reverse: ");
        if(isEmpty()){
            for (int i = top + 1; i < stack.length; i++) {
                System.out.println("null");
            }
        }
        for (int i = top; i >= 0; i--){
            System.out.println(stack[i]);
        }  
    }
}
