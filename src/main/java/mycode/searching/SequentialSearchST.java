package mycode.searching;

import java.util.Iterator;

/**
 * Created by Shin on 2017/4/13.
 */
public class SequentialSearchST<K extends Comparable<K>, V> implements IOrderSymbolTable<K, V> {

    private Node first;
    private class Node {
        K key;
        V val;
        Node next;

        public Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }


    @Override
    public K min() {
        return null;
    }

    @Override
    public K max() {
        return null;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    @Override
    public void put(K key, V val) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        //在头部插入节点
        first = new Node(key, val, first);

    }

    @Override
    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
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
