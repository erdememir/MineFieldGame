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
        //System.out.println(Arrays.deepToString(this.mineFieldMap));
        System.out.println();
        System.out.println("===============");
        System.out.println();
        printField();
        while (true) {
            if (checkValidate()) {
                System.out.println("Geçersiz koordinat!");
                continue;
            }
            if (!isFail()) break;
            mapUpdater();
            System.out.println();
            System.out.println("===============");
            System.out.println();
            printField();
            if (isWin()) {
                System.out.println();
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
            this.mineFieldMap[random1][random2] = "*";
        }
    }

    void printField() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print(this.mineFieldUserMap[i][j] + "   ");
            }
            System.out.println();
        }
    }

    boolean isFail() {
        if (this.mineFieldMap[this.userRow][this.userCol].equals("*")) {
            System.out.println();
            System.out.println("BOOM!");
            return false;
        }
        if (!(this.mineFieldMap[this.userRow][this.userCol].equals("-"))){
            System.out.println();
            System.out.println("Daha önce girilmemiş bir koordinat giriniz.");
        }
        mineFieldMap[userRow][userCol] = "+";
        return true;
    }

    boolean isWin() {
        for (String[] value : this.mineFieldMap) {
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
                if (x < 0 || y < 0 || x >= this.mineFieldMap.length || y >= this.mineFieldMap[x].length) continue;
                if (this.mineFieldMap[x][y].equals("*")) {
                    this.userChoice++;
                }
            }
        }
        this.mineFieldUserMap[this.userRow][this.userCol] = String.valueOf(this.userChoice);
        this.mineFieldMap[this.userRow][this.userCol] = String.valueOf(this.userChoice);
        this.userChoice = 0;
    }

    boolean checkValidate() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Satır: ");
        this.userRow = input.nextInt();
        System.out.print("Sütun: ");
        this.userCol = input.nextInt();
        return (this.userRow < 0 || this.userCol < 0 || this.userRow > this.row || this.userCol > this.col);
    }
}