package mycode.searching;

import java.util.Iterator;

/**
 * Created by Shin on 2017/4/13.
 */
public class BinarySearchST<K extends Comparable<K>, V> implements IOrderSymbolTable<K, V>{
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

    }

    @Override
    public V get(K key) {
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
