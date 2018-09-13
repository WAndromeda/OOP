import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FurnitureShop furnitureShop = new FurnitureShop();
        int com;
        while(true){
            System.out.print("Лабораторная работа 3 | Задание 3\n1. Вывести данные обо всём товаре\n2. Добавить товар\n" +
                    "3. Удалить товар с определённым номером\n4. Удалить первую позицию\n5. Удалить последнюю позицию\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    furnitureShop.displayAll();
                    break;
                case 2:
                    furnitureShop.add(new Chair("Стул офисный", "Для сидения - одноместные", "Для Кабинета", "Металл", "Синий", 350, 460));
                    furnitureShop.add(new Sofa("Диван раскладной", "Для сидения - многоместные", "Для Гостинной", "Сосна", "Мебельный пух", "Натуральная кожа"));
                    furnitureShop.add(new Bed("Кровать односпальная", "Для сна и лежания", "Для Спальни", "Дерево", 200, 350, 460));
                    break;
                case 3:
                    System.out.print("Введите номер позиции для удаления: ");
                    com = scanner.nextInt();
                    furnitureShop.deletePosition(com);
                    break;
                case 4:
                    furnitureShop.deleteFirst();
                    break;
                case 5:
                    furnitureShop.deleteLast();
                    break;
                case 0:
                    return;
            }
        }
    }
}
