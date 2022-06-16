public class Program {

    public static void main(String[] args) {
        LinkedList head = buildLinkedList();
        printLinkedList(head);
        removeKthNodeFromEnd(head, 4);
        printLinkedList(head);
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        // O(n) time | O(1) space

        LinkedList firstPtr = head;
        LinkedList secondPtr = head;
        int counter = 1;

        while (counter <= k) {
            secondPtr = secondPtr.next;
            counter++;
        }

        if (secondPtr == null) {
            // This is an edge case.
            // When head node to be removed, "as per this question" we should just mutate the value and the next pointer
            // and not remove head or restructure the given linked list.
            // So, assigning head.value as head.next.value.
            // And making head to point head.next.next.
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (secondPtr.next != null) {
            // Here, the condition in the while loop is
            // secondPtr.next != null and not secondPtr != null.
            // That is because, when we have secondPtr.next != null
            // secondPtr will be pointing to one node before the last node and
            // firstPtr will be pointing to one node before the node to be removed.
            // So, outside the while loop, we can connect/link the prev and next nodes
            // of the node to be removed.
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        firstPtr.next = firstPtr.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    private static LinkedList buildLinkedList() {
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        LinkedList seven = new LinkedList(7);
        LinkedList eight = new LinkedList(8);
        LinkedList nine = new LinkedList(9);

        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;

        return zero;
    }

    private static void printLinkedList(LinkedList head) {
        while (head.next != null) {
            System.out.print(head.value);
            head = head.next;
        }

        System.out.println();
    }
}
