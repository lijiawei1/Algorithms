package mycode.searching;

import java.util.function.Consumer;

/**
 * Created by Shin on 2017/4/14.
 */
public interface IBinarySearchTree<K extends Comparable<K>, V> extends IOrderSymbolTable<K, V>{
    int height();

    void traversalMid();
}
