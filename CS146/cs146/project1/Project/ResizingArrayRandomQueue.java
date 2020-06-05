import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Random queue implementation using a resizing array.
public class ResizingArrayRandomQueue<Item> implements Iterable<Item> {
    //CODE HERE
    
    // Construct an empty queue.
    public ResizingArrayRandomQueue() {
        //CODE HERE
    }

    // Is the queue empty?
    public boolean isEmpty() {
        //CODE HERE
    }

    // The number of items on the queue.
    public int size() {
        //CODE HERE
    }

    // Add item to the queue.
    public void enqueue(Item item) {
        //CODE HERE
    }

    // Remove and return a random item from the queue.
    public Item dequeue() {
        //CODE HERE
    }

    // Return a random item from the queue, but do not remove it.
    public Item sample() {
        //CODE HERE
    }

    // An independent iterator over items in the queue in random order.
    public Iterator<Item> iterator() {
        //CODE HERE
    }
    
    // An iterator, doesn't implement remove() since it's optional.
    private class RandomQueueIterator implements Iterator<Item> {
        //CODE HERE
        
        RandomQueueIterator() {
            //CODE HERE
        }
        
        public boolean hasNext()  { //CODE HERE }

        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            //CODE HERE
        }
    }

    // A string representation of the queue.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString().substring(0, s.length() - 1);
    }

    // Helper method for resizing the underlying array.
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            if (q[i] != null) {
                temp[i] = q[i];
            }
        }
        q = temp;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        ResizingArrayRandomQueue<Integer> q = 
            new ResizingArrayRandomQueue<Integer>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readInt());
        }
        int sum1 = 0;
        for (int x : q) {
            sum1 += x;
        }
        int sum2 = sum1;
        for (int x : q) {
            sum2 -= x;
        }
        int sum3 = 0;
        while (q.size() > 0) {
            sum3 += q.dequeue();
        }
        StdOut.println(sum1);
        StdOut.println(sum2);
        StdOut.println(sum3);
        StdOut.println(q.isEmpty());
    }
}
