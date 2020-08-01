package binaryTree;

public class isFullTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info{
        public int height; // 最大高度
        public int nodes; // 节点个数

        public Info(int h, int n) {
            height = h;
            nodes = n;
        }

    }
    public static Info f(Node x) {
        if(x == null) {
            return new Info(0,0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);
        int height  = Math.max(leftData.height,rightData.height)+1; // 我比左右孩子高一层
        int nodes = leftData.nodes + rightData.nodes + 1; // 左右孩子的节点个数 + 我
        return new Info(height, nodes);
    }

    public static boolean isF(Node head) {
        if(head == null) {
            return true;
        }
        Info data = f(head);
        return data.nodes == (1 << data.height - 1); // 2^H - 1
    }
}
