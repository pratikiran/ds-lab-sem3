import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("2D Array format for Sparse Matrix");
        System.out.print("Enter Number of Rows :");
        int rw = read.nextInt();
        System.out.print("Enter Number of Columns :");
        int cl = read.nextInt();
        int sparseMatrix[][] = new int[rw][cl];

        // Read Sparse Matrix in 2D array
        System.out.println("Enter the Values of Matrix:");
        for (int row = 0; row < rw; row++)
            for (int column = 0; column < cl; column++)
                sparseMatrix[row][column] = read.nextInt();

        // Finding total non-zero values in the sparse matrix
        int size = 0;
        for (int row = 0; row < rw; row++)
            for (int column = 0; column < cl; column++)
                if (sparseMatrix[row][column] != 0)
                    size++;

        // Defining result Matrix
        int resultMatrix[][] = new int[3][size];

        // Generating result matrix
        int k = 0;
        for (int row = 0; row < rw; row++)
            for (int column = 0; column < cl; column++)
                if (sparseMatrix[row][column] != 0) {
                    resultMatrix[0][k] = row;
                    resultMatrix[1][k] = column;
                    resultMatrix[2][k] = sparseMatrix[row][column];
                    k++;
                }

        // Displaying result matrix
        System.out.println("Triplet Representation : ");
        for (int row = 0; row < 3; row++) {
            if (row == 0)
                System.out.print("Row:\t");
            if (row == 1)
                System.out.print("Column:\t");
            if (row == 2)
                System.out.print("Value:\t");
            for (int column = 0; column < size; column++)
                System.out.print(resultMatrix[row][column] + " ");
            System.out.println();
        }
        
        // Searching an element in sparse matrix
        System.out.print("Enter an element to search in sparse matrix:");
        int key = read.nextInt();
        int flag = 0;
        for (int index = 0; index < size; index++) {
            if (resultMatrix[2][index] == key) {
                System.out.println("Element found at (" +
                        resultMatrix[0][index] + "," + resultMatrix[1][index] + ")");
                flag = 1;
            }
        }
        if (flag == 0)
            System.out.println("Element not found");
        read.close();
    }
}
