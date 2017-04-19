package mycode.test;

import com.bedpotato.alg4.ST;
import com.bedpotato.alg4.utils.StdIn;
import com.bedpotato.alg4.utils.StdOut;
import mycode.searching.IBinarySearchTree;
import mycode.searching.NonrecursiveBST;
import mycode.searching.RedBlackBST;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.bedpotato.alg4.constants.Alg4Constants.DATA_PATH;
import static mycode.searching.BaseBST.BLACK;
import static mycode.searching.BaseBST.RED;
import static org.junit.Assert.assertEquals;

/**
 * Created by Shin on 2017/4/13.
 */
public class SearchingTestCase {

    private IBinarySearchTree<String, Integer> bst;

    @Before
    public void setUp() {
        String S = "SEARCHEXAMPLE";
        String[] cs = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            cs[i] = String.valueOf(S.charAt(i));
        }
        bst = new NonrecursiveBST<>();
        for (int i = 0; i < cs.length; i++) {
            bst.put(cs[i], i);
        }
    }

    @Test
    public void testBST_REDBLACKTREE() {

        String S = "SEARCHXMPL";
        String[] cs = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            cs[i] = String.valueOf(S.charAt(i));
        }
        RedBlackBST<String, Integer> rbt = new RedBlackBST<>();
        for (int i = 0; i < cs.length; i++) {
            rbt.put(cs[i], i);
        }
        //删除A
        rbt.deleteMin();

        assertEquals("E", rbt.getNode("M").getLeft().getKey());
        assertEquals("R", rbt.getNode("M").getRight().getKey());
        assertEquals("C", rbt.getNode("E").getLeft().getKey());
        assertEquals("L", rbt.getNode("E").getRight().getKey());

        //删除C
        rbt.deleteMin();

        assertEquals("H", rbt.getNode("M").getLeft().getKey());
        assertEquals("E", rbt.getNode("H").getLeft().getKey());
        assertEquals("L", rbt.getNode("H").getRight().getKey());
        assertEquals(null, rbt.getNode("E").getLeft());
        assertEquals(BLACK, rbt.getNode("E").isColor());
        assertEquals(BLACK, rbt.getNode("L").isColor());

        //删除E
        rbt.deleteMin();

        assertEquals("M", rbt.getNode("R").getLeft().getKey());
        assertEquals("X", rbt.getNode("R").getRight().getKey());
        assertEquals("L", rbt.getNode("M").getLeft().getKey());
        assertEquals("P", rbt.getNode("M").getRight().getKey());
        assertEquals(RED, rbt.getNode("M").isColor());
        assertEquals("H", rbt.getNode("L").getLeft().getKey());
        assertEquals(null, rbt.getNode("L").getRight());
        assertEquals(BLACK, rbt.getNode("L").isColor());
        assertEquals(RED, rbt.getNode("H").isColor());

        //删除H
        rbt.deleteMin();
        //删除L
        rbt.deleteMin();
        assertEquals("P", rbt.getNode("R").getLeft().getKey());
        assertEquals("X", rbt.getNode("R").getRight().getKey());
        assertEquals("M", rbt.getNode("P").getLeft().getKey());
        assertEquals(null, rbt.getNode("P").getRight());
        assertEquals(BLACK, rbt.getNode("P").isColor());
        assertEquals(RED, rbt.getNode("M").isColor());

    }

    @Test
    public void testBST_Traversal() {
//        bst.traversalFront();
//        bst.traversalMid();
//        bst.traversalBack();
//        bst.traversalLevel();

        assertEquals(5, bst.height());
    }

    @Test
    public void testBST_Delete() {
        System.out.println(bst.min());
        System.out.println(bst.max());

        //bst.deleteMin();
        //Assert.assertEquals("C", bst.min());
        //bst.deleteMax();
        //Assert.assertEquals("S", bst.max());

        //bst.delete("C");
        //Assert.assertEquals("A", bst.min());
        bst.delete("E");
        System.out.println();
    }

    @Test
    public void checkBST() {
        bst.traversalMid();
    }


    @Test
    public void testBST() {

        System.out.println(bst.min());
        System.out.println(bst.max());
//        Assert.assertEquals(null, bst.floor(String.valueOf((char)('A' - 1))));
        assertEquals("A", bst.floor("A"));
        assertEquals("A", bst.floor("B"));
        assertEquals("C", bst.floor("C"));
        assertEquals("C", bst.floor("D"));
        assertEquals("E", bst.floor("E"));
        assertEquals("E", bst.floor("F"));
        assertEquals("E", bst.floor("G"));
        assertEquals("H", bst.floor("H"));
        assertEquals("H", bst.floor("I"));
        assertEquals("H", bst.floor("J"));
        assertEquals("H", bst.floor("K"));
        assertEquals("S", bst.floor("S"));
        assertEquals("S", bst.floor("T"));
        assertEquals("X", bst.floor("X"));
        assertEquals("X", bst.floor("Y"));

        assertEquals(null, bst.ceiling(String.valueOf((char)('X' + 1))));
        assertEquals("A", bst.ceiling("A"));

        assertEquals("C", bst.ceiling("B"));
        assertEquals("H", bst.ceiling("G"));
        assertEquals("P", bst.ceiling("O"));
        assertEquals("P", bst.ceiling("P"));
        assertEquals("R", bst.ceiling("Q"));
        assertEquals("R", bst.ceiling("R"));
        assertEquals("S", bst.ceiling("S"));
        assertEquals("X", bst.ceiling("T"));
        assertEquals("X", bst.ceiling("W"));
        assertEquals("X", bst.ceiling("X"));
        assertEquals(null, bst.ceiling("Y"));
//
        assertEquals("A", bst.select(0));
        assertEquals("C", bst.select(1));
        assertEquals("E", bst.select(2));
        assertEquals("H", bst.select(3));
        assertEquals("L", bst.select(4));
        assertEquals("M", bst.select(5));
        assertEquals("P", bst.select(6));
        assertEquals("R", bst.select(7));
        assertEquals("S", bst.select(8));
        assertEquals("X", bst.select(9));
//
        assertEquals(0, bst.rank("A"));
        assertEquals(1, bst.rank("C"));
        assertEquals(2, bst.rank("E"));
        assertEquals(3, bst.rank("H"));
        assertEquals(4, bst.rank("L"));
        assertEquals(5, bst.rank("M"));
        assertEquals(6, bst.rank("P"));
        assertEquals(7, bst.rank("R"));
        assertEquals(8, bst.rank("S"));
        assertEquals(9, bst.rank("X"));
//
//        bst.deleteMin();
//        Assert.assertEquals(0, bst.rank("C"));
//        bst.deleteMin();
//        Assert.assertEquals(0, bst.rank("E"));
//        System.out.println();
//
//        bst.deleteMax();
//        Assert.assertEquals(null, bst.get("X"));
//        Assert.assertEquals(Integer.valueOf(0), bst.get("S"));

    }

    @Test
    public void test() throws FileNotFoundException {
        ST<String, Integer> st = new ST<>();
        System.setIn(new FileInputStream(DATA_PATH + "leipzig1m.txt"));


        int distinct = 0, words = 0;
//        int minlen = Integer.parseInt(args[0]);
        int minlen = 8;
//        ST<String, Integer> st = new ST<String, Integer>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);

    }
}
