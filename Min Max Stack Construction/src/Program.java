public class Program {

    public static void main(String[] args) {
        MinMaxStack_Solution_1 stack = new MinMaxStack_Solution_1();
        MinMaxStack_Solution_2 stack2 = new MinMaxStack_Solution_2();
        MinMaxStack_Solution_3 stack3 = new MinMaxStack_Solution_3();

        System.out.println("----------------------------------------");
        System.out.println("Stack 1");
        System.out.println("----------------------------------------");

        System.out.println("Pushed 5");
        stack.push(5);
        System.out.println("Min: " + stack.getMin());
        System.out.println("Max: " + stack.getMax());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pushed 7");
        stack.push(7);
        System.out.println("Min: " + stack.getMin());
        System.out.println("Max: " + stack.getMax());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pushed 2");
        stack.push(2);
        System.out.println("Min: " + stack.getMin());
        System.out.println("Max: " + stack.getMax());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop:" + stack.pop());
        System.out.println("Pop:" + stack.pop());
        System.out.println("Min: " + stack.getMin());
        System.out.println("Max: " + stack.getMax());
        System.out.println("Peek: " + stack.peek());

        System.out.println("----------------------------------------");
        System.out.println("Stack 2");
        System.out.println("----------------------------------------");

        System.out.println("Pushed 5");
        stack2.push(5);
        System.out.println("Min: " + stack2.getMin());
        System.out.println("Max: " + stack2.getMax());
        System.out.println("Peek: " + stack2.peek());
        System.out.println("Pushed 7");
        stack2.push(7);
        System.out.println("Min: " + stack2.getMin());
        System.out.println("Max: " + stack2.getMax());
        System.out.println("Peek: " + stack2.peek());
        System.out.println("Pushed 2");
        stack2.push(2);
        System.out.println("Min: " + stack2.getMin());
        System.out.println("Max: " + stack2.getMax());
        System.out.println("Peek: " + stack2.peek());
        System.out.println("Pop:" + stack2.pop());
        System.out.println("Pop:" + stack2.pop());
        System.out.println("Min: " + stack2.getMin());
        System.out.println("Max: " + stack2.getMax());
        System.out.println("Peek: " + stack2.peek());

        System.out.println("----------------------------------------");
        System.out.println("Stack 3");
        System.out.println("----------------------------------------");

        System.out.println("Pushed 5");
        stack3.push(5);
        System.out.println("Min: " + stack3.getMin());
        System.out.println("Max: " + stack3.getMax());
        System.out.println("Peek: " + stack3.peek());
        System.out.println("Pushed 7");
        stack3.push(7);
        System.out.println("Min: " + stack3.getMin());
        System.out.println("Max: " + stack3.getMax());
        System.out.println("Peek: " + stack3.peek());
        System.out.println("Pushed 2");
        stack3.push(2);
        System.out.println("Min: " + stack3.getMin());
        System.out.println("Max: " + stack3.getMax());
        System.out.println("Peek: " + stack3.peek());
        System.out.println("Pop:" + stack3.pop());
        System.out.println("Pop:" + stack3.pop());
        System.out.println("Min: " + stack3.getMin());
        System.out.println("Max: " + stack3.getMax());
        System.out.println("Peek: " + stack3.peek());
    }
}
