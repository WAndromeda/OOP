import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Dog[] dogs = {new Spitz("Майя", "Домашняя", "Белый"),
                new Chihuahua("Рике", "Домашнняя", "Коричневый"),
                new GermanShepherd("Фике", "Охотничья", "Чёрный")
        };
        int com;
        while(true){
            System.out.print("Лабораторная работа 3 | Задание 2\n1. Вывести данные обо всех собаках\n2. Изменить данные о Шпице\n" +
                    "3. Изменить данные о Чихуахуа\n4. Изменить данные о Немецкой Овчарке\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    for (Dog i : dogs)
                        System.out.println(i);
                    break;
                case 2:
                    dogs[0].setData();
                    break;
                case 3:
                    dogs[1].setData();
                    break;
                case 4:
                    dogs[2].setData();
                    break;
                case 0:
                    return;
            }
        }
    }
}
