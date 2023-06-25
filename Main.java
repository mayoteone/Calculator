package calc;

import java.util.Scanner;

public class Main {
    private static int a;
    private static int b;
    private static int result;

    public static void main(String[] args) {
        System.out.println("Введите математическую операция в формате a + b, a - b, a * b, a / b");
        Scanner console = new Scanner(System.in);
        System.out.print(calc(console.nextLine()));
    }
    public static String calc(String input) {
        String[] inputArray = input.split(" ");

        if (inputArray.length < 3) {
            throw new ArrayIndexOutOfBoundsException("Строка не я вляется математической операцией или отсутсвует пробел между оператором и операндом");
        }
        if (inputArray.length > 3) {
            throw new ArrayIndexOutOfBoundsException("Формат математической операции не удовлетворяет условию - два операнда и один оператор (+, -, /, *)");
        }

        switch (inputArray[1]){
            case "+" :
                parseInt(inputArray[0], inputArray[2]);
                result = a + b;
                break;
            case "-" :
                parseInt(inputArray[0], inputArray[2]);
                result = a - b;
                break;
            case "*" :
                parseInt(inputArray[0], inputArray[2]);
                result = a * b;
                break;
            case "/" :
                parseInt(inputArray[0], inputArray[2]);
                result = a / b;
                break;
            default :
                throw new RuntimeException("Отсутствует символ математической операции");
        }
        return Integer.toString(result);
    }

    public static void parseInt(String a, String b) {
        if ((a.contains(".") && a.length() > 2) || (b.contains(".") && b.length() > 2)) {
            throw new RuntimeException("Калькулятор умеет работать только с целыми числами");
        }
        Main.a = Integer.parseInt(a);
        Main.b = Integer.parseInt(b);

        if (Main.a > 10 || Main.a < 1 || Main.b > 10 || Main.b < 1) {
                throw new RuntimeException("Калькулятор принимает числа в диапазоне от 1 до 10 включительно");
        }
    }
}
