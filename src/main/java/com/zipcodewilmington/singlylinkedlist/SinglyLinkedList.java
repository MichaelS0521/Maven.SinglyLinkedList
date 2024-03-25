package com.zipcodewilmington.singlylinkedlist;

import java.util.ArrayList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

    public class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node first;
    private Node last;
    private int num;

    public SinglyLinkedList() {
        first = null;
        last = null;
        num = 0;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public void add(T element) {
        if (element == null) {throw new NullPointerException();}

        if (!isEmpty()) {
            Node previous = last;
            last = new Node(element, null);
            previous.next = last;
        }else {
            last = new Node(element, null);
            first = last;
        }
        num++;
    }
    public void remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("The list is Empty, there is no elements to remove.");
        }
        Node tempNode = last;
        int currentIndex  = 0;
        while (tempNode != null) {
            if (currentIndex == index - 1) {
                tempNode.next = tempNode.next.next;
                num--;
                break;
            }
            currentIndex++;
        }

    }

    public boolean contains(T element) {
        if (isEmpty()) {
            throw new IllegalStateException("The list is Empty, there is no elements in this list.");
        }
        boolean containsElement = false;
        Node current = first;

        while (current.next != null || current == last) {
            if (current.data.equals(element)) {
                containsElement = true;
                break;
            } else {
                current = current.next;
            }
        }
        return containsElement;
    }

    public int find(T element) {
        int findElement = -1;
        Node current = first;

        while (current.next != null || current == last) {
            if (current.data.equals(element)) {
                findElement++;
                break;
            } else {
                findElement++;
                current = current.next;
            }
        }
        return findElement;
    }

    public int size() {
        return num;
    }

    public T get(int index) {
        T getElement = null;
        Node current = first;

        for (int i = 0; i < num; i++) {
            if (i == index) {
                getElement = current.data;
            } else {
                current = current.next;
            }
        }
        return getElement;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        Node current = first;

        while (current != null || current == last) {
            newList.add(current.data);
            current = current.next;
        }
        return newList;
    }

    public void sort() {
        try {
            Node index;
            Node current = first;
            T sort;

            if (first == null) {
                throw new IllegalStateException("The list is Empty, there are no elements to sort.");
            } else {
                while (current != null) {
                    index = current.next;

                    while (index != null) {
                        if ((int) current.data > (int) index.data) {
                            sort = current.data;
                            current.data = index.data;
                            index.data = sort;
                        }
                        index = index.next;
                    }
                    current = current.next;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException has been caught");
        }
    }
}
