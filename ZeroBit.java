import java.util.*;
public class ZeroBit {
    static  double countStrings(double n) {
        double endWithZero[] = new double [(int)n];
        double endWithOne[] = new double [(int)n];
        endWithZero[0] = endWithOne[0] = 1;
        int k = (int)n;
        for (int i = 1; i < k; i++) {
            endWithZero[i] = endWithZero[i - 1] + endWithOne[i - 1];
            endWithOne[i] = endWithZero[i - 1];
        }
        return endWithZero[k - 1] + endWithOne[k - 1];
    }
    /* Driver program to test above function */
    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        if (t < 0 || t > Math.pow(10, 3))
            System.exit(0);
        double mod = Math.pow(10, 9) + 7;
        double[] result = new double [t];

        for (int i = 0; i < t; i++) {
            double n = scan.nextDouble();

            if (n < 0 || n > Math.pow(10, 15))
                System.exit(0);

            result[i] = countStrings(n) % mod;

        }
        for (int i = 0; i < t; i++)
            System.out.println((int)result[i]);
    }
}
