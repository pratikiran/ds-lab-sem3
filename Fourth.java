import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Queue Implementation Using Array");
        System.out.print("Enter the size of the Queue: ");
        int size = read.nextInt();

        ArrayQueue queue = new ArrayQueue(size);

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
                        System.out.println(ele + "successfully added to queue");
                    else
                        System.out.println("Queue Overflow");
                    break;
                case 2:
                    ele = queue.dequeue();
                    if (ele == -1)
                        System.out.println("Queue Underflow");
                    else
                        System.out.println(ele + " dequeued from queue");
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

class ArrayQueue {
    private int arr[];
    private int front;
    private int rear;
    private int capacity;
    private int count;

    ArrayQueue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public int dequeue() {
        if (isEmpty())
            return -1;
        else {
            int ele = arr[front];
            front = (front + 1) % capacity;
            count--;
            return ele;
        }
    }

    public boolean enqueue(int item) {
        if (isFull())
            return false;
        else {
            rear = (rear + 1) % capacity;
            arr[rear] = item;
            count++;
            return true;
        }
    }

    public void printQueue() {
        if (!isEmpty()) {
            for (int i = front; i <= rear; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        } else
            System.out.println("Queue is Empty");
    }

    public int size() {
        return count;
    }

    public Boolean isEmpty() {
        return (size() == 0);
    }

    public Boolean isFull() {
        return (size() == capacity);
    }
}