package twozeroonesix;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    // i) Method add(int) to insert a new element into the linked list.
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Adding: " + data);
    }

    // ii) Method addAfter(int data, int key) to insert a new element after a particular element.
    public void addAfter(int data, int key) {
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Adding " + data + " after " + key);
        } else {
            System.out.println("Element " + key + " not found.");
        }
    }

    // iii) Method deleteFront() to delete the first element in the linked list.
    public void deleteFront() {
        if (head != null) {
            System.out.println("Deleting front: " + head.data);
            head = head.next;
        }
        System.out.println();
    }

    // iv) Method deleteAfter(int x) to delete an element after element with value x.
    public void deleteAfter(int x) {
        Node temp = head;
        while (temp != null && temp.data != x) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null) {
            System.out.println("Testing deleteAfter: ");
            System.out.println("After " + temp.data + " is " + temp.next.data + ". Deleting " + temp.next.data);
            System.out.println();
            temp.next = temp.next.next;
        } else {
            System.out.println("Testing deleteAfter: ");
            System.out.println("Element (" + x + ") not found or no element after it.");
            System.out.println();
        }
    }

    // v) Method traverse() to display all of the contents of the linked list.
    public void traverse() {
        System.out.println();
        System.out.print("Showing content of my linked list:\n");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
}

class LinkedListTest{
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
