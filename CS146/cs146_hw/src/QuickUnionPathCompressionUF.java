import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickUnionPathCompressionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with
     * n elements  0 through  n-1
     * Initially, each elements is in its own set.
     *
     * @param n the number of elements
     * @throws IllegalArgumentException if  n < 0
     */
    public QuickUnionPathCompressionUF(int n) throws IllegalArgumentException {
		// Add code here
        if ( n < 0)
            throw new IllegalArgumentException("N cannot be 0");

        this.id = new int[n];
        this.count = n;

        for (int i = 0; i<this.count; i++) {
            id[i] = i;
        }
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets
     */
    public int count() {
        return this.count;
	}

    /**
     * Returns the canonical element of the set containing element
     * Add two pass compression here
     */
    public int find(int p) {
		// Add code here with two pass compression
        int tempRoot = p;
        while (tempRoot != this.id[p])
            tempRoot = this.id[tempRoot];
        while (p != tempRoot) {
            int temp = this.id[p];
            id[p] = tempRoot;
            p = temp;
        }
        return tempRoot;
    }

    /**
     * Returns true if the two elements are in the same set.
     */
    public boolean connected(int p, int q) {
		// Add code here
        return find(p) == find(q);
	}

    /**
     * Merges the set containing element  p with the
     * the set containing element  q.
     */
    public void union(int p, int q) {
        int rootOfP = find(p);
        int rootOfQ = find(q);

        if (rootOfP == rootOfQ) {
        }
        else {
            this.id[rootOfP] = rootOfQ;
            this.count = count - 1;
        }
    }

    /**
     * Reads in a an integer n and a sequence of pairs of integers
     * (between 0 and  n-1) from standard input, where each integer
     * in the pair represents some element;
     * if the elements are in different sets, merge the two sets
     * and print the pair to standard output.
     *[DO NOT EDIT CODE IN MAIN]
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.elapsedTime();
        int n = StdIn.readInt();
        QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        System.out.println("Total elapsed time: " + stopwatch.elapsedTime());
    }

}

