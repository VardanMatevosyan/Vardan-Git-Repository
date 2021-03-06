package ru.matevosyan;

import java.util.Arrays;
import java.util.Iterator;

/**
 *  DynamicSimpleSet class.
 * Created on 27.05.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 * @param <E> type.
 */

public class  DynamicSimpleSet<E> implements IDynamicSimpleSet<E>,  Iterable<E> {

    private Object[] container;
    private static final int DEFAULTARRAYSIZE = 10;
    private int index = 0;

    private int size = 0;

    /**
     * If arrays size was not passed to constructor, create an array with default size.
     */

    public DynamicSimpleSet() {
        this.container = new Object[DEFAULTARRAYSIZE];
    }

    /**
     * Constructor for container.
     * @return container.
     */

    public Object[] getContainer() {
        return container;
    }

    /**
     * Constructor for container size.
     * @return size.
     */

    public int getSize() {
        return size;
    }

    /**
     * Getter for index.
     * @return index.
     */

    public int getIndex() {
        return index;
    }


    /**
     * Create to add value to an array.
     * @param value is value that type which you declare in generics.
     * @throws ArrayIndexOutOfBoundsException if index is bigger than actual.
     */

    @Override
    public void add(E value) throws ArrayIndexOutOfBoundsException {
        checkSize(this.index + 1);

        if (!checkDuplicate(value)) {
            this.container[this.index++] = value;
            size++;
        }
    }

    /**
     * Create checkDuplicate() method for check duplicate in the array.
     * @param value value that gonna be compare with element in an array.
     * @return true if container has duplicates.
     */

    public boolean checkDuplicate(E value) {
        boolean theSame = false;
        for (Object o : this.container) {
            if ((value.equals(o))) {
                theSame = true;
            }
        }
        return theSame;
    }

    /**
     * Check array size and rise it when an array length is equal or bigger that default size.
     * Or if it is the last index that going to be hold by passing value.
     * @param nextIndex is next index that going to be checked.
     */

    private void checkSize(int nextIndex) {
        if (this.container.length - 1 == nextIndex && this.container.length >= DEFAULTARRAYSIZE) {
            int nexSize = (this.container.length * 3) / 2 + 1;
            this.container = Arrays.copyOf(this.container, nexSize);
        }
    }

    /**
     * Create to get the value from an array.
     * @param index position value in an array.
     * @return value that type that was declare in generic diamonds.
     * @throws IllegalArgumentException if is not correct index size.
     * @throws ArrayIndexOutOfBoundsException if index is bigger than actual.
     */

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException("index id out of bounds");
        } else if (index < 0 && ((Integer) index instanceof Number)) {
           throw new IllegalArgumentException("illegal argument");
        } else {
            return  (E) this.container[index];
        }
    }

    /**
     * Size of an array.
     * @return set size.
     */

    @Override
    public int length() {
        return index;
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
                return count < container.length - (container.length - index);
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) container[count++];
            }
        };
    }

}