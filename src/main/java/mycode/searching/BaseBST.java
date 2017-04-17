package mycode.searching;

import java.util.function.Consumer;

/**
 * Created by Shin on 2017/4/14.
 */
public abstract class BaseBST<K extends Comparable<K>, V> implements IBinarySearchTree<K, V> {

    static final boolean RED = true;
    static final boolean BLACK = false;

    protected Node root;

    protected class Node {
        protected K key;              //键
        protected V val;              //值
        protected Node left, right;   //指向子树的链接
        protected int n;              //以该结点为根的子树中的结点总数
        boolean color;

        public Node(K key, V val, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }

        public Node(K key, V val, Node left, Node right, int n) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            this.n = n;
        }

        public Node(K key, V val, Node left, Node right, int n, boolean color) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            this.n = n;
            this.color = color;
        }

        public Node(K key, V val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }

        public String toString() {
            return String.format("key:%s,val:%d,n:%d,c:%s", key, val, n, color);
        }
    }

    protected int size(Node x) {
        return x == null ? 0 : x.n;
    }

    //public void traversalMid() {
    //    traversalMidRe(root, n -> {
    //        if (n.key.compareTo(select(rank(n.key))) != 0)
    //            throw new IllegalStateException("键不相等");
    //    });
    //}

    /**
     * 中序
     */
    public void traversalMid() {
        traversalMidRe(root, n -> System.out.print(n.key));
        System.out.println();
    }

    public void traversalMidRe(Node x, Consumer<Node> f) {
        if (x == null) return;
        traversalMidRe(x.left, f);
        f.accept(x);
        traversalMidRe(x.right, f);
    }

    /**
     * 判断是否红链接
     * @param x
     * @return
     */
    protected boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
