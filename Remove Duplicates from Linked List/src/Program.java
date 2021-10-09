class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList(1);
        LinkedList linkedList2 = new LinkedList(1);
        LinkedList linkedList3 = new LinkedList(3);
        LinkedList linkedList4 = new LinkedList(4);
        LinkedList linkedList5 = new LinkedList(4);
        LinkedList linkedList6 = new LinkedList(4);
        LinkedList linkedList7 = new LinkedList(5);
        LinkedList linkedList8 = new LinkedList(6);
        LinkedList linkedList9 = new LinkedList(6);

        linkedList1.next = linkedList2;
        linkedList2.next = linkedList3;
        linkedList3.next = linkedList4;
        linkedList4.next = linkedList5;
        linkedList5.next = linkedList6;
        linkedList6.next = linkedList7;
        linkedList7.next = linkedList8;
        linkedList8.next = linkedList9;
        linkedList9.next = null;

        // The elements in the LinkedList are sorted in this case.

        LinkedList result = removeDuplicatesFromLinkedList(linkedList1);

        System.out.print("HEAD -> ");
        while (result != null)
        {
            System.out.print(result.value);
            System.out.print(" > ");
            result = result.next;
        }
        System.out.println("NULL");
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        // O(n) time |  O(1) space
        // where n is the number of nodes in the linked list.

        LinkedList currentNode = linkedList;

        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            while (nextNode != null && currentNode.value == nextNode.value) {
                nextNode = nextNode.next;
            }

            currentNode.next = nextNode;
            currentNode = currentNode.next; // or
//            currentNode = nextNode;
        }
        return linkedList;
    }
}
