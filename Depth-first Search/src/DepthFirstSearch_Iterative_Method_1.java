import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch_Iterative_Method_1 {

    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {

            // Iterative approach
            // O(v+e) time | O(v) space
            // where v and e are vertices and edges respectively.

            array.add(this.name);

            Stack<Node> nodeStack = new Stack<>();
            addChildrenToTheNodeStack(nodeStack, this.children);

            while (!nodeStack.isEmpty()) {
                Node nextNode = nodeStack.pop();
                array.add(nextNode.name);
                addChildrenToTheNodeStack(nodeStack, nextNode.children);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        private void addChildrenToTheNodeStack(Stack<Node> nodeStack, List<Node> nodes) {
            for (int i = nodes.size() - 1; i >= 0; i--) {
                nodeStack.push(nodes.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Node graph = buildGraph();

        List<String> strings = graph.depthFirstSearch(new ArrayList<>());

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
