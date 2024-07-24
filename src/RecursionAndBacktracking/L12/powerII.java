package RecursionAndBacktracking.L12;

public class powerII{

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n > 0) {
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return x * myPow(x * x, n / 2);
            }
        } else {
            n = Math.abs(n);
            if (n % 2 == 0) {
                return 1 / myPow(x * x, n / 2);
            } else {
                return 1 / (x * myPow(x * x, n / 2));
            }
        }
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -10;
        double result =myPow(x, n);
        System.out.println("Result: " + result);
    }
}

