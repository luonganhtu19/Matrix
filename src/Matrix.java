import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[0][0];
        do {
            menu();
            int choice = checkNumber(" choice menu");
//            System.out.println(matrix.length+": " +matrix[0].length);
            switch (choice) {
                case 1:
                    matrix = createMatrix();
                    break;
                case 2:
                    displayMatrix(matrix);
                    break;
                case 3:
                    minElement(matrix);
                    break;
                case 4:
                    maxElement(matrix);
                    break;
                case 5:
                    sumElement(matrix);
                    break;
                case 6:
                    if (matrix.length!=matrix[0].length) matrix = createSquareMatrix();
                    sumDiagonal(matrix);
                    break;
                case 0:
                    System.out.println("Bye bye ^^");
                    return;
            }
        } while (true);
    }

    public static void menu() {
        System.out.println("Menu: ");
        System.out.println("1. Created Matrix");
        System.out.println("2. Display Matrix");
        System.out.println("3. Element has min value ");
        System.out.println("4. Element has max value ");
        System.out.println("5. Sum element of a column ");
        System.out.println("6. Sum the numbers on the diagonal of the square matrix");
        System.out.println("0. Exit");
        System.out.println("Please choice program: ");
    }

    public static int checkNumber(String mess) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean check = true;
        do {
            try {
                number = Integer.parseInt(input.nextLine());
                check = false;
            } catch (Exception ignore) {
                System.out.println("Please try again " + mess);
            }
        } while (check);
        return number;
    }

    public static int[][] createMatrix() {
        System.out.println("\n");
        System.out.println("Please size of Matrix has MxN");
        System.out.println("Enter row(M): ");
        int row = checkNumber(" value row of matrix");
        System.out.println("Enter col(N): ");
        int col = checkNumber("value col of matrix");

        int[][] matrix = new int[row][col];
        addElement(matrix);
//        displayMatrix(matrix);
        return matrix;
    }
    public static int[][] createSquareMatrix() {
        System.out.println("\n");
        System.out.println("Create Square Matrix");
        System.out.println("Please size of Matrix has MxM");
        System.out.println("Enter size: ");
        int size = checkNumber(" value size of square matrix");


        int[][] matrix = new int[size][size];
        addElement(matrix);
        return matrix;
    }
    public static void addElement(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Element  " + i + " " + j + " of matrix: ");
                matrix[i][j] = checkNumber(" element of matrix is number!");
            }
        }
    }

    public static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void maxElement(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Element has max value: " + max);
    }

    public static void minElement(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        System.out.println("Element has min value: " + min);
    }

    public static void sumElement(int[][] matrix) {
        int indexColumn=0;
        int sum=0;
        while (true) {
            System.out.println("Please index of column: ");
            indexColumn = checkNumber("index of column");
            if (indexColumn>-1&&indexColumn<matrix[0].length){
                break;
            }
            System.out.println("Please input value of index column less than "+(matrix[0].length+1)+" and greater than 0");
        }
        for (int i = 0; i < matrix.length; i++) {
            sum+=matrix[i][indexColumn-1];
        }
        System.out.println("Sum element of a column with index "+indexColumn+" is: "+sum);
    }
    public static void sumDiagonal(int[][] matrix){
        int sum=0;
        for (int i = 0; i < matrix.length; i++) {
            sum+=matrix[i][i];
        }
        System.out.println(" Sum the numbers on the diagonal of the square matrix: "+sum);
    }
}
