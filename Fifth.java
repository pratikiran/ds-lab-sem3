import java.util.Scanner;

public class Fifth {
    static Stack operators = new Stack();

    public static void main(String[] args) {
        String infix;
        Scanner read = new Scanner(System.in);
        System.out.print("\nEnter the algebraic expression in infix: ");
        infix = read.nextLine();
        // Output as postfix
        System.out.println("The expression in postfix is: " + toPostfix(infix));
        read.close();
    }

    private static String toPostfix(String infix) {
        char symbol;
        String postfix = "";
        for (int i = 0; i < infix.length(); ++i) {
            symbol = infix.charAt(i);
            // If its space, then continue
            if (Character.isSpaceChar(symbol))
                continue;
            // If it's an operand, add it to the string
            if (Character.isLetter(symbol))
                postfix = postfix + symbol;
            else if (symbol == '(')
                operators.push(symbol);
            else if (symbol == ')') {
                while (operators.peek() != '(')
                    postfix = postfix + operators.pop();
                operators.pop();
            } else {
                while (!operators.isEmpty() && !(operators.peek() == '(') && prec(symbol) <= prec(operators.peek()))
                    postfix = postfix + operators.pop();
                operators.push(symbol);
            }
        }
        while (!operators.isEmpty())
            postfix = postfix + operators.pop();
        return postfix;
    }

    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
}

class Stack {
    char a[] = new char[100];
    int maxSize = 50;
    int top = -1;

    boolean isFull() {
        return (top >= (maxSize - 1));
    }

    void push(char c) {
        if (isFull()) {
            System.out.println("Stack full , no room to push , size=50");
            System.exit(0);
        } else
            a[++top] = c;
    }

    char pop() {
        return a[top--];
    }

    boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    char peek() {
        return a[top];
    }
}
