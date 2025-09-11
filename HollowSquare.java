import java.util.Scanner;

public class HollowSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (n >= 5): ");
        int n = sc.nextInt();

        if (n < 5) {
            System.out.println("The number must be 5 or greater.");
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // Print a star if it's on the border, or at the center
                if (i == 1 || i == n || j == 1 || j == n || (i ==  j ) || i+j==n) {
                    System.out.print("*");
                } else {
                    System.out.print(" "); // Print two spaces for the hollow part
                }
            }
            System.out.println("  "); // Move to the next line
        }
        sc.close();
    }
}