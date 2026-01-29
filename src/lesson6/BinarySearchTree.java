package lesson6;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        private E data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
        }
    }
    private Node root;//similar to head

    public void add(E e){
        root = add(e, root);
    }

    public Node add(E e, Node currentNode){
        if (currentNode == null){
            return new Node(e);
        }
        int cmp = e.compareTo(currentNode.data);
        if (cmp < 0){
            currentNode.left =
                    add(
                            e,
                            currentNode.left//recursive call, where currentNode = currentNode.left
                    );
        }else if (cmp > 0){
            currentNode.right = add(e, currentNode.right);
        }
        return currentNode;
    }

    public void inorderTraversal(){
        if (root == null){
            System.out.println( "Tree is empty");
        }
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.left);
        IO.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(){
        if (root == null){
            IO.println( "Tree is empty");
        }
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node node){
        if (node == null){
            return;
        }
        IO.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public void postOrderTraversal(){
        if (root == null){
            IO.println( "Tree is empty");
        }
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node node){
        if (node == null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        IO.print(node.data + " ");
    }
    public E find(E target){
        if (root == null){
            return null;
        }
        return find(target, root);
    }

    private E find(E target, Node currentNode) {
        int cmp = target.compareTo(currentNode.data);
        if (cmp == 0){
            return currentNode.data;
        }else if (cmp < 0){
            return find(target, currentNode.left);
        }else {
            return find(target, currentNode.right);
        }
    }

    private E deleteReturn;
    public E delete(E target){
        deleteReturn = null;
        root = delete(root, target);
        return deleteReturn;
    }

    private Node delete(Node currentNode, E target){
        if (currentNode == null){
            return null;
        }
        int cmp = target.compareTo(currentNode.data);
        if (cmp < 0){
            currentNode.left = delete(currentNode.left, target);
        }else if (cmp > 0){
            currentNode.right = delete(currentNode.right, target);
        }else {
            //Found the data
            deleteReturn = currentNode.data;
            //with 0 or 1 child
            if (currentNode.left == null){
                return currentNode.right;
            }
            if (currentNode.right == null){
                return currentNode.left;
            }
            //with 2 children
            //Find successor of the node to be deleted
            Node successor = getSuccessor(currentNode.right);
            //Copy the content of successor to currentNode
            currentNode.data = successor.data;
            //Delete the successor node
            currentNode.right = delete(currentNode.right, successor.data);
        }
        return currentNode;
    }

    private Node getSuccessor(Node currentNode) {
        if (currentNode.left == null){
            return currentNode;
        }
        return getSuccessor(currentNode.left);
    }

}

class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.add(7);
        tree.add(8);
        tree.add(5);
        tree.add(6);
        tree.inorderTraversal();
        System.out.println();
        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
        System.out.println();
        if (tree.find(20) != null) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
        System.out.println("Delete element 15: " + tree.delete(15));
        System.out.println("Inorder traversal after deletion:");
        tree.inorderTraversal();

    }
}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
