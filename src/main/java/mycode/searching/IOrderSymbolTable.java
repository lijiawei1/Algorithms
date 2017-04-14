package mycode.searching;

/**
 * Created by Shin on 2017/4/13.
 */
public interface IOrderSymbolTable<K extends Comparable<K>, V> extends ISymbolTable<K, V> {

    /**
     * 最小的键
     * @return
     */
    K min();
    /**
     * 最大的键
     * @return
     */
    K max();
    /**
     * 小于等于key的最大键
     * @param key
     * @return
     */
    K floor(K key);
    /**
     * 大于等于key的最小键
     * @param key
     * @return
     */
    K ceiling(K key);
    /**
     * 小于key的键的数量
     * @param key
     * @return
     */
    int rank(K key);
    /**
     * 排名为k的键
     * @param k
     * @return
     */
    K select(int k);

    default void deleteMin() {
        delete(min());
    }

    default void deleteMax() {
        delete(max());
    }

    /**
     * [lo...hi]之间键的数量
     * @param lo
     * @param hi
     * @return
     */
    default int size(K lo, K hi) {
        if (lo.compareTo(hi) > 0)
            return 0;
        else if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }
    /**
     * [lo...hi]之间的数量
     * @param lo
     * @param hi
     * @return
     */
    Iterable<K> keys(K lo, K hi);
    /**
     * 表所有键的集合，已排序
     * @return
     */
    default Iterable<K> keys() {
        return keys(min(), max());
    }
}
