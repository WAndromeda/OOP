import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int com;
        while (true){
            Lab7.mainMenu();
            com = scanner.nextInt();
            switch(com){
                case 1:
                    new Lab7().task1();
                    break;
                case 2:
                    new Lab7().task2();
                    break;
                case 3:
                    new Lab7().task3();
                    break;
                case 0:
                    return;
            }

        }
    }
}

class Lab7{
    private static Scanner scanner = new Scanner(System.in);
    static void mainMenu(){
        System.out.print("\nЛабораторная работа 7\n\n1. Проверка коллекции ArrayList\n" +
                        "2. Проверка коллекции LinkedList\n" +
                        "3. Проверка собственной коллекции MyArrayList\n"+
                        "0. Выход\n> "
        );
    }

    static void menu1(){
        System.out.print("\n1. Добавить элемент в ArrayList\n" +
                        "2. Проверка на пустоту ArrayList\n" +
                        "3. Вернуть количество элементов в ArrayList\n"+
                        "4. Удалить элемент по номеру индекса и вывести удалённые элемент\n"+
                        "5. Вывести элемент по номеру индекса\n"+
                        "6. Сортировка\n"+
                        "7. Проверка числа на наличие в ArrayList\n"+
                        "8. Вывести все элементы ArrayList на экран\n"+
                        "0. Вернуться в главное меню\n> "
        );
    }

    static void menu2(){
        System.out.print("\n1. Добавить элемент в LinkedList\n" +
                        "2. Проверка на пустоту LinkedList\n" +
                        "3. Вернуть количество элементов в LinkedList\n"+
                        "4. Удалить элемент по номеру индекса и вывести удалённый элемент\n"+
                        "5. Вывести элемент по номеру индекса\n"+
                        "6. Добавить число по введённому индексу(с заменой числа с этим индексом)\n"+
                        "7. Получить первое число коллекции LinkedList\n"+
                        "8. Вывести все элементы LinkedList на экран\n"+
                        "0. Вернуться в главное меню\n>"
        );
    }

    static void menu3(){
        System.out.print("\n1. Добавить элемент в MyArrayList\n" +
                        "2. Проверка на пустоту MyArrayList\n" +
                        "3. Вернуть количество элементов в MyArrayList\n"+
                        "4. Удалить элемент по номеру индекса и вывести удалённые элемент\n"+
                        "5. Вывести элемент по номеру индекса\n"+
                        "6. Добавить число по введённому индексу(с заменой числа с этим индексом)\n"+
                        "7. Вывести все элементы MyArrayList на экран\n"+
                        "0. Вернуться в главное меню\n> "
        );
    }

    public void task1(){
        ArrayList<Integer> a = new ArrayList<>();
        MyComparator c = new MyComparator();
        int com;
        while(true){
            menu1();
            com = scanner.nextInt();
            switch (com) {
                case 1:
                    System.out.print("Введите число для добавления: ");
                    com = scanner.nextInt();
                    a.add(com);
                    break;
                case 2:
                    System.out.println("ArrayList" + (a.isEmpty() ? " пуст" : " не пуст"));
                    break;
                case 3:
                    System.out.println("Количество элементов в ArrayList: " + a.size());
                    break;
                case 4:
                    System.out.print("Введите номер элемента для удаления (начиная с 1): ");
                    com = scanner.nextInt();
                    Integer b =  a.remove(com-1);
                    System.out.println("Удалённый элемент: " + b);
                    break;
                case 5:
                    System.out.print("Введите номер элемента, который вы хотите увидеть (начиная с 1): ");
                    com = scanner.nextInt();
                    System.out.println("Число: " + a.get(com-1));
                    break;
                case 6:
                    a.sort(c);
                    break;
                case 7:
                    System.out.print("Введите число: ");
                    com = scanner.nextInt();
                    System.out.println("Число " + com + (a.contains(com) ? " присутствует" : " отсутствует") + " в ArrayList");
                    break;
                case 8:
                    System.out.println(a);
                    break;
                case 0:
                    return;
            }
        }
    }

    public void task2(){
        LinkedList<Integer> a = new LinkedList<>();
        int com;
        while(true){
            menu2();
            com = scanner.nextInt();
            switch (com) {
                case 1:
                    System.out.print("Введите число для добавления: ");
                    com = scanner.nextInt();
                    a.add(com);
                    break;
                case 2:
                    System.out.println("LinkedList" + (a.isEmpty() ? " пуст" : " не пуст"));
                    break;
                case 3:
                    System.out.println("Количество элементов в LinkedList: " + a.size());
                    break;
                case 4:
                    System.out.print("Введите номер элемента для удаления (начиная с 1): ");
                    com = scanner.nextInt();
                    Integer b =  a.remove(com-1);
                    System.out.println("Удалённый элемент: " + b);
                    break;
                case 5:
                    System.out.print("Введите номер элемента, который вы хотите увидеть (начиная с 1): ");
                    com = scanner.nextInt();
                    System.out.println("Число: " + a.get(com-1));
                    break;
                case 6:
                    System.out.print("Введите индекс для добавления (начиная с 1): ");
                    com = scanner.nextInt();
                    System.out.print("Введите само число: ");
                    Integer k = scanner.nextInt();
                    a.set(com-1, k);
                    break;
                case 7:
                    System.out.println("Первое число коллекции LinkedList: " + a.getFirst());
                    break;
                case 8:
                    System.out.println(a);
                    break;
                case 0:
                    return;
            }
        }
    }

    public void task3(){
        MyArrayList<Integer> a = new MyArrayList<>(10);
        int com;
        while(true){
            menu3();
            com = scanner.nextInt();
            switch (com) {
                case 1:
                    System.out.print("Введите число для добавления: ");
                    com = scanner.nextInt();
                    a.add(com);
                    break;
                case 2:
                    System.out.println("MyArrayList" + (a.isEmpty() ? " пуст" : " не пуст"));
                    break;
                case 3:
                    System.out.println("Количество элементов в MyArrayList: " + a.size());
                    break;
                case 4:
                    System.out.print("Введите номер элемента для удаления (начиная с 1): ");
                    com = scanner.nextInt();
                    Integer b =  a.remove(com-1);
                    System.out.println("Удалённый элемент: " + b);
                    break;
                case 5:
                    System.out.print("Введите номер элемента, который вы хотите увидеть (начиная с 1): ");
                    com = scanner.nextInt();
                    System.out.println("Число: " + a.get(com-1));
                    break;
                case 6:
                    System.out.print("Введите индекс для добавления (начиная с 1): ");
                    com = scanner.nextInt();
                    System.out.print("Введите само число: ");
                    Integer k = scanner.nextInt();
                    a.set(com-1, k);
                    break;
                case 7:
                    System.out.println(a);
                    break;
                case 0:
                    return;
            }
        }
    }

    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            int k;
            if (a.intValue() < b.intValue())
                k = -1;
            else if (a.intValue() > b.intValue())
                k = 1;
            else
                k = 0;
            return k;
        }
    }
}

