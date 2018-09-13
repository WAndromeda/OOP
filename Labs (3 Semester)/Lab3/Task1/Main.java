import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Dish[] dishes = {new RoundDish("Салаты", "Фарфор", "Белый", 240),
                new SquareDish("Рыба и Мясо", "Дерево", "Коричневый", 200),
                new DeepDish("Соусы", "Керамика", "Чёрный", 400)
        };
        int com;
        while(true){
            System.out.print("Лабораторная работа 3 | Задание 1\n1. Вывести данные обо всех видах посуды\n2. Изменить данные круглой посуды\n" +
                    "3. Изменить данные квадратный посуды\n4. Изменить данные глубокой посуды\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    for (Dish i : dishes)
                        System.out.println(i);
                    break;
                case 2:
                    dishes[0].setData();
                    break;
                case 3:
                    dishes[1].setData();
                    break;
                case 4:
                    dishes[2].setData();
                    break;
                case 0:
                    return;
            }
        }
    }
}
