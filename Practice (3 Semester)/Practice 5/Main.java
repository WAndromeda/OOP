import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long b;
        int com, sum;
        Integer[] a = {1, 2, 3, 4, 5};
        while (true){
            Prac5Class.menu();
            com = scanner.nextInt();
            switch (com){
                case 1:
                    System.out.print("Введите число N: ");
                    com = scanner.nextInt();
                    sum = Prac5Class.sum(com);
                    System.out.println("Сумма цифр числа " + com + " : " + sum);
                    break;
                case 0:
                    return;
            }
        }

    }
}

class Prac5Class {
    static void menu(){
        System.out.print("\nПрактическая работа 5\n1. Вывести на экран сумму цифр введённого числа с помощью рекурсии.\n0. Выход\n> ");
    }

    static int sum(int N){
        return N == 0 ? 0 : (N % 10) + sum(N/10);
    }

}
