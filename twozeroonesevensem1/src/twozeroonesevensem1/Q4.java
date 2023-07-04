/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twozeroonesevensem1;

/**
 *
 * @author User
 */
public class Q4 {
    public static void main(String[] args) {
        LinkedList s1 = new LinkedList();
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        s1.addAfter(11,10);
        s1.addAfter(21,20);
        s1.addAfter(31,30);
        s1.addAfter(41,40);
        s1.addAfter(51,50);
        s1.traverse();
        s1.deleteFront();
        s1.deleteFront();
        s1.traverse();
        s1.deleteAfter(40);
        s1.deleteAfter(40);
        s1.deleteAfter(31);
        s1.deleteAfter(40);
        s1.traverse();
    }
}

class Node{
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    private Node head;
    
    public void add(int data){
        Node newNode = new Node (data);
        if (head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Adding: " + data);
    }
    
    public void addAfter (int data, int key){
        Node temp = head;
        while (temp != null && temp.data != key){
            temp = temp.next;
        }
        if (temp != null){
            Node newNode = new Node (data);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Adding " + data + " after " + key);
        }else{
            System.out.println("Element " + key + " not found.");
        }
    }
    
    public void deleteFront(){
        if (head != null){
            System.out.println("Deleting front: " + head.data);
            head = head.next;
        }
        System.out.println();
    }
    
    public void deleteAfter(int x){
        Node temp = head;
        while (temp != null && temp.data != x){
            temp = temp.next;
        }
        if (temp != null && temp.next != null){
            System.out.println("Testing deleteAfter: ");
            System.out.println("After " + temp.data + " is " + temp.next.data + ". Deleting " + temp.next.data);
            System.out.println();
            temp.next = temp.next.next;
        }else{
            System.out.println("Testing deleteAfer: ");
            System.out.println("Element (" + x + ") not found or no element after it. " );
            System.out.println();
        }
    }
    
    public void traverse(){
        System.out.println();
        System.out.print("Showing content of my linked list:\n");
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    
}


