package org.example.cw6;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println("Validete:" + isValidSudoku(board));
    }

    /**
     * Проверяет валидность char матрицы по условиям:
     * 1) For - проверяет наличие повторяющихся символов в строках
     * 2) For - проверяет наличие повторяющихся символов в столбцах
     * 3) For - проверяет наличие повторяющихся символов в блоках 3x3
     */
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] masPovtor = new int[10];
            boolean q = true;
            for (int j = 0; j < 9; j++) {
                int p = Character.getNumericValue(board[i][j]);
                if (board[i][j] > '0' && board[i][j] <= '9')
                    if (masPovtor[p] < 1)
                        masPovtor[p]++;
                    else return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            int[] masPovtor = new int[10];
            boolean q = true;
            for (int j = 0; j < 9; j++) {
                int p = Character.getNumericValue(board[j][i]);
                if (board[j][i] > '0' && board[j][i] <= '9')
                    if (masPovtor[p] < 1)
                        masPovtor[p]++;
                    else return false;
            }
        }
        int[] masPovtor = new int[30];//разделил матрицу char на 3 блока по i => заводить 9 массивов
        int[] masPovtor2 = new int[30];//думаю не очень удобно поэтому расширил объем каждого массива
        int[] masPovtor3 = new int[30];//в индексах массивов с 0 по 9 лежат значения первых трех блоков
        int k = -10; //а последующий ( 2-й с 10 по 19), 3-й с 20 по 29
        boolean q = true;
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0)
                k += 10;// разделение блоков по строкам
            for (int j = 0; j < 9; j++) {
                int p = Character.getNumericValue(board[j][i]);
                if (board[j][i] > '0' && board[j][i] <= '9') {
                    if (j < 3)// разделение блоков по столбцам
                        if (masPovtor[p + k] < 1)
                            masPovtor[p + k]++;
                        else return false;
                    if (j >= 3 && j <= 5)
                        if (masPovtor2[p + k] < 1)
                            masPovtor2[p + k]++;
                        else return false;
                    if (j > 5)
                        if (masPovtor3[p + k] < 1)
                            masPovtor3[p + k]++;
                        else return false;
                }
            }
        }
        return true;
    }
}
