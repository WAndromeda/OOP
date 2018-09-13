import java.util.Scanner;

public class BookTest{
    public static void main(String[] args){
        Book book = new Book(new Book("Анджей Сапковский", "Ведьмак", new MyDate(15, 11, 1998), 100000, 500, true));
        Scanner scanner = new Scanner(System.in);
        int com;
        while (true){
            System.out.print("Лабораторная работа 2 | Задание 3\n1. Вывести данные о книге\n2. Изменить автора\n3. Изменить название\n4. Изменить количество страниц\n" +
                    "5. Изменить тираж\n6. Изменить данные о экранизации\n7. Изменить дату выхода\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    System.out.println(book);
                    break;
                case 2:
                    System.out.print("Введите автора: ");
                    String string1;
                    string1 = scanner.nextLine();
                    book.setAuthor(string1);
                    break;
                case 3:
                    System.out.print("Введите название: ");
                    String string2;
                    string2 = scanner.nextLine();
                    book.setName(string2);
                    break;
                case 4:
                    System.out.print("Введите количество страниц: ");
                    com = scanner.nextInt();
                    book.setPages(com);
                    break;
                case 5:
                    System.out.print("Введите тираж: ");
                    com = scanner.nextInt();
                    book.setEdition(com);
                    break;
                case 6:
                    System.out.print("Введите данные, была ли экранизирована книга: ");
                    boolean b = scanner.nextBoolean();
                    book.setFillmed(b);
                    break;
                case 7:
                    MyDate myDate = new MyDate();
                    System.out.print("Введите день выхода: ");
                    com = scanner.nextInt();
                    myDate.setDay(com);
                    System.out.print("Введите месяц выхода: ");
                    com = scanner.nextInt();
                    myDate.setMonth(com);
                    System.out.print("Введите год выхода: ");
                    com = scanner.nextInt();
                    myDate.setYear(com);
                    book.setDate(myDate);
                    break;
                case 8:
                    break;
                case 0:
                    return;
            }
        }
    }
}
