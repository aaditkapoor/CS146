import edu.princeton.cs.algs4.StdOut;

/*
    A data type representing a six-sided die.
    @author Aadit Kapoor

 */

/*
    DiceMaker that represents the face value of a dice.
 */

class FORMATS {
    public static String NEWLINE = "\n";
    public static String TAB = "\t";
    public static String SPACE = " ";
    public static String DOT = "*";
    public static String EMPTY = "";
}

class DiceMaker {
    private int value;

    static String returnDieValue(int value) {
        String output = "";
        switch (value) {
            case 1:
                output = FORMATS.SPACE + FORMATS.DOT + FORMATS.SPACE;
                break;
            case 2:
                output = FORMATS.DOT + FORMATS.NEWLINE + FORMATS.TAB + FORMATS.DOT;
                break;
            case 3:
                output = FORMATS.DOT + FORMATS.NEWLINE + FORMATS.TAB + FORMATS.DOT + FORMATS.NEWLINE + FORMATS.TAB + FORMATS.TAB + FORMATS.DOT;
                break;
            case 4:
                output = FORMATS.DOT + FORMATS.TAB + FORMATS.DOT + FORMATS.NEWLINE + FORMATS.DOT + FORMATS.TAB + FORMATS.DOT;
                break;
            case 5:
                output = FORMATS.DOT + FORMATS.TAB + FORMATS.DOT + FORMATS.NEWLINE + FORMATS.TAB + FORMATS.DOT + FORMATS.TAB + FORMATS.NEWLINE + FORMATS.DOT + FORMATS.TAB + FORMATS.DOT;
                break;
            case 6:
                output = FORMATS.DOT + FORMATS.TAB + FORMATS.DOT + FORMATS.TAB + FORMATS.DOT + FORMATS.NEWLINE + FORMATS.NEWLINE + FORMATS.DOT + FORMATS.TAB + FORMATS.DOT + FORMATS.TAB + FORMATS.DOT;
                break;

        }
        return output;
    }
}


public class Die implements Comparable<Die> {
    private int value; // face value
    private int faceValue;
    public final int MAX_VALUE = 6;

    public Die() {
        this.value = 0;
    }

    // Roll the die.
    public void roll() {
        this.value = (int) (Math.random() * MAX_VALUE ) + 1;

        this.faceValue = this.value;
    }

    // Face value of the die.
    public int value() {
        return this.faceValue;
    }

    // Does the die have the same face value as that?
    public boolean equals(Die that) {
        return this.compareTo(that) == 0;
    }

    // A negative integer, zero, or positive integer depending on whether this
    // die's value is less than, equal to, or greater than the that die's value.
    public int compareTo(Die that) {
        Integer x = (Integer)this.faceValue;
        Integer y = (Integer)that.faceValue;

        return x.compareTo(y);
    }

    // A string representation of the die giving the current face value.
    public String toString() {
        return DiceMaker.returnDieValue(this.faceValue);
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        Die a = new Die();
        a.roll();
        while (a.value() != x) {
            a.roll();
        }
        Die b = new Die();        
        b.roll();
        while (b.value() != y) {
            b.roll();
        }
        Die c = new Die();        
        c.roll();
        while (c.value() != z) {
            c.roll();
        }

        StdOut.println(a);
        StdOut.println(a.equals(b));
        StdOut.println(b.equals(c));        
        StdOut.println(a.compareTo(b));
        StdOut.println(b.compareTo(c));        
    }
}
