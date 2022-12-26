import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Start Matrix app
        System.out.println("Matrix Multiplication of same order");
        System.out.print("Enter the order: ");
        int order = sc.nextInt();

        // Matrix Initialization
        Matrix A = new Matrix(order);
        Matrix B = new Matrix(order);

        // Enter the matrix elements
        System.out.println("Enter the elements of 1st Matrix");
        A.readMat(sc);
        System.out.println(A);
        System.out.println("Enter the elements of 2nd Matrix");
        B.readMat(sc);
        System.out.println(B);

        // Multiply the two matrices and print
        Matrix C = A.matMultiply(B);
        System.out.println(C);
        sc.close();
    }
}

class Matrix {
    int mat[][];
    int row, col;

    // Two constructors for matrix class
    Matrix() {
        mat = null;
        row = col = 0;
    }

    Matrix(int order) {
        mat = new int[order][order];
        row = col = order;
    }

    // Input matrix
    void readMat(Scanner read) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + i + "]" + "[" + j + "] = ");
                mat[i][j] = read.nextInt();
            }
        }
    }

    // Print matrix
    public String toString() {
        String str = "\n";
        for (int i = 0; i < row; i++) {
            str += Arrays.toString(mat[i]);
            if (i < (row - 1))
                str += "\n";
        }
        return str;
    }

    // Multiply matrix
    Matrix matMultiply(Matrix m) {
        Matrix prod = new Matrix(this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                prod.mat[i][j] = 0;
                for (int k = 0; k < this.col; k++)
                    prod.mat[i][j] = prod.mat[i][j] + this.mat[i][j] * m.mat[k][j];
            }
        }
        return prod;
    }
}