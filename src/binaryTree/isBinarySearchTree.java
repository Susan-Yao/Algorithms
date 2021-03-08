package binaryTree;

import java.util.LinkedList;
import java.util.Stack;

public class isBinarySearchTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 递归方法
    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean is, int mi, int ma) {
            isBST = is;
            min = mi;
            max = ma;
        }
    }

    // 以x为头的树，返回三个信息
    public static ReturnData process1(Node x) {
        if (x == null) {
            return null;
        }
        ReturnData leftData = process1(x.left);
        ReturnData rightData = process1(x.right);

        // 得到自己的min与max
        int min = x.value;
        int max = x.value;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        // 判断自己是不是BST
        boolean isBST = false;
        if (    (leftData == null || (leftData.isBST && leftData.max < x.value)) // 左树达标
            &&
                (rightData == null || (rightData.isBST && x.value < rightData.min)) // 右树达标
        ) {
            isBST = true;
        }


        return new ReturnData(isBST, min, max);
    }

    public static boolean isBST1(Node head){
        ReturnData in = process1(head);
        return in.isBST;
    }







    // 非递归方法 - 中序遍历的结果 是否为依次递增
    // 中序遍历 非递归
    public static boolean inOrderUnRecur(Node head) {
        if (head == null) {
            return true;
        }
        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value <= pre) {
                    return false;
                }
                pre = head.value;
                head = head.right;
            }
        }
        return true;
    }

    // 非递归方法 - 中序遍历的结果 是否为依次递增
    // 中序遍历 递归
    public static void process(Node node, LinkedList<Node> inOrderList) {
        if (node == null) {
            return;
        }
        process(node.left, inOrderList);
        inOrderList.add(node);
        process(node.right, inOrderList);
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> inOrderList = new LinkedList<>();
        process(head, inOrderList);
        int pre = Integer.MIN_VALUE;
        for (Node cur : inOrderList) {
            if (pre >= cur.value) {
                return false;
            }
            pre = cur.value;
        }
        return true;
    }



}
