package tutorial;

import java.util.EmptyStackException;

public class ComplexProgram {

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        
        return true;
    }


    public static int sumDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        int num1 = 17;
        System.out.println(num1 + " is prime? " + isPrime(num1));
 
        int num2 = 123456;
        int digitSum = sumDigits(num2);
        System.out.println("sum of digits" + num2 + ": " + digitSum);
    }
}
