import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double price;
        Test[] test = {new Car(), new Furniture(), new Food()};
        int com;
        while(true){
            System.out.print("Лабораторная работа 4 | Задание 2\n1. Вывести цену всех классов\n2. Изменить цену класса Car\n" +
                    "3. Изменить цену класса Furniture\n4. Изменить цену класса Food\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    for (Test i : test)
                        System.out.println("Цена: " + i.getPrice() + "\n");
                    break;
                case 2:
                    System.out.print("Введите цену для Машины: ");
                    price = scanner.nextDouble();
                    test[0].setPrice(price);
                    break;
                case 3:
                    System.out.print("Введите имя для Мебели: ");
                    price = scanner.nextDouble();
                    test[1].setPrice(price);
                    break;
                case 4:
                    System.out.print("Введите имя для Еды: ");
                    price = scanner.nextDouble();
                    test[2].setPrice(price);
                    break;
                case 0:
                    return;
            }
        }
    }
}