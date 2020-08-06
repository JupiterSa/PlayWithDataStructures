//这个类定义的二分搜索树不包含重复元素
//二分搜索树不是支持所有类型的，它支持可比较的元素，所以这里的泛型要限定必须可以，所以就extends了Comparable
public class BinarySearchTreeBasic<E extends Comparable<E>> {

    /*=====================================================================================*/
    //二分搜索树的节点，作为内部类存在
    private class Node {

        //节点的成员遍历
        public E e;
        public Node left;
        public Node right;

        //Node构造函数
        public Node (E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /*=====================================================================================*/
    //二分搜索树的成员变量
    private Node root;//根节点
    private int size;//有多少元素

    //二分搜索树的构造函数（默认构造函数）
    public BinarySearchTreeBasic () {
        root = null;
        size = 0;
    }

    /*=====================================================================================*/
    //二分搜索树的的方法：返回元素个数
    public int size() {
        return size;
    }

    /*=====================================================================================*/
    //二分搜索树的的方法：判断是否位空
    public boolean isEmpty () {
        return size == 0;
    }

    /*=====================================================================================*/
    //向二分搜索树中插入元素（递归实现） 这个方法更通用简洁
    public void add (E e) {
        root = addRecursion (root, e);
    }

    //空本身就是二叉树
    //递归方法
    private Node addRecursion (Node node, E e) {
        //如果“root”为空，则肯定要新插入一个节点。这个root是每个宏观递归的根节点，每个小三角！
        //将这个新增节点挂接在二叉树上，return回去即可
        if (node == null) { //传入的位置是空的，则这个位置将new一下，就有元素了
            size ++;
            return new Node(e); //返回插入新节点后二叉树的根(这个跟是新的小三角的起始)
        }

        //递归体，重复执行
        if(e.compareTo(node.e) < 0)
            node.left = addRecursion(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = addRecursion(node.right, e);

        return node;
    }

    /*=====================================================================================*/
    //向二分搜索树中添加元素（递归实现）根节点单独拿出来了
    public void addMethod2 (E e) {
        if (root == null) {
            root = new Node(e);
            size ++;
        } else {
            add2Recursion(root,e);
        }
    }
    //用递归的方法，在一个宏观三角二叉树中，如果root没有，就放入root，否则小于放入左，大于放入右
    //向以node为跟的元素插入元素e
    private void add2Recursion (Node node, E e) {
        //递归终止条件(有三个)
        if (e.equals(node.e)) {//待递归的元素与e相等，有重复元素，则不插入
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {  //(e < node.e) 不是基础类型，不可以直接>=<比较
            node.left = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }

        //递归体，重复执行
        if (e.compareTo(node.e) < 0) {
            add2Recursion(node.left, e);
        } else {
            add2Recursion(node.right, e);
        }
    }

    /*=====================================================================================*/
    //查询     不需要像add一样挂接，只查每个node即可
    public boolean contains (E e) {
        return containsRecursion(root, e);
    }

    public boolean containsRecursion (Node node, E e) {
        //终止条件
        if (node == null) {
            return false;
        }

        //递归体
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return containsRecursion(node.left, e);
        } else {
            return containsRecursion(node.right, e);
        }
    }

    /*=====================================================================================*/
    //二分搜索树的遍历 -- 前序遍历 根→左→右   访问二叉树的所有节点，两个子树都要顾及（两次递归）
    public void preOrderTraverse () {
        preOrderTraverseRecursion (root);
    }

    private void preOrderTraverseRecursion (Node node) {
        //递归终止条件
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrderTraverseRecursion(node.left);
        preOrderTraverseRecursion(node.right);
    }

    /*=====================================================================================*/
    //二分搜索树的遍历 -- 中序遍历 左→根→右  !! 二分搜索树排序后的结果 从小到大
    public void inOrderTraverse() {
        inOrderTraverseRecursion(root);
    }

    //中序遍历以node为根的二分搜索树，递归算法
    private void inOrderTraverseRecursion(Node node) {
        //递归终止条件
        if (node == null) {
            return;
        }

        inOrderTraverseRecursion(node.left); //先遍历(节点/根)所有左边的
        System.out.println(node.e);          //然后遍历这个节点(根)本身
        inOrderTraverseRecursion(node.right);//最后遍历(节点/根)所有右边的
    }


    /*=====================================================================================*/
    //二分搜索树的遍历 -- 后序遍历 左→右→根
    //后续遍历的应用：为二分搜索树释放内存（因为要先释放掉所有孩子，然后再来根）
    //数据结构的问题需要根据已知的孩子节点求解答案，分治 回溯 动态规划 等算法
    public void postOrderTraverse () {
        postOrderTraverseRecursion(root);
    }

    private void postOrderTraverseRecursion (Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverseRecursion(node.left);
        postOrderTraverseRecursion(node.right);
        System.out.println(node.e);
    }

    /*=====================================================================================*/
    @Override
    public String toString () {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res); //根 深度 生成的字符串
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString (Node node, int depth, StringBuilder res) {
        //节点为空
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        //节点不为空 打印节点
        res.append(generateDepthString(depth) + node.e + "\n");

        //基于前序遍历打印二叉树
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right,depth + 1, res);
    }

    //生成深度字符串
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++) {
            res.append("--");
        }
        return res.toString();
    }
}
