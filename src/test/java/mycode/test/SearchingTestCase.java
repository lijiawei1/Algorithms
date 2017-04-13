package mycode.test;

import com.bedpotato.alg4.ST;
import com.bedpotato.alg4.utils.StdIn;
import com.bedpotato.alg4.utils.StdInTest;
import com.bedpotato.alg4.utils.StdOut;
import mycode.searching.BST;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.bedpotato.alg4.constants.Alg4Constants.DATA_PATH;

/**
 * Created by Shin on 2017/4/13.
 */
public class SearchingTestCase {

    @Test
    public void testBST() {
        String S = "SEARCHEXAMPLE";
        String[] cs = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            cs[i] = String.valueOf(S.charAt(i));
        }
        BST<String, Integer> bst = new BST<>();
        for (int i = 0; i < cs.length; i++) {
            bst.put(cs[i], i);
        }
        System.out.println(bst.min());
        System.out.println(bst.max());
        Assert.assertEquals(null, bst.floor(String.valueOf((char)('A' - 1))));
        Assert.assertEquals("A", bst.floor("A"));
        Assert.assertEquals("A", bst.floor("B"));
        Assert.assertEquals("E", bst.floor("G"));
        Assert.assertEquals("S", bst.floor("S"));
        Assert.assertEquals("S", bst.floor("T"));
        Assert.assertEquals("X", bst.floor("X"));
        Assert.assertEquals("X", bst.floor("Y"));

        Assert.assertEquals(null, bst.ceiling(String.valueOf((char)('X' + 1))));
        Assert.assertEquals("A", bst.ceiling("A"));

        Assert.assertEquals("C", bst.ceiling("B"));
        Assert.assertEquals("H", bst.ceiling("G"));
        Assert.assertEquals("P", bst.ceiling("O"));
        Assert.assertEquals("P", bst.ceiling("P"));
        Assert.assertEquals("R", bst.ceiling("Q"));
        Assert.assertEquals("R", bst.ceiling("R"));
        Assert.assertEquals("S", bst.ceiling("S"));
        Assert.assertEquals("X", bst.ceiling("T"));
        Assert.assertEquals("X", bst.ceiling("W"));
        Assert.assertEquals("X", bst.ceiling("X"));
        Assert.assertEquals(null, bst.ceiling("Y"));

        Assert.assertEquals("A", bst.select(0));
        Assert.assertEquals("C", bst.select(1));
        Assert.assertEquals("E", bst.select(2));
        Assert.assertEquals("H", bst.select(3));
        Assert.assertEquals("L", bst.select(4));
        Assert.assertEquals("M", bst.select(5));
        Assert.assertEquals("P", bst.select(6));
        Assert.assertEquals("R", bst.select(7));
        Assert.assertEquals("S", bst.select(8));
        Assert.assertEquals("X", bst.select(9));

        Assert.assertEquals(0, bst.rank("A"));
        Assert.assertEquals(1, bst.rank("C"));
        Assert.assertEquals(2, bst.rank("E"));
        Assert.assertEquals(3, bst.rank("H"));
        Assert.assertEquals(4, bst.rank("L"));
        Assert.assertEquals(5, bst.rank("M"));
        Assert.assertEquals(6, bst.rank("P"));
        Assert.assertEquals(7, bst.rank("R"));
        Assert.assertEquals(8, bst.rank("S"));
        Assert.assertEquals(9, bst.rank("X"));

        bst.deleteMin();
        Assert.assertEquals(0, bst.rank("C"));
        bst.deleteMin();
        Assert.assertEquals(0, bst.rank("E"));
        System.out.println();

        bst.deleteMax();
        Assert.assertEquals(null, bst.get("X"));
        Assert.assertEquals(Integer.valueOf(0), bst.get("S"));

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
