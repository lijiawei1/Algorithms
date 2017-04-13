package mycode.searching;

import java.util.Iterator;

/**
 * Created by Shin on 2017/4/13.
 */
public class BST<K extends Comparable<K>, V> implements IOrderSymbolTable<K, V> {

    private Node root;

    private class Node {
        private K key;              //键
        private V val;              //值
        private Node left, right;   //指向子树的链接
        private int n;              //以该结点为根的子树中的结点总数

        public Node(K key, V val, Node left, Node right, int n) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            this.n = n;
        }

        public Node(K key, V val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    @Override
    public void put(K key, V val) {
        root = put(key, val, root);
    }

    private Node put(K key, V val, Node x) {
        //如果key存在于以x为根结点的子树中则更新它的值
        //否则将以key和val为键值对的新新结点插入到该子树中

        //终止条件
        if (x == null) return new Node(key, val, 1);

        //递归时往下走
        //返回时沿着树往上爬，重置搜索路径上每个父结点指向子结点的链接，并增加路径上每个结点中的计数器的值
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(key, val, x.left);
        else if (cmp > 0) x.right = put(key, val, x.right);
        else x.val = val;
        x.n = size(x.left) + size(x.right) + 1;

        return x;
    }

    private int size(Node x) {
        return x == null ? 0 : x.n;
    }

    @Override
    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.val;
        else if (cmp < 0) return get(key, x.left);
        else return get(key, x.right);
    }

    @Override
    public K min() {
        return min(root);
    }

    private K min(Node x) {
        if (x == null) return null;
        if (x.left == null) return x.key;
        return min(x.left);
    }

    @Override
    public K max() {
        return max(root);
    }

    private K max(Node x) {
        if (x == null) return null;
        if (x.right == null) return x.key;
        return max(x.right);
    }

    @Override
    public K floor(K key) {
        return floor(key, root);
    }

    private K floor(K key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        //一定在左子树
        if (cmp < 0) return floor(key, x.left);
        //可能在右子树，如果不在右子树，那么当前的x.key就是目标
        else if (cmp > 0) {
            K k = floor(key, x.right);
            //右子树不一定有的
            return k == null ? x.key : k;
        } else return x.key;
    }

    @Override
    public K ceiling(K key) {
        return ceiling(key, root);
    }

    private K ceiling(K key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        //一定在右子树
        if (cmp > 0) return ceiling(key, x.right);
        else if (cmp < 0) {
            K k = ceiling(key, x.left);
            return k == null ? x.key : k;
        } else return x.key;
    }

    @Override
    public int rank(K key) {
        return rank(key, root);
    }

    private int rank(K key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        //判断左子树的个数
        if (cmp < 0) return rank(key, x.left);
        //左子树的个数+本身+右子树的排名等于最终排名
        else if (cmp > 0) return size(x.left) + 1 + rank(key, x.right);
        else return size(x.left);
    }

    @Override
    public K select(int k) {
        return select(k, root);
    }

    private K select(int k, Node x) {
        if (x == null) return null;
        int t = size(x.left);
        //左子树结点数大于k，找左子树
        if (t > k) return select(k, x.left);
        //左子树结点数小于k，从右子树中找剩余的，注意是每进入一棵子树都是从零开始，所以要减一
        else if (t < k) return select(k - t - 1, x.right);
        else return x.key;
    }

    public void delete(K k) {

    }

    /**
     * 热身运动
     */
    public void deleteMin() {
        if (root != null)
            root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        int t = size(x.left);
        if (t == 0) return x.right;
        else {
            x.left = deleteMin(x.left);
            x.n = size(x.left) + size(x.right) + 1;
            return x;
        }

    }

    public void deleteMax() {
        if (root != null)
            root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        int t = size(x.right);
        if (t == 0) return x.left;
        else {
            x.right = deleteMax(x.right);
            x.n = size(x.left) + size(x.right) + 1;
            return x;
        }
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
