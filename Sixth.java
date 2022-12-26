import java.util.Scanner;

public class Sixth {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Linked List Stack");
        LinkedListStack stack = new LinkedListStack();
        boolean flag = true;
        while (flag) {
            System.out.println("1. Push element in stack");
            System.out.println("2. Pop an element from stack");
            System.out.println("3. Display the stack");
            System.out.println("4. Exit");
            System.out.print("Select your option: ");
            int ch = read.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int ele = read.nextInt();
                    if (stack.push(ele))
                        System.out.println(ele + " successfully pushed on stack");
                    else
                        System.out.println("Stack Overflow");
                    break;
                case 2:
                    ele = stack.pop();
                    if (ele == -1)
                        System.out.println("Stack Underflow");
                    else
                        System.out.println(ele + " popped out of the stack");
                    break;
                case 3:
                    System.out.println("Stack contents");
                    stack.printStack();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Inavlid Choice try again...");
            }
        }
        read.close();
    }
}

class LinkedListStack {
    Node top;

    LinkedListStack() {
        top = null;
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printStack() {
        Node n = top;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    boolean push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        return (top != null);
    }

    boolean isEmpty() {
        return (top == null);
    }

    int pop() {
        int ele = -1;
        if (isEmpty())
            return -1;
        else if (top != null) {
            ele = top.data;
            top = top.next;
        } else
            top = null;
        return ele;
    }
}