import java.util.ArrayList;
import java.util.List;

public class Program {

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree four = new BinaryTree(4);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree five = new BinaryTree(5);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree ten = new BinaryTree(10);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree three = new BinaryTree(3);

        root.left = two;
        two.left = four;
        four.left = eight;
        four.right = nine;
        two.right = five;
        five.left = ten;
        root.right = three;
        three.left = six;
        three.right = seven;

        List<Integer> branchSums = branchSums(root);

        System.out.print("Branch Sums are:");
        for (int branchSum : branchSums) {
            System.out.print(" " + branchSum);
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {

//        O(n) time | O(n) space
//        where n is the number of nodes in the Binary Tree

        List<Integer> branchSums = new ArrayList<>();
        calculateBranchSums(root, 0, branchSums);
        return branchSums;
    }

    private static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> branchSums) {
        if (node == null) return;

        int newRunningSum = runningSum + node.value;
        if (node.left == null && node.right == null) {
            branchSums.add(newRunningSum);
        }

        calculateBranchSums(node.left, newRunningSum, branchSums);
        calculateBranchSums(node.right, newRunningSum, branchSums);
    }
}
