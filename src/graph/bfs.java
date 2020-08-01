package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class bfs { // 宽度优先 - 队列

    public static class Node {
        public int value;
        public int in; // 入度
        public int out; // 出度
        public ArrayList<Node> nexts; // 出的直接邻居
        public ArrayList<Edge> edges; // 出的边

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    // 从node出发，进行宽度优先遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            int l = cur.nexts.size();
            int i = 0;

            while (i<l){
                Node next = cur.nexts.get(i);
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
                i ++;
            }

        }
    }
}
