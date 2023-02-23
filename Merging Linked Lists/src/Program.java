import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        // Output is not proper as equals and hash code functions are not present in
        // the LinkedList class.
        // If added, few methods print proper response.
        // All 3 solutions work fine in AlgoExpert page.

        LinkedList linkedListOne = buildLinkedListOne();
        LinkedList linkedListTwo = buildLinkedListTwo();

        printLinkedList(linkedListOne);
        printLinkedList(linkedListTwo);

        LinkedList mergedLinkedLists = mergingLinkedLists_method_1(linkedListOne, linkedListTwo);
        printLinkedList(mergedLinkedLists);

        linkedListOne = buildLinkedListOne();
        linkedListTwo = buildLinkedListTwo();

        printLinkedList(linkedListOne);
        printLinkedList(linkedListTwo);

        mergedLinkedLists = mergingLinkedLists_method_2(linkedListOne, linkedListTwo);
        printLinkedList(mergedLinkedLists);

        linkedListOne = buildLinkedListOne();
        linkedListTwo = buildLinkedListTwo();

        printLinkedList(linkedListOne);
        printLinkedList(linkedListTwo);

        mergedLinkedLists = mergingLinkedLists_method_3(linkedListOne, linkedListTwo);
        printLinkedList(mergedLinkedLists);

    }

    public static LinkedList mergingLinkedLists_method_1(LinkedList linkedListOne, LinkedList linkedListTwo) {

        // O(n+m) time | O(n+m) space
        // where n is the length of the first linked list and
        // m is the length of the second linked list.

        Set<LinkedList> listOneNodes = new HashSet<>();

        LinkedList currentNodeOne = linkedListOne;
        while (currentNodeOne != null) {
            listOneNodes.add(currentNodeOne);
            currentNodeOne = currentNodeOne.next;
        }

        LinkedList currentNodeTwo = linkedListTwo;
        while (currentNodeTwo != null) {
            if (listOneNodes.contains(currentNodeTwo)) {
                return currentNodeTwo;
            }
            currentNodeTwo = currentNodeTwo.next;
        }

        return null;
    }

    public static LinkedList mergingLinkedLists_method_2(LinkedList linkedListOne, LinkedList linkedListTwo) {

        // O(n+m) time | O(1) space
        // where n is the length of the first linked list and
        // m is the length of the second linked list.

        LinkedList currentNodeOne = linkedListOne;
        int countOne = 0;
        while (currentNodeOne != null) {
            countOne++;
            currentNodeOne = currentNodeOne.next;
        }

        LinkedList currentNodeTwo = linkedListTwo;
        int countTwo = 0;
        while (currentNodeTwo != null) {
            countTwo++;
            currentNodeTwo = currentNodeTwo.next;
        }

        int difference = Math.abs(countTwo - countOne);
        LinkedList biggerCurrentNode = countOne > countTwo ? linkedListOne : linkedListTwo;
        LinkedList smallerCurrentNode = countOne > countTwo ? linkedListTwo : linkedListOne;

        for (int i = 0; i < difference; i++) {
            biggerCurrentNode = biggerCurrentNode.next;
        }

        while (biggerCurrentNode != smallerCurrentNode) {
            biggerCurrentNode = biggerCurrentNode.next;
            smallerCurrentNode = smallerCurrentNode.next;
        }

        return biggerCurrentNode;
    }

    public static LinkedList mergingLinkedLists_method_3(LinkedList linkedListOne, LinkedList linkedListTwo) {

        // O(n+m) time | O(1) space
        // where n is the length of the first linked list and
        // m is the length of the second linked list.

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;

        while (nodeOne != nodeTwo) {
            if (nodeOne == null) {
                nodeOne = linkedListTwo;
            } else {
                nodeOne = nodeOne.next;
            }

            if (nodeTwo == null) {
                nodeTwo = linkedListOne;
            } else {
                nodeTwo = nodeTwo.next;
            }
        }

        return nodeOne; // or return nodeTwo;
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private static LinkedList buildLinkedListOne() {
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList one = new LinkedList(1);
        LinkedList four = new LinkedList(4);

        two.next = three;
        three.next = one;
        one.next = four;

        return two;
    }

    private static LinkedList buildLinkedListTwo() {
        LinkedList eight = new LinkedList(8);
        LinkedList seven = new LinkedList(7);
        LinkedList one = new LinkedList(1);
        LinkedList four = new LinkedList(4);

        eight.next = seven;
        seven.next = one;
        one.next = four;

        return eight;
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
