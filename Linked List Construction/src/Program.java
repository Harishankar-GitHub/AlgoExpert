public class Program {

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node three2 = new Node(3);
        Node three3 = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);

        linkedList.head = one;
        linkedList.tail = five;

        performOperations(linkedList, two, three, three2, three3, four, six);
    }

    private static void printLinkedList(DoublyLinkedList linkedList) {
        Node node = linkedList.head;

        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }

        System.out.println();
    }

    private static void bindNodes(Node nodeOne, Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private static void performOperations(DoublyLinkedList linkedList, Node two, Node three, Node three2, Node three3, Node four, Node six) {
        System.out.println("Initial LinkedList:");
        printLinkedList(linkedList);
        linkedList.setHead(four);
        System.out.println("Set Head to 4");
        printLinkedList(linkedList);
        linkedList.setTail(six);
        System.out.println("Set Tail to 6");
        printLinkedList(linkedList);
        linkedList.insertBefore(six, three);
        System.out.println("Insert 3 before 6");
        printLinkedList(linkedList);
        linkedList.insertAfter(six, three2);
        System.out.println("Insert 3 after 6");
        printLinkedList(linkedList);
        linkedList.insertAtPosition(1, three3);
        System.out.println("Insert 3 at position 1");
        printLinkedList(linkedList);
        linkedList.removeNodesWithValue(3);
        System.out.println("Remove nodes with value 3");
        printLinkedList(linkedList);
        linkedList.remove(two);
        System.out.println("Remove 2");
        printLinkedList(linkedList);
        System.out.println("LinkedList contains node with value 5? " + linkedList.containsNodeWithValue(5));
    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        // O(1) time | O(1) space
        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            insertBefore(head, node);
        }

        // O(1) time | O(1) space
        public void setTail(Node node) {
            if (tail == null) {
                setHead(node);
                return;
            }
            insertAfter(tail, node);
        }

        // O(1) time | O(1) space
        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;

            remove(nodeToInsert);
            // If nodeToInsert is a node that is already present in LinkedList,
            // we remove it. If it is a new node, we add it to the LinkedList.

            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;

            if (node.prev == null) head = nodeToInsert;
            else node.prev.next = nodeToInsert;

            node.prev = nodeToInsert;
        }

        // O(1) time | O(1) space
        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;

            remove(nodeToInsert);
            // If nodeToInsert is a node that is already present in LinkedList,
            // we remove it. If it is a new node, we add it to the LinkedList.

            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;

            if (node.next == null) tail = nodeToInsert;
            else node.next.prev = nodeToInsert;

            node.next = nodeToInsert;
        }

        // O(p) time | O(1) space
        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node node = this.head;
            int currentPosition = 1;
            while (node != null && currentPosition < position) {
                node = node.next;
                currentPosition += 1;
            }

            if (node != null) insertBefore(node, nodeToInsert);
            else setTail(nodeToInsert);
        }

        // O(n) time | O(1) space
        public void removeNodesWithValue(int value) {
            Node node = this.head;
            while (node != null) {
                Node nodeToBeRemoved = node;
                node = node.next;
                if (nodeToBeRemoved.value == value) remove(nodeToBeRemoved);
            }
        }

        // O(1) time | O(1) space
        public void remove(Node node) {
            if (node == head) head = head.next;
            if (node == tail) tail = tail.prev;
            removeNodeBindings(node);
        }

        // O(n) time | O(1) space
        public boolean containsNodeWithValue(int value) {
            Node node = this.head;

//            while (node != null) {
//                if (node.value == value) return true;
//                node = node.next;
//            }
//
//            return false;

            // Above logic can also be written as below:

            while (node != null && node.value != value) node = node.next;
            return node != null;
        }

        private void removeNodeBindings(Node node) {
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
