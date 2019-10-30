public class Sudoku {
    private int[][] sudoku;
    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int EMPTY = 0;

    public Sudoku() {
        sudoku = new int[9][9];
    }

    private boolean isInRow(int row, int number) {
        for(int i = 0; i < ROWS; i++) {
            if(sudoku[row][i] == number) {
                return true;
            }
        }
        return false;
    }



    private boolean isInColumn(int col, int number) {
        for (int i = 0; i < COLUMNS; i++) {
            if (sudoku[i][col] == number) {
                return true;
            }
        }
        return false;
    }


    private boolean isInBox(int row, int col, int number) {
        int boxRow = row - row % 3; //Gives the correct row number for box
        int boxColumn = col - col % 3; //Gives the correct column number for box
        for (int i = boxRow ; i < boxRow + 3 ; i++) { //Checks for the next 3 rows
            for (int j = boxColumn; j < boxColumn + 3 ; j++) { //Checks for the next 3 columns
                if (sudoku[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int number)
    {
        //If any of the methods above return true, then isValid will return the opposite
        return !(isInRow(row, number) || isInColumn(col, number) || isInBox(row, col, number));
    }

    public boolean solveSudoku() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (sudoku[row][col] == EMPTY) {
                    //enters every number into rows until it needs to backtrack
                    for (int number = 1; number <= 9; number++) {
                        if (isValid(row, col, number)) {
                            sudoku[row][col] = number;
                            if (solveSudoku()) {
                                return true;
                            }
                            //backtracks wrong move
                            else {
                                sudoku[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard()
    {
        System.out.println("___________________________________");
        for (int i = 0; i < ROWS; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------------------------------");
            }
            for (int j = 0; j < COLUMNS; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + sudoku[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println("___________________________________");
    }

    public static void main(String[] args) {
        Sudoku sudoku1 = new Sudoku();
        sudoku1.printBoard();
        sudoku1.solveSudoku();
        sudoku1.printBoard();
    }

}
