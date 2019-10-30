public class Queens {
    int QUEENS = 8;
    int ROWS = 8;
    int COLS = 8;
    int counter = 0;
    boolean queensPlaced = false;

    public int[][] createBoard() {
        int[][] board = new int[ROWS][COLS];
        return board;
    }

    public void printBoard(int[][] board) {
        System.out.println(" ");
        for (int[] layer : board) {
            System.out.println();
            for (int value : layer) {
                System.out.print("   ");
                System.out.print(value);
            }
        }
    }

    public boolean placeQueen(int[][] board, int row, int col) {
        printBoard(board);

        if (counter == QUEENS) {
            return true;
        }
        else {
            /*
                For each row in the column
                    Check if we can place a queen
                        Place the queen
                        Increment counter
                    If not
                       return placeQueen(board, 0, col + 1)
                    remove Queen you placed here

                return false

             */

            for (int i = 0; i < 8; i++) {
                if (isValid(board, i, col)) {
                    board[i][col] = 1;
                    counter++;

                    if (placeQueen(board, 0, col + 1)) {
                        return true;
                    }

                    board[i][col] = 0;
                    counter--;
                }
            }

            return false;

        }
    }

    public boolean isValid(int[][] board, int row, int col) {
        for (int i = 0; i < 8; i++) {
            if (board[row][i] == 1) {
                return false;
            }

            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }


        for (int i = row, j = col; j >= 0 && i < ROWS; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; j < COLS && i < ROWS; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; j < COLS && i >= 0; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public void solve() {
        int[][] myBoard = createBoard();
        printBoard(myBoard);
        placeQueen(myBoard, 0, 0);
        System.out.println();
//        printBoard(myBoard);
    }


    public static void main(String[] args) {
       Queens queenOne = new Queens();
       queenOne.solve();
    }
}
