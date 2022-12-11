import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HorseStep {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        sol.solveHorseStep(4);

    }

    static class Solution1 {
        static int[][] board;
        int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        int size;
        int n = 4;

        public void solveHorseStep(int n) {
            board = new int[n][n];
            size = 16;
            backtrack(0, 0, 1);
        }

        public void backtrack(int rowFirst, int colFirst, int stepCounter) {
            board[rowFirst][colFirst] = stepCounter;
            if (stepCounter == 15) {
                printBoard();
                System.out.println("Max количество шагов: "+stepCounter);
//                board[rowFirst][colFirst] = 0;
                return;
            }
            for (int p = 0; p < moves.length; p++) {
                int newRow = rowFirst + moves[p][0];
                int newCol = colFirst + moves[p][1];


                if (canPlace(newRow, newCol)) {
                    backtrack(newRow, newCol, stepCounter + 1);
                }
            }
            board[rowFirst][colFirst] = 0;
        }

        public boolean canPlace(int i, int j) {
            return i >= 0 && j >= 0 && i < n && j < n && board[i][j] == 0;
        }

        public static void printBoard() {
            for (var element : board) {
                System.out.println(Arrays.toString(element));

            }
        }
    }
}


