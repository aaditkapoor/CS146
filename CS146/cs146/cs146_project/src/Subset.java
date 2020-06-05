/*  CS146 Project One
    @author : Aarohi Chopra and Aadit Kapoor
    Date: 27 feb 2020
*/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Takes a command-line integer k; reads in a sequence of strings from 
// standard input; and prints out exactly k of them, uniformly at random. 
// Note that each item from the sequence is printed out at most once.
public class Subset {
    private static int k;

    public static void main(String[] args) {
        try {
            k = Integer.parseInt(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // creating resizing array random
        ResizingArrayRandomQueue<String> queue = new ResizingArrayRandomQueue<String>();
        while (StdIn.hasNextLine() && !StdIn.isEmpty()) {
            if (queue.size() == k) {
                break;
            }
            queue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.iterator().next());
        }
    }
}
