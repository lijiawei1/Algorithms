package mycode.searching;

/**
 * 定义有序符号表的接口
 * Created by Shin on 2017/4/13.
 */
public interface ISymbolTable<K, V> extends Iterable<K> {

    void put(K key, V val);

    V get(K key);

    default void delete(K key) {
        put(key, null);
    }

    default boolean contains(K key) {
        return get(key) == null;
    }

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    /**
     * 表中所有键的集合
     * @return
     */
    Iterable<K> keys();

}
