import java.util.Scanner;

public class Main {
    public static final int NUMBER = 3;

    public static void main(String[] args) {
        System.out.println("Nhập 1 số và kiểm tra chia hết cho 3 hoặc 5");
        int number = Integer.parseInt(new Scanner(System.in).nextLine());
        boolean isMod3 = number % NUMBER == 0;
        boolean isMod5 = number % 5 == 0;
        if (isMod3) {
            if (isMod5) {
                System.out.println("Chia hết cho 3 và 5");
            } else {
                System.out.println("Chia hết cho 3 nhưng không chia hết cho 5");
            }
        } else {
            if (isMod5) {
                System.out.println("Không chia hết cho 3 nhưng chia hết cho 5");
            } else {
                System.out.println("Không chia hết cho 3 và 5");
            }
        }
    }
}