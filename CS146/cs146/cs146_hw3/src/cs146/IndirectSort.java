package cs146;/*
@author: Aadit Kapoor
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class IndirectSort {
    // Is v < w?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // Exchange a[i] and a[j] (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // Indirectly sort a[] using insertion sort, ie, not by rearranging a[], 
    // but by returning an array perm[] such that perm[i] is the index of 
    // the ith smallest entry in a[].
    public static int[] indexSort(Comparable[] a) {

        // creating a new returned mutable array
        int perm[] = new int[a.length];

        // initialing perm
        for (int i = 0; i<a.length; i++) {
            // setting
            perm[i] = i;
        }

        for (int indexi = 1; indexi<perm.length; indexi++) {
            int indexj = indexi - 1;
            int key = perm[indexi];


            while (less(a[key], a[perm[indexj]]) && indexj > 0) {
                perm[indexj+1] = perm[indexj];
                indexj--;
            }

            perm[indexj+1] = key;
        }

        return perm;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int[] perm = indexSort(a);
        int i;
        for (i = 0; i < perm.length - 1; i++) {
            StdOut.print(a[perm[i]] + " ");
        }
        StdOut.println(a[perm[i]]);
    }
}
