/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package twozeroonesevensem1;

/**
 *
 * @author User
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStack<Integer> start = new MyStack<>();
        MyStack<Integer> middle = new MyStack<>();
        MyStack<Integer> destination = new MyStack<>();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of disks: ");
        int n = sc.nextInt();
        for (int i = n; i > 0; i--){
            start.push(i);
        }

        towerOfHanoi(n, start, destination, middle);
    }

    public static void towerOfHanoi(int n, MyStack<Integer>start, MyStack<Integer>destination, MyStack<Integer>middle){
        if (n == 1) {
            int disk = start.pop();
            destination.push(disk);
            System.out.println("Move disk " + disk + " from " + start + " to " + destination);
            return;
        }

        towerOfHanoi(n-1, start, middle, destination);

        int disk = start.pop();
        destination.push(disk);
        System.out.println("Move disk " + disk + " from " + start + " to " + destination);

        towerOfHanoi(n-1, middle, destination, start);
    }
}

class MyStack <E> {
    private ArrayList <E> list = new ArrayList<>();

    public int getSize(){
        return list.size();
    }

    public E peek(){
        return list.get(getSize() - 1);
    }

    public void push(E e){
        list.add(e);
    }

    public E pop(){
        E e = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return e;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }

    public boolean search(E e){
        return list.contains(e);
    }
}
