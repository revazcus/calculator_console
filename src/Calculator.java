import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator extends Converter {
    private static Boolean isArabic;

    public static void main(String[] args) throws Exception {
        Start();

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input:");
            String user = scanner.nextLine();

            if (user.equals("exit")) {
                System.out.println("Завершение работы");
                break;
            }

            String[] input = user.split(" ");
            if (input.length != 3)  {
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            String operation = input[1];
            String value1 = input[0];
            String value2 = input[2];
            int num1;
            int num2;


            if (Pattern.matches("[a-zA-Z]+", value1) && (Pattern.matches("[a-zA-Z]+", value2))) {
                num1 = toArabic(value1);
                num2 = toArabic(value2);
                isArabic = false;
            } else if (Pattern.matches("[0-9]+", value1) && (Pattern.matches("[0-9]+", value2))) {
                num1 = Integer.parseInt(value1);
                num2 = Integer.parseInt(value2);
                isArabic = true;
            } else {
                throw new Exception("Числа должны быть только арабские или только римские");
            }
                if ((num1 > 0 && num1 <= 10) && (num2 > 0 && num2 <= 10)) {
                    System.out.println("Output:");
                    System.out.println(calculate(num1, operation, num2));

            } else {
                throw new Exception("используйте два числа от 1 до 10");
            }

        }
    }

    private static String calculate(int num1, String operation, int num2) throws Exception {
        int result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new Exception("символ операции не поддерживается");
        }
        if (isArabic) {
            return Integer.toString(result);
        } else {
            if (result > 0){
                return toRome(result);
            } else {
                throw new Exception("римкое число не может быть нулём/отрицательным");
            }

        }

    }

    private static void Start() {
        System.out.println("Доступен ввод и подсчёт арабских/римских чисел от 1 до 10");
        System.out.println("Возможные операции + | - | * | /");
        System.out.println("Пример ввода: 1 + 1 | I + I");
        System.out.println("Для выхода введите: exit");
    }


}







