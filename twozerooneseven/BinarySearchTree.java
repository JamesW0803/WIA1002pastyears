package twozerooneseven;

import java.util.Stack;

public class BinarySearchTree <E extends Comparable<E>>{
    public Node <E> root;

    private static class Node <E> {
        E data;
        Node <E> left;
        Node <E> right;

        Node (E data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public boolean add (Node <E> node, E item){
        if (node == null){
            root = new Node<>(item);
            return true;
        }

        int compare = item.compareTo(node.data);
        if (compare < 0){
            if (node.left == null){
                node.left = new Node <> (item);
                return true;
            }else{
                return add(node.left, item);
            }
        }else if (compare > 0){
            if (node.right == null){
                node.right = new Node <> (item);
                return true;
            }else{
                return add(node.right, item);
            }
        }else{
            return false;
        }
    }

    public void printTreeInOrder(){
        if (root == null){
            System.out.println("Tree is empty.");
            return;
        }

        Stack <Node <E>> stack = new Stack <> ();
        Node <E> current = root;

        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
            }
        }
    }

    public boolean contains(E item){
        Node <E> current = root;
        while (current != null){
            int compare = item.compareTo(current.data);
            if (compare == 0){
                return true;
            }else if (compare < 0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
}


//Tester class
class Main{
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(tree.root, 5);
        tree.add(tree.root, 3);
        tree.add(tree.root, 7);
        tree.add(tree.root, 2);
        tree.add(tree.root, 4);

        tree.printTreeInOrder();

        System.out.println("Does the tree contain number '5'? ");
        System.out.print(tree.contains(5));
        System.out.println("\nDoes the tree contain number '6'? ");
        System.out.print(tree.contains(6));
    }
}
