/**
 * 二叉查找树
 */
public class BST<Key extends Comparable<Key>,Value> {

    /**
     * 每个二叉树的节点
     */
    private class Node {
        private Key key;
        private Value value;

        //左子树，右子树
        private Node left,right;

        //当前节点的子树中的节点数量（包括自己）
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    //根节点
    private Node root;

    public int size(){
        return size(root);
    }

    /**
     * 当前节点的N = 左子树的N + 右子树的N + 1;
     * @param node
     * @return
     */
    private int size(Node node){
        if(null == node){
            return 0;
        }
        return node.left.N + node.right.N + 1 ;
    }

    //查询

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node , Key key){
        if(null == node){
            return null;
        }
        int flag = node.key.compareTo(key);
        if(flag > 0) {
            return get(node.left,key);
        } else if ( flag < 0){
            return get(node.right,key);
        }else {
            return node.value;
        }
    }

    //插入
    public void put(Key key , Value value){
        root = put(root,key,value);
    }

    private Node put(Node node,Key key,Value value){
        if(null == node){
            return new Node(key,value,1);
        }
        int flag = node.key.compareTo(key);
        if(flag > 0) {
            node.left = put(node.left,key,value);
        } else if ( flag < 0){
            node.left = put(node.left,key,value);
        }else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

}
