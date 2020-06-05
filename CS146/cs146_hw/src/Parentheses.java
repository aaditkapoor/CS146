import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
    Tokens ENUM representing all the tokens possible.
 */
enum Tokens {
    L_BRACKET('('),
    R_BRACKET(')'),

    L_BRACES('{'),
    R_BRACES('}'),

    L_SQUARE('['),
    R_SQUARE(']');

    // value of the ENUM
    private char value;

    /*
        Constructor
        @param value the value to be used
     */
    Tokens(char value) {
        this.value = value;
    }

    /*
       getValue()
       @returns the char value to be used
    */
    public char getValue() {
        return this.value;
    }
}


public class Parentheses {


    /*
            check if two character are the same.
            @param c Character one
            @param c2 Character two
            @returns equality
     */
    static boolean isPair(Character c, Character c2) {
        if (c == '(' && c2 == ')') {
            return true;
        }
        else if (c == '[' && c2 == ']') {
            return true;
        }
        else if (c == '{' && c2 == '}') {
            return true;
        }
        else {
            return false;
        }
    }

    // Return true if s has matching parentheses, and false otherwise.
    private static boolean match(String s) {

        Stack<Character> stack = new Stack<Character>();
        // iterating over string
        for (char ch: s.toCharArray()) {
           if (ch == Tokens.L_BRACES.getValue() || ch == Tokens.L_SQUARE.getValue() || ch == Tokens.L_BRACKET.getValue())
               stack.push(ch);

           // check for matching parentheses
            if (ch == Tokens.R_BRACKET.getValue()) {
                if (stack.isEmpty()) {
                    return false;
                }
                // if the last item of stack is not equal to ch then false.
                if (!isPair(stack.pop(), ch)) {
                    return false;
                }
            }

            if (ch == Tokens.R_SQUARE.getValue()) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isPair(stack.pop(), ch)) {
                    return false;
                }
            }

            if (ch == Tokens.R_BRACES.getValue()) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        // if stack is empty then character screening finished. If stack is not empty then there are unvalid parentheses.
        return stack.isEmpty();
    }
   
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        //Testing match
        //System.out.println(match("[()]{}{[()()]()}"));
        // press enter after inputting
        StdOut.println(match(StdIn.readAll().trim()));
    }
}
