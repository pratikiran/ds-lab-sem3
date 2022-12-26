import java.util.Scanner;

public class Eighth {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Linked List Queue");
        LinkedListQueue queue = new LinkedListQueue();
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add an element in to queue");
            System.out.println("2. Remove an element from queue");
            System.out.println("3. Display the queue");
            System.out.println("4. Exit");
            System.out.print("Select your option: ");
            int ch = read.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    int ele = read.nextInt();
                    if (queue.enqueue(ele))
                        System.out.println(ele + " successfully added to the queue");
                    else
                        System.out.println("Queue Overflow");
                    break;
                case 2:
                    ele = queue.dequeue();
                    if (ele == -1)
                        System.out.println("Queue Underflow");
                    else
                        System.out.println(ele + " removed out of queue");
                    break;
                case 3:
                    System.out.println("Queue contents");
                    queue.printQueue();
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

class LinkedListQueue {
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node rear, front;

    LinkedListQueue() {
        front = rear = null;
    }

    int dequeue()
    {
        if (front == null)
            return -1;
        Node temp = front;
        front = front.next;
        if (front == null)
            rear = null;
        return temp.data;
    }

    boolean enqueue(int item)
    {
        Node node = new Node(item);
        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        return (rear != null);
    }

    void printQueue() {
        Node n = front;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    boolean isEmpty() {
        return rear == null && front == null;
    }
}
