/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twozerooneeight;

/**
 *
 * @author User
 */

import java.util.ArrayList;

public class Q2 {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        
        q.enqueue("hello");
        q.enqueue("all");
        q.enqueue("who");
        q.enqueue("wants");
        q.enqueue("ice cream");
        
        q.dequeue();
        q.dequeue();
        
        q.enqueue("1000");
        q.enqueue("2000");

        q.peek();
        
        q.display();
    }
}

class Queue {
    private String[] queue;
    private int size;
    private int front;
    private int rear;
    
    public Queue(int capacity){
        size = 0;
        queue = new String[capacity];
        front = 0;
        rear = -1;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public String peek(){
        if (isEmpty()){
            return "Queue is Empty!";
        }
        System.out.println("Peek(): " + queue[front]);
        return queue[front];
    }
    
    public void enqueue(String data){
        if (size == queue.length){
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
        size ++;
        System.out.println("Data " + data + "  inserted");
    }
    
    public void dequeue(){
        if (isEmpty()){
            System.out.println("Queue is Empty!");
            return;
        }
        String data = queue[front];
        front = (front + 1) % queue.length;
        size--;
        System.out.println("Data " + data + "  has been removed");
    }
    
    public void display() {
        System.out.println("----------------------------------------------------------------");
        System.out.print("|");
        for (int i = 0; i < queue.length; i++) {
            System.out.printf("  %-3d |", i);
        }
        System.out.println("\n---------------------------------------------------------------");
        System.out.print("|");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.printf("    %-5s |", queue[index]);
        }
        System.out.println("\n---------------------------------------------------------------");
    }
}
