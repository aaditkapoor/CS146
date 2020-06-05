// Josephus.java: Takes N and M from the command line and prints out the order 
// in which people are eliminated (and thus would show Josephus where to sit in 
// the circle).

import edu.princeton.cs.algs4.Queue;

public class Josephus {

    public static void main(String[] args) {
        int N = 0;
        int M = 0;

        // Checking command line arguments.
        try {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Command line arguments not given.");
        }

        if (N != 0 && M != 0) {
                Queue<Integer> queue = new Queue<Integer>();
                for (int i = 0; i < N; i++) {
                    queue.enqueue(i);
                }
                while (!queue.isEmpty()) {
                    for (int j = 0; j < M - 1; j++) {
                        queue.enqueue(queue.dequeue());
                    }
                    System.out.print(queue.dequeue());
                    System.out.print(" ");
            }
        }
    }
}
