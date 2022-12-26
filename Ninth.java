import java.util.Scanner;

public class Ninth {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter string with parenthesis [],{},or( )");
        String str = read.nextLine();
        if (str.isEmpty())
            System.out.println("Empty String");
        else
            System.out.println(checkBalance(str));
        read.close();
    }

    public static String checkBalance(String str) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{')
                stack.push(ch);
            else if ((ch == ']' || ch == '}' || ch == ')') && (!stack.isEmpty()))
                if (((char) stack.peek() == '(' && ch == ')')
                        || ((char) stack.peek() == '{' && ch == '}')
                        || ((char) stack.peek() == '[' && ch == ']'))
                    stack.pop();
                else
                    return "Not Balanced";
            else if ((ch == ']' || ch == '}' || ch == ')'))
                return "Not Balanced";
        }
        if (stack.isEmpty())
            return "Balanced Parenthesis";
        else
            return "Not Balanced";
    }
}

class Stack {
    private Object[] data;
    private int top = 0;
    private int size = 0;

    Stack() {
        this.size = 30;
        data = new Object[this.size];
    }

    void push(Object o) {
        if (top >= size)
            this.increaseSize();
        this.data[top] = o;
        top++;
    }

    Object pop() {
        if (top != 0) {
            Object obj = data[top - 1];
            this.data[top - 1] = null;
            top--;
            return obj;
        } else
            return null;
    }

    Object peek() {
        if (top != 0)
            return this.data[top - 1];
        else
            return null;
    }

    boolean isEmpty() {
        return top == 0 ? true : false;
    }

    int getStackSize() {
        return top;
    }

    private void increaseSize() {
        Object[] temp = new Object[size];
        size = size * 2;
        for (int i = 0; i < top; i++)
            temp[i] = this.data[i];
        this.data = new Object[this.size];
        for (int i = 0; i < top; i++)
            this.data[i] = temp[i];
    }
}