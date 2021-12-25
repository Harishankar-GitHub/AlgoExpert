public class Program_Iterative {

    // Iterative approach
    
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {

            //Average:  O(log(n)) time | O(1) space
            // Worst:   O(n) time | O(1) space

            BST currentNode = this;

            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            // Do not edit the return statement of this method.
            return this;
        }

        public boolean contains(int value) {

            //Average:  O(log(n)) time | O(1) space
            // Worst:   O(n) time | O(1) space

            BST currentNode = this;

            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {

            //Average:  O(log(n)) time | O(1) space
            // Worst:   O(n) time | O(1) space

            remove(value, null);
            // Do not edit the return statement of this method.
            return this;
        }

        public void remove(int value, BST parentNode) {
            BST currentNode = this;

            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            // This is a single-node tree; do nothing.
                        }
                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        public int getMinValue() {
            if (left == null) {
                return value;
            } else {
                return left.getMinValue();
            }
        }
    }

    public static void main(String[] args) {
        BST root = buildBinarySearchTree();

        root.insert(12);
        System.out.println("12 should be inserted at root.right.left.left.value: " + root.right.left.left.value);

        root.remove(10);
        System.out.println("Removed 10 from BST");
        System.out.println("root.contains(10) should be false: " + root.contains(10));
        System.out.println("root.value should be 12: " + root.value);
        System.out.println("root.contains(15) should be true: " + root.contains(15));
    }

    private static BST buildBinarySearchTree() {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        return root;
    }
}
