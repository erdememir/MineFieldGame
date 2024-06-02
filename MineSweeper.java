import java.util.Arrays;
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
    int userChoice = 0;

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
        while (true) {
            if (checkValidate()) {
                System.out.println("Geçersiz koordinat!");
                continue;
            }
            if (!isFail()) break;
            mapUpdater();
            printField();
            if (isWin()) {
                System.out.println("Tebrikler.");
                break;
            }
        }
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

    boolean isFail() {
        if (mineFieldMap[userRow][userCol].equals("*")) {
            System.out.println("bom");
            return false;
        }
        //mineFieldMap[userRow][userCol] = "+";
        return true;
    }

    boolean isWin() {
        for (String[] value : mineFieldMap) {
            for (String value2 : value) {
                if (value2.equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    void mapUpdater() {
        for (int x = this.userRow - 1; x <= this.userRow + 1; x++) {
            for (int y = this.userCol - 1; y <= this.userCol + 1; y++) {
                if (x == this.userRow && y == this.userCol) continue;
                if (x < 0 || y < 0 || x >= mineFieldMap.length || y >= mineFieldMap[x].length) continue;
                if (mineFieldMap[x][y].equals("*")) {
                    this.userChoice++;
                }
            }
        }
        mineFieldMap[userRow][userCol] = String.valueOf(this.userChoice);

        this.userChoice = 0;
    }

    boolean checkValidate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Satır: ");
        this.userRow = input.nextInt();
        System.out.print("Sütun: ");
        this.userCol = input.nextInt();
        return (userRow < 0 || userCol < 0 || userRow > this.row || userCol > this.col);
    }
}