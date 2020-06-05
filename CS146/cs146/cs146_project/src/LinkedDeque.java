/*  CS146 Project One
    @author : Aarohi Chopra and Aadit Kapoor
    Date: 27 feb 2020
*/
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Deque implementation using a linked list.
public class LinkedDeque<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;

    // Helper doubly-linked list class.
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // Construct an empty deque.
    public LinkedDeque() {
        first = null;
        last = null;
        n = 0;
    }

    // Is the dequeue empty?
    public boolean isEmpty() {
            return n == 0;
    }

    // The number of items on the deque.
    public int size() {
        return n;
    }

    // Add item to the front of the deque.
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException("item is null! Cannot add to the Deque.");
        if (first == null && last ==  null) {
            first = new Node();
            first.item = item;
            first.next = null;
            first.prev = null;
            last = first;
        } else {
            Node newNode = new Node();
            newNode.item = item;
            newNode.next = first;
            newNode.prev = null;
            first = newNode;
        }
        n++;
    }

    // Add item to the end of the deque.
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException("item is null! Cannot add to the Deque.");
        if (first == null && last ==  null) {
            first = new Node();
            first.item = item;
            first.next = null;
            first.prev = null;
            last = first;
        } else {
            Node node = new Node();
            node.prev = last;
            node.item = item;
            node.next = null;
            last.next = node;
            last = node;
        }
        n++;

    }

    // Remove and return item from the front of the deque.
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty!");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;
        return item;
    }

    // Remove and return item from the end of the deque.
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty!");

        Item item = last.item;
        last = last.prev;

        if (last == null) {
            last = first;
        }
        else
            last.next = null;

        if (isEmpty())
            last = null;

        n--;
        return item;
    }

    // An iterator over items in the queue in order from front to end.
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // An iterator, doesn't implement remove() since it's optional.
    private class DequeIterator implements Iterator<Item> {
        private Node current;

        DequeIterator() {
            current = first;
        }

        public boolean hasNext()  {
           return current == null;
        }

        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // A string representation of the deque.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString().substring(0, s.length() - 1);
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        LinkedDeque<Character> deque = new LinkedDeque<Character>();
        String quote = "There is grandeur in this view of life, with its "
                + "several powers, having been originally breathed into a few "
                + "forms or into one; and that, whilst this planet has gone "
                + "cycling on according to the fixed law of gravity, from so "
                + "simple a beginning endless forms most beautiful and most "
                + "wonderful have been, and are being, evolved. ~ "
                + "Charles Darwin, The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.println(deque.isEmpty());
        StdOut.printf("(%d characters) ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            }
            else {
                deque.removeLast();
            }
        }
        StdOut.println(deque.isEmpty());
    }
}
