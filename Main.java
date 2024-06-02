import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("Mayın tarlası oyununa hoşgeldiniz. İyi Eğlenceler!");
                System.out.print("Satır sayısı giriniz: ");
                int row = input.nextInt();
                System.out.print("Sütün sayısı giriniz: ");
                int col = input.nextInt();
                if ((col >= 2 && row >= 2) && (col <= 30 && row <= 30)) {
                    MineSweeper mine = new MineSweeper(row, col);
                    mine.run();
                    break;
                } else {
                    System.out.println("Minimum satır \"2\", maksimum satır \"30\" olmalıdır.");
                    // Gereksiz büyük sayı girişini önlemek adına maksimum satır sayısı 30 olarak girilmiştir.
                }
            }
        }
    }