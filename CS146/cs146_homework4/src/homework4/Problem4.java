package homework4;


import edu.princeton.cs.algs4.StdIn;

import java.util.*;

// Representation of a binary search tree
class Node {
        String item;      // node item
        Node left, right; // left and right subtrees

        // Construct a Node given its item.
        Node(String item) {
            this.item = item;
        }

        // Return a string representation of the node.
        public String toString() {
            return item;
        }
}

class BST {
    static public Node buildTree(String[] preorder, String[] inorder)
    {
        Set<Node> set = new HashSet<Node>();
        Stack<Node> stack = new Stack<Node>();

        Node root = null;

        // traversing the preorder
        for (int index = 0, in = 0; index < preorder.length;) {

            Node node = null;
            do {
                node = new Node(preorder[index]);
                if (root == null) {
                    root = node;
                }
                if (!stack.isEmpty()) {

                    // maintain the two levels
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    }
                    else {
                        stack.peek().left = node;
                    }
                }
                stack.push(node);
            } while (preorder[index++] != inorder[in] && index < preorder.length);

            node = null;
            while (!stack.isEmpty() && in < inorder.length &&
                    stack.peek().item == inorder[in]) {
                node = stack.pop();
                in++;
            }

            if (node != null) {
                set.add(node);
                stack.push(node);
            }
        }

        return root;
    }

    static public void postOrder(Node node)
    {
        if (node != null) {
            // L R R
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.item + " ");
        }

    }

}


public class Problem4 {

    /*

        [SOLUTION1]
        So to approach this problem we will first construct a bst from Inorder  and preOrder values and then print the its postOrder.
        To solve this as we know in InOrder the first root if left and in preOrder the first is Root so preorder gets us the root while in Order
        gets us the left most node.
        So we use two data structures hashset (to maintain where right tree is there ) and stack is maintain the route while travering preorder.
        this approach first builds the tree then prints the post order.


        [Solution 2]
        we can also print the post order as root is always first pre and last in post so we first print left, right then root.
     */

    // search in an array
    static int search(String array[], String item, int n)
    {
        for (int i = 0; i < n; i++)
            if (array[i].equals(item))
                return i; // found
        return -1; // not found
    }

    static void postOrder(String inOrder[],
                               String preOrder[], int n)
    {

        // the root
        int root = search(inOrder, preOrder[0], n);

       // printing left tree
        if (root != 0)
            postOrder(inOrder, Arrays.copyOfRange(preOrder, 1, n), root);

        // this is right tree
        if (root != n - 1)
            postOrder(Arrays.copyOfRange(inOrder, root+1, n),
                    Arrays.copyOfRange(preOrder, 1+root, n), n - root - 1);


        // first is root
        System.out.print( preOrder[0] + " ");
    }

    public static void main(String[] args) {

        String[] inOrder = StdIn.readLine().split(",");
        String[] preOrder = StdIn.readLine().split(",");

        /*
        int [] in = new int [inOrder.length];
        int [] pre = new int [preOrder.length];

        for(int i=0; i<in.length; i++) {
            in[i] = Integer.parseInt(inOrder[i]);
        }

        for(int i=0; i<pre.length; i++) {
            pre[i] = Integer.parseInt(preOrder[i]);
        }



        /*
        int[] inOrder = {4,2,5,1,3};
        int[] pre = {1,2,4,5,3};
*/
        int n = inOrder.length;

        postOrder(inOrder, preOrder, n);






    }
}
