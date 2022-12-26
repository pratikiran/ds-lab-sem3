import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Stack Implementation Using Array");
        System.out.print("Enter the size of the Stack: ");
        int size = read.nextInt();
        
        ArrayStack stack = new ArrayStack(size);

        while (flag) {
            System.out.println("1. Push element in stack");
            System.out.println("2. Pop an element from Stack");
            System.out.println("3. Display the Stack");
            System.out.println("4. Exit");
            System.out.print("Select your option: ");
            int ch = read.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter the element to push:");
                    int ele = read.nextInt();
                    if (stack.push(ele))
                        System.out.println(ele + "successfully pushed on stack");
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

class ArrayStack {
    int top;
    int maxSize;
    int a[];

    ArrayStack(int size) {
        a = new int[size];
        top = -1;
        maxSize = size;
    }

    void printStack() {
        if (!isEmpty()) {
            for (int i = top; i > -1; i--)
                System.out.println(a[i]);
        } else
            System.out.println("Stack is Empty");
    }

    boolean isEmpty() {
        return (top < 0);
    }

    boolean isFull() {
        return (top >= (maxSize - 1));
    }

    boolean push(int x) {
        if (isFull())
            return false;
        else {
            a[++top] = x;
            return true;
        }
    }

    int pop() {
        if (isEmpty())
            return -1;
        else
            return a[top--];
    }
}
