import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    String[][] mineFieldMap;
    String[][] mineFieldUserMap;
    int row;
    int col;
    int mineCount;
    int userRow;
    int userCol;

    MineSweeper(int row, int col) {
        this.mineFieldMap = new String[row][col];
        this.mineFieldUserMap = new String[row][col];
        this.mineCount = (row * col) / 4;
        this.row = row;
        this.col = col;
        this.userRow = userRow;
        this.userCol = userCol;
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

    int rowSelection(int userRow) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hamle yapmak istediğiniz satırı seçiniz: ");
        userRow = input.nextInt();
        return userRow;
    }

    int colSelection(int userCol) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hamle yapmak istediğiniz sütunu seçiniz: ");
        userCol = input.nextInt();
        return userCol;
    }

    boolean isBound(int userRow, int userCol) {
        if ((userCol > col) && (userRow > row) && (userCol < 0) && (userRow < 0)) {
            System.out.println("Lütfen dahil olan koordinatları giriniz.");
            return false;
        } else {
            return true;
        }
    }

    boolean fail() {
        if(mineFieldMap[userRow][userCol].equals("*")){
            return true;
        }
        return false;
    }
}