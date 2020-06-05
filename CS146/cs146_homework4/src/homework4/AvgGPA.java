package homework4;// AvgGPA.java: Reads from standard input a list of letter grades and computes
// and prints the average GPA (the average of the numbers corresponding to
// the grades).

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AvgGPA {
    public static void main(String[] args) {
        ArrayST<String, Double> st = new ArrayST<String, Double>();

        // creating the table
        st.put("A",  4.00);
        st.put("B",  3.00);
        st.put("C",  2.00);
        st.put("D",  1.00);
        st.put("F",  0.00);
        st.put("A+", 4.33);
        st.put("B+", 3.33);
        st.put("C+", 2.33);
        st.put("A-", 3.67);
        st.put("B-", 2.67);

        double sum = 0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            String grade = StdIn.readString();

            double value = st.get(grade);
            sum+=value; // the total sum
            count++;
        }

        System.out.println(sum/count); // We can also access N from st




    }
}
