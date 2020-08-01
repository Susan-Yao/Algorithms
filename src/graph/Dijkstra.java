package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node from) {
        // 从head出发到所有点的最小距离
        // key : 从head出发到达key
        // value : 从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从from 出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰 - 勿摸
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode); // 此时选的最小记录 - 从from到minNode的距离
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) { // toNode 是正无穷
                    distanceMap.put(toNode, distance + edge.weight);
                } else { // 之前有记录 不是正无穷
                    distanceMap.put(edge.to, Math.min(
                            distanceMap.get(toNode), // 老的记录
                            distance + edge.weight)); // 现在的记录
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    // 在distanceMap中，除了touchedNodes的点，返回一个距离最小的
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
