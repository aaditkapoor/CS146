import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickUnionUF {
    private int[] parent;  // parent[i] = parent of i
    private int count;     // number of components

    /**
     * Initializes an empty union-find data structure with
     * {@code n} elements {@code 0} through {@code n-1}.
     * Initially, each elements is in its own set.
     *
     * @param n the number of elements
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public QuickUnionUF(int n) throws IllegalArgumentException {
		// Add code here
        if (n < 0)
            throw new IllegalArgumentException("n < 0");

        this.parent = new int[n]; this.count = n;
        for (int i = 0; i < this.count; i++) {
            this.parent[i] = i;
        }
    }

    /**
     * Returns the number of sets.
     */
    public int count() {
		// Add code here
        return count;
    }

    /**
     * Returns the canonical element of the set containing element {@code p}.
     *
     * @param p an element
     * @return the canonical element of the set containing {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) throws IllegalArgumentException {
		// Add code here
        // or n
        if (p < 0 || p >= this.parent.length) {
            throw new IllegalArgumentException("p < 0 || p >= this.parent.length");
        }
            while (p != this.parent[p]) {
                p = this.parent[p];
            }
            return p;
    }

    /**
     * Returns true if the two elements are in the same set.
     */
    public boolean connected(int p, int q) {
		// Add code here
        return find(p) == find(q);
    }

    /**
     * Merges the set containing element p with the
     * the set containing element  q.
     **/
    public void union(int p, int q) {
        int rootOfP = find(p); int rootOfQ = find(q);

        if (rootOfP == rootOfQ) {
            // same starting point
        }
        else {
            this.parent[rootOfP] = rootOfQ;
            this.count = this.count - 1;
        }

    }

    /**
     * Reads in a an integer and a sequence of pairs of integers
     * from standard input, where each integer
     * in the pair represents some element;
     * if the elements are in different sets, merge the two sets
     * and print the pair to standard output.
     [DO NOT CHANGE CODE IN MAIN]*/
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.elapsedTime();
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
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
