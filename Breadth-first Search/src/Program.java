import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Program {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {

            // O(v+e) time | O(v) space

            Queue<Node> nodeQueue = new LinkedList<>();
            nodeQueue.add(this);

            while (!nodeQueue.isEmpty()) {
                Node currentNode = nodeQueue.poll();
                array.add(currentNode.name);
                nodeQueue.addAll(currentNode.children);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node graph = buildGraph();

        List<String> strings = graph.breadthFirstSearch(new ArrayList<>());

        for (String string : strings) {
            System.out.print(string);
        }
    }

    private static Node buildGraph() {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");

        return graph;
    }
}