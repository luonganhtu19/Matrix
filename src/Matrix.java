import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix=new int[0][0];
        do {
            menu();
            int choice=checkNumber(" choice menu");
//            System.out.println(matrix.length+": " +matrix[0].length);
            switch (choice){
                case 1:
                     matrix=createMatrix();
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
                case 0:
                    System.out.println("Bye bye ^^");
                    return;
            }
        }while (true);
    }
    public static void menu(){
        System.out.println("Menu: ");
        System.out.println("1. Created Matrix");
        System.out.println("2. Display Matrix");
        System.out.println("3. Element has min value ");
        System.out.println("4. Element has max value ");
        System.out.println("0. Exit");
        System.out.println("Please choice program: ");
    }
    public static int checkNumber(String mess){
        Scanner input = new Scanner(System.in);
        int number=0;
        boolean check=true;
        do {
            try {
                number=Integer.parseInt(input.nextLine());
                check=false;
            }catch (Exception ignore){
                System.out.println("Please try again "+ mess);
            }
        }while (check);
        return number;
    }

    public static int[][] createMatrix(){
        System.out.println("\n");
        System.out.println("Please size of Matrix has MxN");
        System.out.println("Enter row(M): ");
        int row=checkNumber(" value row of matrix");
        System.out.println("Enter col(N): ");
        int col=checkNumber("value col of matrix");

        int[][] matrix=new int[row][col];
        addElement(matrix);
//        displayMatrix(matrix);
        return matrix;
    }
    public static void addElement(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("Element  "+i+" "+j+ " of matrix: ");
                matrix[i][j]=checkNumber(" element of matrix is number!");
            }
        }
    }
    public static void displayMatrix(int[][] matrix){
        System.out.println("Matrix : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    public static void maxElement(int[][] matrix){
        int max=matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]>max){
                    max=matrix[i][j];
                }
            }
        }
        System.out.println("Element has max value: "+ max);
    }
    public static void minElement(int[][] matrix){
        int min=matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]<min){
                    min=matrix[i][j];
                }
            }
        }
        System.out.println("Element has min value: "+ min);
    }
}
