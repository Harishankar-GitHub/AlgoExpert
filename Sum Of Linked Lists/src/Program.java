public class Program {

    public static void main(String[] args) {
        LinkedList linkedListOne = buildLinkedListOne();
        LinkedList linkedListTwo = buildLinkedListTwo();

        printLinkedList(linkedListOne);
        printLinkedList(linkedListTwo);

        LinkedList sumOfLinkedLists = sumOfLinkedLists(linkedListOne, linkedListTwo);

        printLinkedList(sumOfLinkedLists);
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {

        // O(max(n,m)) time | O(max(n,m)) space
        // where n is the length of the first linked list
        // and m is the length of the second linked list.

        // This variable will store a dummy node whose .next attribute will point to the head of our new LL.
        LinkedList newLinkedListHeaderPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeaderPointer;
        int carry = 0;

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;

        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = nodeOne != null ? nodeOne.value : 0;
            int valueTwo = nodeTwo != null ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int remainder = sumOfValues % 10;
            LinkedList newNode = new LinkedList(remainder);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10;
            nodeOne = nodeOne != null ? nodeOne.next : null;
            nodeTwo = nodeTwo != null ? nodeTwo.next : null;
        }

        return newLinkedListHeaderPointer.next;
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
        LinkedList four = new LinkedList(4);
        LinkedList seven = new LinkedList(7);
        LinkedList one = new LinkedList(1);

        two.next = four;
        four.next = seven;
        seven.next = one;

        return two;
    }

    private static LinkedList buildLinkedListTwo() {
        LinkedList nine = new LinkedList(9);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);

        nine.next = four;
        four.next = five;

        return nine;
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
