import java.util.Scanner;

public class TestAuthor{
    public static void main(String[] args){
        Author author = new Author(new Author("Анджей Сапковский", "asdsdf@sdfsdf.df", 'F'));
        Scanner scanner = new Scanner(System.in);
        int com;

        while (true){
            System.out.print("Практическая работа 2\n1. Вывести данные об авторе\n2. Изменить имя\n3. Изменить адрес электронной почты\n4. Изменить пол\n0. Выход\n>");
            com = scanner.nextInt();
            scanner.nextLine();
            switch (com){
                case 1:
                    System.out.println(author);
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    String string1;
                    string1 = scanner.nextLine();
                    author.setEmail(string1);
                    break;
                case 3:
                    System.out.print("Введите адрес электронной почты: ");
                    String string2;
                    string2 = scanner.nextLine();
                    author.setName(string2);
                    break;
                case 4:
                    System.out.print("Введите пол: ");
                    char c = scanner.nextLine().charAt(0);
                    author.setGender(c);
                    break;
                case 0:
                    return;
            }
        }
    }
}