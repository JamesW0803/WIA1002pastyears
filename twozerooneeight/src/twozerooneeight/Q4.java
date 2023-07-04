/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twozerooneeight;

/**
 *
 * @author User
 */
public class Q4 {
    public static void main(String[] args) {
        LList list = new LList();
        
        list.add("Computing Mathematics 1", 3);
        list.add("Principles of AI", 3);
        list.add("Programming 1", 5);
        list.add("Data Structure", 5);
        list.display();
        list.totalCreditHours();
        list.addAfter("Programming 1", "Software Architecture", 4);
        list.addAfter("Software Architecture", "Networking", 4);
        list.display();
        list.totalCreditHours();
        list.remove("Networking", 4);
        list.display();
        
        list.remove("Principles of AI", 3);
        list.display();
        list.totalCreditHours();
    }
}

class Node{
    String book;
    int hours;
    Node next;
    
    public Node(String book, int hours){
        this.book = book;
        this.hours = hours;
        this.next = null;
    }
}

class LList{
    private Node head;
    
    public LList(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void add(String book, int hours){
        Node newNode = new Node(book, hours);
        if (isEmpty()){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        
    }
    
    public void addAfter(String targetBook, String newBook, int hours){
        Node current = head;
        int bookNum = 0;
        while (current != null){
            if(current.book.equals(targetBook)){
                Node newNode = new Node (newBook, hours);
                newNode.next = current.next;
                current.next = newNode;
                System.out.println("Adding " + newBook + " after " + targetBook);
                System.out.println("Found " + targetBook + " which is book number " + bookNum + " in the linked list");
                return;
            }
            current = current.next;
            bookNum ++;
        }
        System.out.println(targetBook + " not found in the linked list");
    }
    
    public void remove(String book, int hours){
        if (isEmpty()){
            System.out.println("Linked list is Empty!");
            return;
        }
        if (head.book.equals(book) && head.hours == hours){
            head = head.next;
            System.out.println("Removing book " + "...");
            System.out.println("Found a match..." + book + " is book number 1 in the linked list");
            return;
        }
        Node current = head;
        Node prev = null;
        int bookNum = 0;
        while (current != null){
            if(current.book.equals(book) && current.hours == hours){
                prev.next = current.next;
                System.out.println("Removing " + book + "...");
                System.out.println("Found a match..." + book + " is book number " + bookNum + " in the linked list");
                return;
            }
            prev = current;
            current = current.next;
            bookNum++;
        }
        System.out.println(book + " not found in the linked list");
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("Linked list is empty");
            return;
        }
        System.out.println("\nDisplaying the Linked List ************************************************");
        Node current = head;
        while (current != null){
            System.out.println(current.book + ": " + current.hours + " hours");
            current = current.next;
        }
    }
    
    public void totalCreditHours(){
        int totalHours = 0;
        Node current = head;
        while (current != null){
            totalHours += current.hours;
            current = current.next;
        }
        System.out.println("Total credit hours taken: " + totalHours);
    }
}
