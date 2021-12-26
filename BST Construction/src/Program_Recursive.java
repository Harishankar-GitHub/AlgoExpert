public class Program_Recursive {

    // Recursive approach

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {

            //Average:  O(log(n)) time | O(log(n)) space
            // Worst:   O(n) time | O(n) space

            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
            // Do not edit the return statement of this method.
            return this;
        }

        public boolean contains(int value) {

            //Average:  O(log(n)) time | O(log(n)) space
            // Worst:   O(n) time | O(n) space

            if (value < this.value) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else if (value > this.value) {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            } else {
                return true;
            }
        }

        public BST remove(int value) {

            //Average:  O(log(n)) time | O(log(n)) space
            // Worst:   O(n) time | O(n) space

            remove(value, null);
            // Do not edit the return statement of this method.
            return this;
        }

        public void remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {
                        // This is a single-node tree; do nothing.
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
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
