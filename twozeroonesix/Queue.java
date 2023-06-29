package twozeroonesix;

import java.util.LinkedList;
public class Queue<Item> {
    private LinkedList <Item> queue;

    public Queue(){
        queue = new LinkedList<>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }

    public Item peek(){
        if(isEmpty()){
            return null;
        }
        return queue.getFirst();
    }

    public void enqueue(Item item){
        queue.addLast(item);
    }

    public Item dequeue(){
        if(isEmpty()){
            return null;
        }
        return queue.removeFirst();
    }

    public String toString(){
        return queue.toString();
    }

    public void changeOrder(int k){
        if (k <= 0 || k > size()){
            System.out.println("Invalid value of k. ");
            return;
        }
        for (int i = 1; i < k; i++){
            enqueue(dequeue());
        }
    }
}

class QueueTester{
    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>();

        int [] values = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        for (int value : values){
            myQueue.enqueue(value);
        }

        System.out.println("Queue before change order: " + myQueue.toString());

        myQueue.changeOrder(4);
        System.out.println("Queue after change order: " + myQueue.toString());
    }
}


