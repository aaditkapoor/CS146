package homework4;// FrequencyCounter.java: Reads in a command-line integer and sequence of words
// from standard input and prints out all the words (whose length exceeds the
// threshold) that occur most frequently to standard output. It also prints out
// the number of words whose length exceeds the threshold and the number of
// distinct such words.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

class ProgramST<Key, Value> {
    private ArrayST<String, Integer> st;
    int distinct;
    int words;
    int argument;

    public ProgramST(ArrayST<String, Integer> st, int argument) {
        this.st = st;
        this.argument = argument;
    }

    public void compute() {
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();

            // if the length of key is less than argument then skip the loop
            if (key.length() < argument)
                continue;

            words++;

            if (st.contains(key)) {
                st.put(key, st.get(key) + 1); // increment each counter of the found
            }
            else {

                st.put(key, 1); // occured once
                distinct++; // increment distinct
            }
        }
    }

    // get the distinct value
    public int getDistinct() {
        return this.distinct;
    }

    public int getWords() {
        return this.words;
    }

    public int max() {
        String empty = "";
        st.put(empty, 0); // get the empty
        for (String key: st.keys()) {
            if (key.length() > argument) {
                if (st.get(key) > st.get(empty)) {
                    empty = key;
                }
            }
        }

        return st.get(empty); // the max count
    }

    public String maxWord() {
        String empty = "";
        st.put(empty, 0); // get the empty
        for (String key: st.keys()) {
            if (st.get(key) > st.get(empty)) {
                empty = key;
            }
        }

        return empty; // the max count
    }

}


public class FrequencyCounter {
    public static void main(String[] args) {

        int threshold;


        try {
            threshold = Integer.parseInt(args[0]);
        }
        catch(Exception e) {
            e.printStackTrace();
            threshold = 2; // default

        }

        // Initialize everything
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();

        ProgramST<String, Integer> pt = new ProgramST<String, Integer>(st, threshold);
        pt.compute();


        System.out.println("Max occuring word: " + pt.maxWord() + " " + pt.max());
        System.out.println("distinct: " + pt.getDistinct());
        System.out.println("words: " + pt.getWords());

        TreeSet<String> set = new TreeSet<String>();
        for (String key: st.keys()) {
            if (key.length() > threshold) {
                set.add(key);
            }
        }

        System.out.println("Distinct words whose length is greater than threshold value: " + set.size());
        System.out.println("");
        System.out.println("Showing symbol table with frequencies: ");
        for (String key: st.keys()) {
           System.out.println("key = " + key + " value= " + st.get(key));
        }

        // to get the first occurence either store the first found value and break or we can sort according to our requirements.








    }
}
