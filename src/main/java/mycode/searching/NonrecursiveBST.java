package mycode.searching;

import java.util.*;
import java.util.function.Consumer;

/**
 * exe 3.2.13
 *
 * Created by Shin on 2017/4/14.
 */
public class NonrecursiveBST<K extends Comparable<K>, V> extends BaseBST<K, V> {
    @Override
    public int height() {
        return 0;
    }

    @Override
    public K min() {
        return root == null ? null : min(root).key;
    }

    private Node min(Node x) {
        if (x == null) return null;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    @Override
    public K max() {
        return root == null ? null : max(root).key;
    }

    private Node max(Node x) {
        if (x == null) return null;
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    @Override
    public K floor(K key) {
        Node floor = floor(key, root);
        return floor == null ? null : floor.key;
    }

    private Node floor(K key, Node x) {
        Node t = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) x = x.left; //一定在左子树
            if (cmp > 0) {
                t = x; //可能在右子树，先保存父节点，如果不在，返回最后的父节点
                x = x.right;
            }
        }
        return  t;
    }

    @Override
    public K ceiling(K key) {
        Node ceiling = ceiling(key, root);
        return ceiling == null ? null : ceiling.key;
    }


    private Node ceiling(K key, Node x) {
        Node t = null;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            else if (cmp > 0) x = x.right; //一定在右子树
            else if (cmp < 0) {
                t = x;
                x = x.left; //可能在左子树，保存父节点,如果不在,
            }
        }
        return t;
    }

    /**
     * 小于key的键的数量
     * @param key
     * @return
     */
    @Override
    public int rank(K key) {
        return rank(key, root);
    }

    private int rank(K key, Node x) {
        int r = 0;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                r += size(x.left);
                break;
            }
            //往左走
            else if (cmp < 0) x = x.left;
            else if (cmp > 0) {
                //累加左子树的数量+当前节点
                r += (size(x.left) + 1);
                //往右走
                x = x.right;
            }
        }
        return r;
    }

    /**
     * 排第k的键，从0开始
     * @param k
     * @return
     */
    @Override
    public K select(int k) {
        Node node = select(k, root);
        return node == null ? null : node.key;
    }

    private Node select(int k, Node x) {
        if (x == null) return null;
        while (x != null) {
            int t = size(x.left);
            //进入左子树
            if (t > k) x = x.left;
            //左子树不够
            else if (t < k) {
                k -= (t + 1); //从0开始
                x = x.right;
            } else return x;
        }
        return x;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    /**
     * 性能优先无紧要
     * @param key
     * @param val
     */
    @Override
    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val, 1);
            return;
        }

        List<Node> road = new ArrayList<>();
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                x.val = val;
                return;
            }
            //保存路径
            road.add(x);
            if (cmp < 0) {
                if (x.left == null) {
                    x.left = new Node(key, val, 1);
                    break;
                }
                x = x.left;
            }
            if (cmp > 0) {
                if (x.right == null) {
                    x.right = new Node(key, val, 1);
                    break;
                }
                x = x.right;
            }
        }
        //重新计算路径节点数
        for (int i = road.size() - 1; i >= 0; i--) {
            Node node = road.get(i);
            node.n = size(node.left) + size(node.right) + 1;
        }
    }

    @Override
    public V get(K key) {
        if (root == null) return null;
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.val;
            if (cmp < 0) x = x.left;
            if (cmp > 0) x = x.right;
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
