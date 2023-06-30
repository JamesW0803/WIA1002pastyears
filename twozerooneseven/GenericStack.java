package twozerooneseven;

import java.util.ArrayList;
import java.util.Scanner;

interface StackInterface <E> {
    ArrayList<E> getElements();
    int size();
    E peek();
    E pop();
    void push (E element);
    boolean isEmpty();
}
public class GenericStack <E> implements StackInterface <E>{
    private final ArrayList <E> elements;

    public GenericStack(){
        this.elements = new ArrayList<>();
    }

    @Override
    public ArrayList <E> getElements(){
        return elements;
    }

    @Override
    public int size(){
        return elements.size();
    }

    @Override
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return elements.get(0);
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        return elements.remove(0);
    }

    @Override
    public void push(E element){
        elements.add(0, element);
    }

    @Override
    public boolean isEmpty(){
        return elements.isEmpty();
    }

    @Override
    public String toString(){
        return elements.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Create a new stack: an empty pile of books");
        StackInterface <String> bookPile = new GenericStack<>();
        System.out.println("isEmpty() returns " + bookPile.isEmpty());
        System.out.println();

        System.out.println("Push 3 books to the pile:");
        for (int i = 1; i <= 3; i++){
            System.out.print("Enter book title " + i + ": ");
            String title = sc.nextLine();
            bookPile.push(title);
        }

        System.out.println();
        System.out.println("The new books that you added are: " + bookPile.getElements());
        System.out.println();

        System.out.println("The pile should not be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());
        System.out.println("The pile has " + bookPile.size() + " books.");
        System.out.println();

        System.out.println("Get the top book and remove the top book:");
        System.out.println();
        while (!bookPile.isEmpty()) {
            String topBook = bookPile.peek();
            System.out.println(topBook + " is at the top of the pile.");
            String removedBook = bookPile.pop();
            System.out.println(removedBook + " is removed from the pile.");
            System.out.println();
        }

        System.out.println("The pile should be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());

        sc.close();
    }
}
