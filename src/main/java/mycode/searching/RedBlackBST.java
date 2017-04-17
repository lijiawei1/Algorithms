package mycode.searching;

/**
 * Created by Shin on 2017/4/14.
 */
public class RedBlackBST<K extends Comparable<K>, V> extends NonrecursiveBST<K, V>{

    /**
     * 实现
     * @param key
     * @param val
     */
    @Override
    public void put(K key, V val) {
        root = put(key, val, root);
        root.color = BLACK;
    }

    private Node put(K key, V val, Node h) {
        //如果key存在于以x为根结点的子树中则更新它的值
        //否则将以key和val为键值对的新新结点插入到该子树中
        //终止条件
        if (h == null) return new Node(key, val, 1, RED);

        //递归时往下走
        //返回时沿着树往上爬，重置搜索路径上每个父结点指向子结点的链接，并增加路径上每个结点中的计数器的值
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(key, val, h.left);
        else if (cmp > 0) h.right = put(key, val, h.right);
        else h.val = val;

        //判断是否需要转换
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);

        //重新计算n
        h.n = size(h.left) + size(h.right) + 1;

        return h;
    }

    /**
     * 右红结点，左旋
     * @param h
     * @return
     */
    protected Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 左红结点，右旋
     * @param h
     * @return
     */
    protected Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 填充，身上传递
     * @return
     */
    protected void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
