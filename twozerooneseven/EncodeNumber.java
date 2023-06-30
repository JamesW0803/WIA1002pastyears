package twozerooneseven;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Queue<E> {
    private Object[] elements;
    private int size;

    public Queue (E [] items){
        elements = new Object [items.length];
        for (int i = 0; i < items.length; i++){
            enqueue(items[i]);
        }
    }

    public Queue(){
        elements = new Object[10];
    }

    public void enqueue(E e){
        if (size >= elements.length){
            Object [] temp = new Object [elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements [size ++] = e;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E element = (E) elements[0];
        System.arraycopy(elements, 1, elements, 0, --size);
        return element;
    }

    public E getElement(int i){
        if (i < 0 || i >= size){
            return null;
        }
        return (E) elements[i];
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: (" );
        for (int i = 0; i < size; i++){
            sb.append(elements[i]);
            if (i < size - 1){
                sb.append(", ");
            }
        }
        sb.append(") ");
        return sb.toString();
    }
}

public class EncodeNumber{
    public static void main(String[] args) {
        Character [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Queue <Character> alphabetQueue = new Queue <> (alphabet);
        System.out.println(alphabetQueue);
        System.out.print("Index: [");
        for (int i = 0; i < 27; i++){
            System.out.print(i);
            if (i < 26){
                System.out.print(", ");
            }
        }
        System.out.println("]\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("How many times will you enter a number: ");
        int times = sc.nextInt();
        System.out.println("(Please enter your number(s) between 0-26.)");

        int [] numbers = new int [times];
        for (int i = 0; i < times; i++){
            System.out.print("Enter number " + (i+1) + " >> ");
            numbers[i] = sc.nextInt();
        }

        StringBuilder deciphered = new StringBuilder();
        System.out.print("The entered numbers are [");
        for (int i = 0; i < times; i++){
            System.out.print(numbers[i]);
            if (i < times - 1){
                System.out.print(", ");
            }
            if (numbers[i] >= 0 && numbers[i] < 27){
                deciphered.append(alphabetQueue.getElement(numbers[i]));
            }
        }
        System.out.println("]\nThe deciphered values are " + (deciphered.length() > 0 ? deciphered.toString(): "- Cannot decipher. No value was entered. -"));
    }
}