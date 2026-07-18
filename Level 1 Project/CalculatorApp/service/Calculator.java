package service;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero is a black hole!");
        }

        return a / b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("negative number? in Square root?");
        }

        return Math.sqrt(a);
    }

    public double percentage(double a, double b) {
        return (a / 100.0) * b;
    }

    public double factorial(int a) {
        if (a < 0) {
            throw new ArithmeticException("Cannot calculate the factorial of a negative number!");
        }

        double result = 1.0;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public double sine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public double cosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public double tangent(double degrees) {
        if (degrees % 180 == 90 || degrees % 180 == -90) {
            throw new ArithmeticException("Tangent is undefined for this angle!");
        }
        return Math.tan(Math.toRadians(degrees));
    }
}