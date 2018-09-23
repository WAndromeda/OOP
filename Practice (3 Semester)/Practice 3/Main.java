import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MovableCircle a = new MovableCircle(0, 0, 1, 1, 10);
        Scanner scanner = new Scanner(System.in);
        int com;
        while (true){
            System.out.print("Практическая работа 3\n1. Вывести данные об окружности\n2. Сдвинуть вправо\n3. Сдвинуть влево\n" +
                    "4. Сдвинуть вверх\n5. Сдвинуть вниз\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    System.out.println(a);
                    break;
                case 2:
                    a.moveRight();
                    break;
                case 3:
                    a.moveLeft();
                    break;
                case 4:
                    a.moveUp();
                    break;
                case 5:
                    a.moveDown();
                    break;
                case 0:
                    return;
            }
        }
    }
}
