import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string;
        Test[] test = {new Dog(), new Human(), new Planet()};
        int com;
        while(true){
            System.out.print("Лабораторная работа 4 | Задание 1\n1. Вывести имена всех классов\n2. Изменить имя класса Dog\n" +
                    "3. Изменить имя класса Human\n4. Изменить имя класса Planet\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    for (Test i : test)
                        System.out.println("Имя: " + i.getName() + "\n");
                    break;
                case 2:
                    System.out.print("Введите имя для собаки: ");
                    string = scanner.nextLine();
                    test[0].setName(string);
                    break;
                case 3:
                    System.out.print("Введите имя для человека: ");
                    string = scanner.nextLine();
                    test[1].setName(string);
                    break;
                case 4:
                    System.out.print("Введите имя для Планеты: ");
                    string = scanner.nextLine();
                    test[2].setName(string);
                    break;
                case 0:
                    return;
            }
        }
    }
}
