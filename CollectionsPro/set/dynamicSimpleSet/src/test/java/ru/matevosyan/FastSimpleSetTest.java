package ru.matevosyan;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;


/**
 * FastSimpleSetTest class.
 * Created on 04.06.2017.
 * @author Matevosyan Vardan
 * @version 1.0
 */

public class FastSimpleSetTest {

    /**
     * Create whenCreateTwoObjectAndAddValuesThanCheckWhoAddedFasterToTheContainer() to check hwo is faster.
     */

    @Test public void whenCreateTwoObjectAndAddValuesThanCheckWhoAddedFasterToTheContainer() {
        FastSimpleSet<String> fastSimpleSet = new FastSimpleSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        long fastSetTimeBegin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            fastSimpleSet.add("one" + i);
        }

        long fastSetTimeEnd = System.currentTimeMillis();


        long dynamicSimpleSetTimeBegin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            treeSet.add("one" + i);
        }

        long dynamicSimpleSetTimeEnd = System.currentTimeMillis();

        long fastTime = fastSetTimeEnd - fastSetTimeBegin;
        long dynamicSimpleTime = dynamicSimpleSetTimeEnd - dynamicSimpleSetTimeBegin;
        System.out.println(fastTime + "fast");

        System.out.println(dynamicSimpleTime + "simple");
        assertTrue(fastTime < dynamicSimpleTime);


    }

    /**
     * whenCreateObjectAndAddValuesThanCheckSize to test array size.
     */

    @Test public void whenCreateObjectAndAddValuesThanCheckSize() {
        FastSimpleSet<Integer> fastSimpleSet = new FastSimpleSet<>();

        for (int i = 0; i < 30; i++) {
            fastSimpleSet.add(i);
        }

        assertThat(fastSimpleSet.get(1), is(1));
        assertThat(fastSimpleSet.get(20), is(20));

        assertThat(fastSimpleSet.getSize(), is(30));
    }

    /**
     * whenCreateObjddectAndAddValuesThanCheckSize for testing iterator and check size.
     * when insert duplicates.
     */

    @Test public void whenCreateObjddectAndAddValuesThanCheckSize() {
        FastSimpleSet<String> fastSimpleSet = new FastSimpleSet<>();


            fastSimpleSet.add("---qqqqqqqqqqqqqq");
            fastSimpleSet.add("---qqqqqqqqqqqqqq");
            fastSimpleSet.add("444ergw3grger");
            fastSimpleSet.add("papgerg34ga");
            fastSimpleSet.add("@gerge4g3g@@");
            fastSimpleSet.add(">ergerge>>");
            fastSimpleSet.add("~~~|rgerhrtj|ooo");
            fastSimpleSet.add("~~~|rgerhrtj|ooo");
            fastSimpleSet.add("~~~|rgerhrtj|ooo");
            fastSimpleSet.add("~~~|rgerhrtj|ooo");

        Iterator<String> itr = fastSimpleSet.iterator();

        while(itr.hasNext()) {
            String s = itr.next();
            System.out.println(s);
        }

        assertThat(fastSimpleSet.getSize(), is(6));
    }


}