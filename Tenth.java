import java.util.*;
import java.util.Stack;

public class Tenth {
    public static void main(String[] args) {
        System.out.println("String Palindrome Test");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter any string: ");
        String inputString = in.nextLine();
        System.out.println("a. Check palindrome using stack");
        System.out.println("b. Check palindrome using queue");
        System.out.print("Enter choice: ");
        String ch = in.nextLine();
        switch (ch.charAt(0)) {
            case 'a':
            case 'A':
                if (usingStack(inputString))
                    System.out.println("The input String " + inputString + " is a palindrome.");
                else
                    System.out.println("The input String " + inputString + " is not a palindrome.");
                break;
            case 'b':
            case 'B':
                if (usingQueue(inputString))
                    System.out.println("The input String " + inputString + " is a palindrome.");
                else
                    System.out.println("The input String " + inputString + " is not a palindrome.");
                break;
            default:
                System.out.println("Invalid Choice enter the character! (TRY AGAIN)");
                break;
        }
        in.close();
    }

    static boolean usingStack(String string) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < string.length(); i++)
            stack.push(string.charAt(i));
        String reverseString = "";
        while (!stack.isEmpty())
            reverseString = reverseString + stack.pop();
        if (string.equals(reverseString))
            return true;
        else
            return false;
    }

    static boolean usingQueue(String string) {
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = string.length() - 1; i >= 0; i--)
            queue.add(string.charAt(i));
        String reverseString = "";
        while (!queue.isEmpty())
            reverseString = reverseString + queue.remove();
        if (string.equals(reverseString))
            return true;
        else
            return false;
    }
}
