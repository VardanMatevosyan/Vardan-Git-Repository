package ru.matevosyan;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * DynamicSetByLinkedListTest class for testing DynamicLinkedList class.
 * Created on 29.05.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class DynamicSetByLinkedListTest {

    /**
     * Create whenAddTwoElementsThanCheckOneOfThenGettingByIndex() method to check added element to the list.
     */

    @Test
    public void whenAddTwoElementsThanCheckOneGettingBtNext() {

        DynamicSetByLinkedList<Integer> integerDynamicLinkedList = new DynamicSetByLinkedList<>();

        integerDynamicLinkedList.add(12);
        integerDynamicLinkedList.add(42);

        Iterator<Integer> integerIterator = integerDynamicLinkedList.iterator();
        assertThat(integerIterator.next(), is(12));
        assertThat(integerIterator.next(), is(42));

    }

    /**
     * Create whenAddManyElementsThanCheckOrderIsNotTheSameBecauseOrderByHashcode() to check order is not save.
     */

    @Test
    public void whenAddManyElementsThanCheckOrderIsNotTheSameBecauseOrderByHashcode() {

        DynamicSetByLinkedList<Integer> integerDynamicLinkedList = new DynamicSetByLinkedList<>();

        integerDynamicLinkedList.add(12);
        integerDynamicLinkedList.add(12);
        integerDynamicLinkedList.add(3);
        integerDynamicLinkedList.add(8);
        integerDynamicLinkedList.add(0);
        integerDynamicLinkedList.add(9);
        integerDynamicLinkedList.add(123);
        integerDynamicLinkedList.add(22);



        Iterator<Integer> integerIterator = integerDynamicLinkedList.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

        assertThat(integerDynamicLinkedList.len(), is(7));

    }


    /**
     * Create whenInvokeNextMethodWithoutAddingTheValuesToLinkedListThanCheckWaitingForException to check an exception.
     */

    @Test
    public void whenInvokeNextMethodWithoutAddingTheValuesToLinkedListThanCheckWaitingForException() {

        Throwable e = null;

        try {
            DynamicSetByLinkedList<Integer> integerDynamicLinkedList = new DynamicSetByLinkedList<>();
            Iterator<Integer> itr = integerDynamicLinkedList.iterator();
            itr.next();
        } catch (Throwable ex) {
            e = ex;
        }

        assertTrue(e instanceof NoSuchElementException);
    }


    /**
     * Create whenGetIteratorFromLinkedListAndUseHasNextAndNextThanCheckTheGetResults() to check next method.
     * In {@link DynamicSetByLinkedList#iterator()}.
     */

    @Test
    public void whenGetIteratorFromLinkedListAndUseHasNextAndNextThanCheckTheGetResults() {
        DynamicSetByLinkedList<Integer> integerDynamicLinkedList = new DynamicSetByLinkedList<>();

        Iterator<Integer> itr = integerDynamicLinkedList.iterator();

        integerDynamicLinkedList.add(12);
        integerDynamicLinkedList.add(2);
        integerDynamicLinkedList.add(3);

        int value = 0;
        if (itr.hasNext()) {
            value = itr.next();
        }


        assertThat(value, is(2));
    }

    /**
     * Create whenInvokeHasNextThanCheckTheGetResultsIsGoingToBeTrue().
     * To check hasNext() in {@link DynamicSetByLinkedList#iterator()}.
     */

    @Test
    public void whenInvokeHasNextThanCheckTheGetResultsIsGoingToBeTrue() {
        DynamicSetByLinkedList<Integer> integerDynamicLinkedList = new DynamicSetByLinkedList<>();

        Iterator<Integer> itr = integerDynamicLinkedList.iterator();

        integerDynamicLinkedList.add(12);
        integerDynamicLinkedList.add(2);

        boolean has = itr.hasNext();

        assertThat(has, is(true));
    }

    /**
     * Create whenInvokeHasNextAndNextThanCheckTheGetResultsIsGoingToBeFalse() to check hasNext().
     * when in the LinkedList does not have any element and expected return false.
     */

    @Test
    public void whenInvokeHasNextAndNextThanCheckTheGetResultsIsGoingToBeFalse() {
        DynamicSetByLinkedList<Integer> integerDynamicLinkedList = new DynamicSetByLinkedList<>();

        Iterator<Integer> itr = integerDynamicLinkedList.iterator();

        integerDynamicLinkedList.add(12);
        integerDynamicLinkedList.add(2);

        itr.hasNext();
        int a = itr.next();
        int c = itr.next();
        boolean has = itr.hasNext();

        assertThat(has, is(false));
        assertThat(a, is(2));
        assertThat(c, is(12));

    }

    /**
     * Create whenAddManyDuplicateAndInvokeNextMoreTimesThanAddElementThanCheckNoSuchElementException().
     * to check NoSuchElementException, when invoke method next more times than element in the set.
     */

    @Test
    public void whenAddManyDuplicateAndInvokeNextMoreTimesThanAddElementThanCheckNoSuchElementException() {
        DynamicSetByLinkedList<Integer> integerDynamicLinkedList = new DynamicSetByLinkedList<>();

        Iterator<Integer> itr = integerDynamicLinkedList.iterator();

        integerDynamicLinkedList.add(12);
        integerDynamicLinkedList.add(2);
        integerDynamicLinkedList.add(2);
        integerDynamicLinkedList.add(2);
        integerDynamicLinkedList.add(2);
        integerDynamicLinkedList.add(2);
        Throwable ex = null;

        try {
            itr.next();
            itr.next();
            itr.next();

        } catch (Throwable e) {
            ex = e;
        }

        assertThat(integerDynamicLinkedList.len(), is(2));
        assertTrue(ex instanceof NoSuchElementException);

    }



}