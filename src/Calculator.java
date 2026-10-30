import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentResult = 0.0;
        boolean isFirstInput = true;
        boolean isRunning = true;

        System.out.println("Калькулятор запущен. Доступные операции: +, -, *, /");
        System.out.println("Команды управления: 'C' — сброс, 's' — выход.");

        while (isRunning) {
            if (isFirstInput) {
                currentResult = readDouble(scanner, "Введите первое число: ");
                isFirstInput = false;
            }

            System.out.print("Введите операцию (+, -, *, /, C, s): ");
            char operation = Character.toLowerCase(scanner.next().charAt(0));

            switch (operation) {
                case 's':
                    System.out.println("Работа калькулятора завершена.");
                    isRunning = false;
                    break;
                case 'c':
                    currentResult = 0.0;
                    isFirstInput = true;
                    System.out.println("Результат обнулен. Текущее значение: " + currentResult);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    double operand2 = readDouble(scanner, "Введите второе число: ");
                    currentResult = calculate(currentResult, operation, operand2);
                    System.out.println("Результат: " + currentResult);
                    break;
                default:
                    System.out.println("Ошибка: неподдерживаемая операция '" + operation + "'. Попробуйте снова.");
                    break;
            }
        }

        scanner.close();
    }

    public static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            String invalidInput = scanner.next();
            System.out.println("Ошибка: '" + invalidInput + "' — это не число. Попробуйте снова.");
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    public static double calculate(double operand1, char operation, double operand2) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    System.out.println("Ошибка: деление на ноль невозможно! Предыдущий результат сохранен.");
                    return operand1;
                }
                return operand1 / operand2;
            default:
                return operand1;
        }
    }
}