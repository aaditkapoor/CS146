// KthString.java: Takes a command-line argument k and prints 
// the kth string from the end found on standard input, 
// assuming that standard input has k or more strings.

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stack;
import java.util.*;

/*
    implementing the readLine method instead of doing control+d.
 */

public class KthString {

    private static int K = 0;
    /*
        implements the kthstring algorithm using stack
        @param s the string
        @returns the kth string from K
     */
    /*
    static HashMap<Integer, String> kthStringStack(String s) {
        Stack<String> stack = new Stack<String>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int count = 0;

        // populate the stack
        String[] splitted = s.split(" ");
        for (String word : splitted) {
            stack.push(word);
        }


        while (!stack.isEmpty()) {
            map.put(count, stack.pop());
            count++;
        }

        return map;
    }
    */

    /*
        reverse the queue using stacks.
        @param queue the queue to be reversed
        @returns the reversed queue
     */
    static Queue<String> reverseQueue(Queue<String> queue) {
        Stack<String> stack = new Stack<String>();
        Queue<String> reversedQueue = new Queue<String>();
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            reversedQueue.enqueue(stack.pop());
        }
        return reversedQueue;
    }

    /*
       implements the kthstring algorithm using queue
       @param s the string
       @returns the kth string from K
    */
    static void kthStringQueue(int K,String s) {
        Queue<String> queue = new Queue<String>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int count = 0;

        // populate the queue
        String[] splitted = s.split(" ");
        for (String word : splitted) {
            queue.enqueue(word);
        }

        Queue<String> reversedQueue = reverseQueue(queue);
        while (!reversedQueue.isEmpty()) {
            map.put(count, reversedQueue.dequeue());
            count++;
        }

        if (map.containsKey(K)) {
            System.out.println("Kth String: " + map.get(K));
        } else {
            System.out.println("Not found! " + K + "th String");
        }
    }

    public static void main(String[] args) {
        try {
            K = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Please provide command line arguments: ");
        }

        // Get input
        System.out.print("Enter line and press Enter: ");
        String line = StdIn.readLine();
        // We could also use readAllString() or readAll()
        //HashMap<Integer, String> mapStack = kthStringStack(line);

        System.out.println("K: " + K);
        kthStringQueue(K, line);

    }
}
