import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCases {
    @Test
    public void test1() {
        LinkedDeque<Integer> q = new LinkedDeque<Integer>();
        q.addFirst(2);
        q.addLast(5);
        assertEquals(2, q.size());
    }

    @Test
    public void test2() {
        LinkedDeque<Integer> empty = new LinkedDeque<Integer>();
        assertTrue(empty.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void test3() {
        LinkedDeque<Integer> nullInsert = new LinkedDeque<Integer>();
        nullInsert.addFirst(null);
    }

    @Test
    public void test4() {
        LinkedDeque<Integer> q = new LinkedDeque<Integer>();
        q.addFirst(2);
        q.addFirst(1);
        q.addLast(3);
        q.addLast(4);

        for (int i = 1; i < 5; i++) {
            assertEquals(i, q.removeFirst().intValue());
        }
    }

    @Test
    public void test5() {
        ResizingArrayRandomQueue<Integer> empty = new ResizingArrayRandomQueue<Integer>();
        assertTrue(empty.isEmpty());
    }


}
