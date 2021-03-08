package binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class maxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static int w(Node head) {
        if(head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if(cur.left !=null) {
                levelMap.put(cur.left, curNodeLevel+1);
                queue.add(cur.left);
            }
            if(cur.right !=null) {
                levelMap.put(cur.right, curNodeLevel+1);
                queue.add(cur.right);
            }
        }
        return max;
    }

    public static int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        int curWidth = 0;
        // 目前的层数
        int curLevel = 0;
        // node 所在的层数
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Node node = null;
        Node left = null;
        Node right = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            left = node.left;
            right = node.right;
            if (left != null) {
                levelMap.put(left, levelMap.get(node) + 1);
                queue.add(left);
            }
            if (right != null) {
                levelMap.put(right, levelMap.get(node) + 1);
                queue.add(right);
            }
            if (levelMap.get(node) > curLevel) {
                curWidth = 1;
                curLevel = levelMap.get(node);
            } else {
                curWidth++;
            }
            maxWidth = Math.max(maxWidth, curWidth);
        }
        return maxWidth;
    }

    // 宽度优先遍历 - 一层一层地打印
    public static void process(Node head){
        if(head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value+" ");
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        process(head);
    }
}
