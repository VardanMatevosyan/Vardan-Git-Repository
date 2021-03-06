package ru.matevosyan;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * EfficiencyListTest was created to test EfficiencyList class.
 * Created on 28.04.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class EfficiencyListTest {

    private static final int STRINGAMOUNT = 2000;
    private static final int STRINGTODELETE = 100;

    /**
     * whenAddThousandAndFiveToTreeSetThanReturnFive was created.
     * to test add and delete method to the treeSet and check how many.
     * was added and how many lines left.
     */

    @Test
    public void whenAddThousandAndFiveToTreeSetThanCheckLast() {

        //assign
        final String LN = System.getProperty("line.separator");
        Set<String> treeSet = new TreeSet<>();

        EfficiencyList efficiencyList = new EfficiencyList();

        //act
        System.out.printf("TreeSet%s", LN);

        long timeAddTeeSet = efficiencyList.add(treeSet, "treeSet", STRINGAMOUNT);
        int expectedTreeSet = treeSet.size();
        long timeRemoveTreeSet = efficiencyList.delete(treeSet, STRINGTODELETE);

        System.out.printf(String.format("Add time --- %s%sRemove time  --- %s%s", timeAddTeeSet, LN,
                timeRemoveTreeSet, LN));
        //assert
        assertThat(treeSet.size(), is(1900));
        assertThat(expectedTreeSet, is(STRINGAMOUNT));
    }

    /**
     * whenAddThousandAndFiveToArrayListThanCheckLast was created.
     * to test add and delete method to the arrayList and check how many.
     * was added and how many lines left.
     */

    @Test
    public void whenAddThousandAndFiveToArrayListThanCheckLast() {

        //assign
        final String LN = System.getProperty("line.separator");
        List<String> arrayList = new ArrayList<>();

        EfficiencyList efficiencyList = new EfficiencyList();

        //act
        System.out.printf("ArrayList%s", LN);

        long timeAddArray = efficiencyList.add(arrayList, "ArrayList", STRINGAMOUNT);
        int expectedArrayList = arrayList.size();
        long timeRemoveArray = efficiencyList.delete(arrayList, STRINGTODELETE);

        System.out.printf(String.format("Add time --- %s%sRemove time --- %s%s",
                timeAddArray, LN, timeRemoveArray, LN));

        //assert
        assertThat(arrayList.size(), is(1900));
        assertThat(expectedArrayList, is(STRINGAMOUNT));
    }

    /**
     * whenAddThousandAndFiveToLinkedListThanCheckLast was created.
     * to test add and delete method to the linkedList and check how many.
     * was added and how many lines left.
     */

    @Test
    public void whenAddThousandAndFiveToLinkedListThanCheckLast() {

        //assign
        final String LN = System.getProperty("line.separator");
        List<String> linkedList = new LinkedList<>();

        EfficiencyList efficiencyList = new EfficiencyList();

        //act
        System.out.printf("LinkedList%s", LN);

        long timeAddLinkedList = efficiencyList.add(linkedList, "Linked", STRINGAMOUNT);
        int expectedLinkedList = linkedList.size();
        long timeRemoveLinkedList = efficiencyList.delete(linkedList, STRINGTODELETE);

        System.out.print(String.format("Add time --- %s%sRemove time --- %s%s", timeAddLinkedList, LN,
                timeRemoveLinkedList, LN));

        //assert
        assertThat(linkedList.size(), is(1900));
        assertThat(expectedLinkedList, is(STRINGAMOUNT));
    }



}