package M09;

import java.util.HashMap;
import java.util.Map;

import M09.Utils.Node;

//133. 克隆图
public class CloneGraph133 {
    Map<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return node;
        map.put(node,new Node(node.val));
        for (Node n : node.neighbors) {
            cloneGraph(n);
            map.get(node).neighbors.add(map.get(n));
        }
        return map.get(node);
    }
}
