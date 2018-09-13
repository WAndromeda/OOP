import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args){
        Circle a = new Circle(15, 0, 0);
        Scanner scanner = new Scanner(System.in);
        double k;
        int com;
        while (true){
            System.out.print("Лабораторная работа 2 | Задание 1\n1. Изменить радиус\n2. Изменить центр\n3. Вывести центр окружности\n4. Вывести радиус окружности\n5. Вывести диаметр окружности\n6. Вывести все данные об окружности\n0. Выход\n>");
            com = scanner.nextInt();
            switch (com){
                case 1:
                    System.out.println("Введите новый радиус: ");
                    k = scanner.nextDouble();
                    a.setRadius(k);
                    break;
                case 2:
                    System.out.println("Введите координату X: ");
                    k = scanner.nextDouble();
                    a.setCenterX(k);
                    System.out.println("Введите координату Y: ");
                    k = scanner.nextDouble();
                    a.setCenterY(k);
                    break;
                case 3:
                    System.out.println("Центр окружности: " + a.getCenter());
                    break;
                case 4:
                    System.out.println("Радиус равен: " + a.getRadius());
                    break;
                case 5:
                    System.out.println("Диаметр равен: " + a.getDiameter());
                    break;
                case 6:
                    System.out.println(a);
                    break;
                case 0:
                    return;
            }
        }
    }
}