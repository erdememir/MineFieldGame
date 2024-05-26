import java.util.Random;

public class MineSweeper {
    String[][] mineFieldMap;
    String[][] mineFieldUserMap;
    int row;
    int col;
    int mineCount;

    MineSweeper(int row, int col) {
        this.mineFieldMap = new String[row][col];
        this.mineFieldUserMap = new String[row][col];
        this.mineCount = (row * col) / 4;
        this.row = row;
        this.col = col;
    }

    void run() {
        fillArray();
        randomNumber();
        printField();
    }

    void fillArray() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.mineFieldMap[i][j] = "-";
                this.mineFieldUserMap[i][j] = "-";
            }
        }
    }

    public void randomNumber() {
        Random rGen = new Random();
        for (int i = 0; i < this.mineCount; i++) {
            int random1 = rGen.nextInt(this.row);
            int random2 = rGen.nextInt(this.col);
            mineFieldMap[random1][random2] = "*";
        }
    }

    void printField() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print(this.mineFieldMap[i][j] + "   ");
            }
            System.out.println();
        }
    }
}