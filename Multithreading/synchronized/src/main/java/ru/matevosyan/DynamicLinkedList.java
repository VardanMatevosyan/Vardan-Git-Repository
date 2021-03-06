package ru.matevosyan;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicLinkedList class.
 * Created on 21.05.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 * @param <E> parametrize type.
 */

public class DynamicLinkedList<E> implements IDynamicLinkedList<E>, Iterable<E> {

    private Node<E> last;
    private int size = 0;
    private Node<E> first;

    /**
     * Constructor.
     */

    public DynamicLinkedList() {

    }

    /**
     * Create to add value to a list.
     * @param value is value that type which you declare in generics.
     */

    @Override
    public void add(E value) {
        linkLast(value);
    }


    /**
     * Create to get the value from list by index.
     * @param index position value in an array.
     * @return value that type that was declare in generic diamonds.
     * @throws IllegalArgumentException if is not correct index size.
     * @throws ArrayIndexOutOfBoundsException if index is bigger than actual.
     */

    @Override
    public E get(int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return node(index).item;
    }

    /**
     * method node begin search the element by index staring only by one side.
     * When the index less then half of size the start by the first element.
     * When the index doesn't less then start by from the last element.
     * @param index position in the list that hold the element.
     * @return elements value.
     */

    private Node<E> node(int index) {
        Node<E> entryNode;
        if (index < (size >> 1)) {
            entryNode = first;
            for (int i = 0; i < index; i++) {
                entryNode = entryNode.next;
            }
        } else {
            entryNode = last;
            for (int i = size - 1; i > index; i--) {
                entryNode = entryNode.prev;
            }
        }
        return entryNode;
    }

    /**
     * linkLast assign LinkedList Node to the last Node in the list and if it is the first value assign as first too.
     * @param elementValue is value.
     */

    private void linkLast(E elementValue) {
        Node<E> lastNode = last;
        Node<E> newNode = new Node<>(lastNode, elementValue, null);
        last = newNode;
        if (lastNode != null) {
            lastNode.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    /**
     * Class Node describe linkedList entry.
     * @param <E> parameter that defined when create an instance of a class.
     */

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        /**
         * Node represents element in the Linked list.
         * @param prev previous element.
         * @param element element itself with the value.
         * @param next next element.
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    /**
     * Override iterator method from interface Iterable.
     * @return an instance of Iterator type.
     */

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int count = 0;
            @Override
            public boolean hasNext() {
                return (count < size) && (last != null);
            }

            @Override
            public E next() {
                count++;
                Node<E> nextNode = first;

                if (nextNode != null && count > 1) {
                    nextNode = nextNode.next;
                }

                if (nextNode == null) {
                    throw new NoSuchElementException("Does not exist");
                }
                return nextNode.item;

            }
        };
    }
}