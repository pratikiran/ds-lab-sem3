import java.util.Scanner;

public class Seventh {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the expression in postfix: ");
        String exp = read.nextLine();
        System.out.println("Result = " + evaluatePostfix(exp));
        read.close();
    }

    static int evaluatePostfix(String exp) {
        Stack stack = new Stack();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isSpaceChar(c))
                continue;
            else if (Character.isAlphabetic(c)) {
                System.out.print("Expression should conatin only digits");
                System.exit(0);
            } else if (Character.isDigit(c)) {
                int n = 0;
                while (Character.isDigit(c)) {
                    n = n * 10 + (int) (c - '0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                stack.push(n);
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}

class Stack {
    Node top;

    Stack() {
        top = null;
    }

    class Node
    {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
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

    int peek() {
        return top.data;
    }
}
