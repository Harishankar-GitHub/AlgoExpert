import java.util.ArrayList;
import java.util.List;

public class Program {

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = buildBinaryTree();

        System.out.println("Node depths - Recursive approach: " + nodeDepths_Recursive(root));
        System.out.println("Node depths - Iterative approach: " + nodeDepths_Iterative(root));
    }

    public static int nodeDepths_Recursive(BinaryTree root) {

        // Average case when the tree is balanced
        // O(n) time | O(h) space
        // where n is the number of nodes in the Binary Tree and h is the height of the Binary Tree.

        return calculateNodeDepths(root, 0);
    }

    private static int calculateNodeDepths(BinaryTree root, int depth) {
        if (root == null) {
            return 0;
        }
        return depth + calculateNodeDepths(root.left, depth+1) + calculateNodeDepths(root.right, depth+1);
    }

    public static int nodeDepths_Iterative(BinaryTree root) {

        // Average case when the tree is balanced
        // O(n) time | O(h) space
        // where n is the number of nodes in the Binary Tree and h is the height of the Binary Tree.

        int sumOfDepths = 0;
        List<Level> stack = new ArrayList<>();
        stack.add(new Level(root, 0));

        while (stack.size() > 0) {
            Level top = stack.remove(stack.size() - 1);
            BinaryTree node = top.root;
            int depth = top.depth;

            if (node == null)
                continue;

            sumOfDepths += depth;
            stack.add(new Level(node.left, depth+1));
            stack.add(new Level(node.right, depth+1));
        }
        return sumOfDepths;
    }

    static class Level {
        public BinaryTree root;
        int depth;

        public Level(BinaryTree root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    private static BinaryTree buildBinaryTree() {
        BinaryTree root = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree four = new BinaryTree(4);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree five = new BinaryTree(5);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree three = new BinaryTree(3);

        root.left = two;
        two.left = four;
        four.left = eight;
        four.right = nine;
        two.right = five;
        root.right = three;
        three.left = six;
        three.right = seven;

        return root;
    }
}