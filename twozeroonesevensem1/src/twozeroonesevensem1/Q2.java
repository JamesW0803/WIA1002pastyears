/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twozeroonesevensem1;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue <Integer> queue = new Queue<>();
        int[]nums = {10,20,30,40,50,60,70,80,90};
        
        for (int i = 0; i < nums.length; i++){
            queue.enqueue(nums[i]);
        }
        System.out.println("Initial queue " + queue.toString());
        
        System.out.print("Enter the number, k: ");
        int num = sc.nextInt();
        queue.changeOrder(num);
        System.out.println("Updated queue: " + queue.toString());
        
    }
}

class Queue <Item> {
    private ArrayList <Item> queue;
    
    public Queue(){
        queue = new ArrayList<>();
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public int size(){
        return queue.size();
    }
    
    public Item peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        return queue.get(0);
    }
    
    public void enqueue(Item item){
        queue.add(item);
    }
    
    public Item dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        return queue.remove(0);
    }
    
    @Override
    public String toString(){
        return queue.toString();
    }
    
    public void changeOrder(int k){
        if (k < 1 || k > size()){
            throw new IllegalArgumentException("Invalid value of k");
        }
        for (int i = 0; i < k - 1; i++){
            Item item = dequeue();
            enqueue(item);
        }
    }
}
