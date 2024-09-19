package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIterator {

  private List<Integer> list;
  private LinkedList<Integer> newList;
  // See the Java List Interface documentation to understand what all the List methods do ...

  @Before
  public void setUp() throws Exception {
    // list = new ArrayList<Integer>();
    list = new LinkedList<Integer>();
    // TODO - DONE - also try with a LinkedList - does it make any difference?
    // Answer = "No, all tests are still passing in both TestIterator and TestList
    //          whether it's an ArrayList or a LinkedList
  }

  @After
  public void tearDown() throws Exception {
    list = null;
  }

  @Test
  public void testEmpty() {
    final var i = list.iterator();
    assertFalse(i.hasNext());
  }

  @Test
  public void testNonempty() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    final var i = list.iterator();
    assertTrue(i.hasNext());
    assertEquals(33, i.next().intValue());
    // TODO  - DONE - fix the expected values in the assertions below
    assertTrue(i.hasNext());
    assertEquals(77, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(44, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(77, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(55, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(77, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(66, i.next().intValue());
    assertFalse(i.hasNext());
  }

  @Test
  public void testRemove() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    Iterator<Integer> i = list.iterator();

//    This is the one I had the most trouble with!!
//
//    Solution #1: Enhanced For loop to create a new list of items to remove from list
//    List<Integer> removeList = new ArrayList<>();
//    for (Integer num : list) {
//      if (num == 77) {
//        removeList.add(num);
//      }
//    }
//    list.removeAll(removeList);

//    # Solution #2: Use .removeIf() method from the Collections library w/ lambda expression (thanks StackOverflow)
//    list.removeIf(num -> num.equals(77)); // <--  Also works properly
//
//  Solution #3:
    while (i.hasNext()) {
      if (i.next() == 77) {
        // i.remove();
        i.remove();
        // TODO  - DONE - what happens if you use list.remove(Integer.valueOf(77))?
        // Answer: The test fails. I think it's because since i is already iterating through the list, directly calling
        // .remove() on the list object gives it no reference to what index i is currently on, so we instead need to call .remove() on i.
      }
    }

    assertEquals(List.of(33, 44, 55, 66), list);
    // TODO  - DONE - using assertEquals and List.of, express which values are left in the list
    // See TestList.java for examples of how to use List.of; also see the Java List
    // interface for more information
    // fail("Not yet implemented"); // remove this line when done
  }

  @Test
  public void testAverageValues() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    double sum = 0;
    int n = 0;
    // TODO - DONE - use an iterator and a while loop to compute the average (mean) of the values

    final var i = list.iterator();
    while (i.hasNext()) {
      sum += i.next();
      n++;
    }

    // (defined as the sum of the items divided by the number of items)
    // testNonempty shows how to use an iterator; use i.hasNext() in the while loop condition
    assertEquals(61.3, sum / n, 0.1);
    assertEquals(7, n);
  }
}
