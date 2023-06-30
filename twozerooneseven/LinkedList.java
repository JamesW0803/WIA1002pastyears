package twozerooneseven;

class Node{
    String brand;
    int sales;
    Node next;

    public Node(String brand, int sales){
        this.brand = brand;
        this.sales = sales;
        this.next = null;
    }
}
public class LinkedList {
    private Node head;
    public void insertFirstLink(String brand, int sales){
        Node newNode = new Node(brand, sales);
        newNode.next = head;
        head = newNode;
    }

    public void addAfter(String brand, String newBrand, int sales){
        Node currentNode = head;
        int position = 1;
        while (currentNode != null && !currentNode.brand.equals(brand)){
            currentNode = currentNode.next;
            position ++;
        }
        if (currentNode != null){
            System.out.println("Found" + brand + " which is handbag number " + position + " in the linked list");
            Node newNode = new Node(newBrand, sales);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }else{
            System.out.println(brand + " not found in the list. ");
        }
    }

    public void removeLink(String brand){
        Node current = head;
        Node previous = null;
        int position = 1;

        while (current != null & !current.brand.equals(brand)){
            previous = current;
            current = current.next;
            position ++;
        }

        if (current != null){
            if (previous == null){
                head = head.next;
            }else{
                previous.next = current.next;
            }
            System.out.println("Found a match.. " + brand + " is handbag number " + position + " in the linked list. ");
        }else{
            System.out.println(brand + " not found in the list. ");
        }
    }

    public void display(){
        Node current = head;
        while (current != null){
            System.out.println(current.brand + ": " + current.sales + " Sold");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirstLink("Tods", 500000000);
        list.insertFirstLink("Prada", 1000000);
        list.insertFirstLink("Chanel", 100000000);
        list.insertFirstLink("Louis Vuitton", 100000000);

        System.out.println("Diplaying the Linked List **************************************************************************");
        list.display();

        System.out.println("\nAdding Coach after Chanel");
        list.addAfter("Chanel", "Coach", 10000000);

        System.out.println("\nDisplaying the Linked List **************************************************************************");
        list.display();

        System.out.println("\nAdding Mulberry after Coach");
        list.addAfter("Coach", "Mulberry", 90000000);

        System.out.println("\nDisplaying the Linked List **************************************************************************");
        list.display();

        System.out.println("\nRemoving Chanel..");
        list.removeLink("Chanel");

        System.out.println("\nDisplaying the Linked List **************************************************************************");
        list.display();

        System.out.println("\nRemoving Coach..");
        list.removeLink("Coach");

        System.out.println("\nDisplaying the Linked List **************************************************************************");
        list.display();




    }

}
