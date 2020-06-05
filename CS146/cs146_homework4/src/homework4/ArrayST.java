package homework4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayST<Key, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int N;

    // Create a symbol table with INIT_CAPACITY.
    public ArrayST() {
        this.keys = (Key[]) new Object[INIT_CAPACITY];
        this.values = (Value[]) new Object[INIT_CAPACITY];
        N = 0;
    }

    // Create a symbol table with given capacity.
    public ArrayST(int capacity) {
        this.keys = (Key[]) new Object[capacity];
        this.values = (Value[]) new Object[capacity];
        N = 0;
    }

    // Return the number of key-value pairs in the table.
    public int size() {
        return this.N;
    }

    // Return true if the table is empty and false otherwise.
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // Return true if the table contains key and false otherwise.
    public boolean contains(Key key) {
       return get(key) != null;
    }

    // Return the value associated with key, or null.
    public Value get(Key key) {
        for (int i = 0; i<N; i++) {
            if (keys[i].equals(key))
                return values[i];
        }
        return null;
    }

    // Put the kev-value pair into the table; remove key from table 
    // if value is null.
    public void put(Key key, Value value) {

        // if item is null then delete
        if (value == null) {
            delete(key);
        }

        // Resizing the array as the input length is greator than 2
        if (N >= values.length) {
            resize(4 * N);
        }

        if (contains(key)) {
            for (int i = 0; i < N; i++) {
                if (keys[i].equals(key)) {
                    values[i] = value;
                }
            }
        } else {
            values[N] = value;
            keys[N] = key;
            N++; // increment the size of the table
        }
    }

    // Remove key (and its value) from table.
    public void delete(Key key) {

        for (int i = 0; i < N; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[N-1];
                values[i] = values[N-1];
                keys[N-1] = null;
                values[N-1] = null;
                N--;
            }
        }
    }

    // Return all the keys in the table.
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < N; i++)
            queue.enqueue(keys[i]);
        return queue;
    }

    // Resize the internal arrays to capacity.
    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<String, Integer>(8);

        int count = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            st.put(s, ++count);
        }



        for (String s : args) {
            System.out.println(s);
            st.delete(s);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }

    }
}
