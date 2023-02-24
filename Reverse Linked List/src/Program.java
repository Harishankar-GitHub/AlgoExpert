public class Program {

    public static void main(String[] args) {
        LinkedList linkedList = buildLinkedList();
        printLinkedList(linkedList);

        LinkedList reverseLinkedList = reverseLinkedList(linkedList);
        printLinkedList(reverseLinkedList);
    }

    public static LinkedList reverseLinkedList(LinkedList head) {

        // O(n) time | O(1) space
        // where n is the number of nodes in the linked list.

        // HEAD -> 0 > 1 > 2 > 3 > 4 > 5 > NULL
        // HEAD -> 5 > 4 > 3 > 2 > 1 > 0 > NULL

        LinkedList previousNode = null;
        LinkedList currentNode = head;

        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
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

        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        return zero;
    }

    private static void printLinkedList(LinkedList sumOfLinkedLists) {
        System.out.print("HEAD -> ");
        while (sumOfLinkedLists != null)
        {
            System.out.print(sumOfLinkedLists.value);
            System.out.print(" > ");
            sumOfLinkedLists = sumOfLinkedLists.next;
        }
        System.out.println("NULL");
    }
}
