public class Program {

    // This is the class of the input root. Do not edit it.
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = buildBinarySearchTree();

        int target = 12;
        System.out.println("Iterative approach: Closest value of " + target + " in BST is " + findClosestValueInBst_Iterative(root, 12));
        System.out.println("Recursive approach: Closest value of " + target + " in BST is " + findClosestValueInBst_Recursive(root, 12));
    }

    public static int findClosestValueInBst_Iterative(BST tree, int target) {

        // Iterative approach
        // Average: O(log(n)) time | O(1) space
        // Worst: O(n) time | O(1) space

        int closest = tree.value;
        BST currentNode = tree;

        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
                closest = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

    public static int findClosestValueInBst_Recursive(BST tree, int target) {

        // Recursive approach
        // Average: O(log(n)) time | O(log(n)) space
        // Worst: O(n) time | O(n) space

        return findClosestValueInBst(tree, target, tree.value);
    }

    private static int findClosestValueInBst(BST tree, int target, int closest) {
        if (tree == null) {
            return closest;
        }
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value) {
            return findClosestValueInBst(tree.left, target, closest);
        } else if (target > tree.value) {
            return findClosestValueInBst(tree.right, target, closest);
        } else {
            return closest;
        }
    }

    private static BST buildBinarySearchTree() {
        BST root = new BST(10);
        BST five = new BST(5);
        BST fifteen = new BST(15);
        BST two = new BST(2);
        BST thirteen = new BST(13);
        BST twentyTwo = new BST(22);
        BST one = new BST(1);
        BST fourteen = new BST(14);

        root.left = five;
        root.right = fifteen;
        root.left.left = two;
        root.left.right = five;
        root.left.left.left = one;
        root.right.left = thirteen;
        root.right.right = twentyTwo;
        root.right.left.right = fourteen;

        return root;
    }
}
