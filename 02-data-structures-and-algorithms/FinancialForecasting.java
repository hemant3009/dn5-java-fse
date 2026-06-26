public class FinancialForecasting {

    public static double futureValue(double principal, double rate, int years) {

        if (years == 0) {
            return principal;
        }

        return (1 + rate) * futureValue(principal, rate, years - 1);
    }

    public static void main(String[] args) {

        double principal = 10000;
        double annualRate = 0.10; 
        int years = 5;

        double amount = futureValue(principal, annualRate, years);

        System.out.println("Initial Investment : ₹" + principal);
        System.out.println("Annual Growth Rate : " + (annualRate * 100) + "%");
        System.out.println("Years : " + years);
        System.out.printf("Future Value : ₹%.2f\n", amount);

        System.out.println();
        System.out.println("Time Complexity : O(n)");
        System.out.println("Space Complexity : O(n) (Recursive Call Stack)");
        System.out.println("Optimization : Use the formula");
        System.out.println("FV = PV × (1 + r)^n");
        System.out.println("This reduces computation to O(1) using Math.pow().");
    }
}