import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int amount = 10;
        SortingStudentsByGPA[] a = new SortingStudentsByGPA[amount];
        for (int i = 0; i < a.length; i++)
            a[i] = new SortingStudentsByGPA(i+1, "Студент " + (i+1));
        long b;
        int com, sum;
        while (true){
            System.out.print("Практическая работа №6\n1. Отсортировать массив по убыванию баллов\n2. Отсортировать масссив по возрастанию баллов\n3. Вывести массив\n0. Выход\n> ");
            com = scanner.nextInt();
            switch (com){
                case 1:
                    Practice.sortBigToLess(a);
                    System.out.println("Отсортированный массив по убыванию");
                    Practice.printArray(a);
                    break;
                case 2:
                    Practice.sortLessToBig(a);
                    System.out.println("Отсортированный массив по возрастанию");
                    Practice.printArray(a);
                    break;
                case 3:
                    Practice.printArray(a);
                    break;
                case 0:
                    return;
            }
        }
    }
}

class Practice{
    static void printArray(SortingStudentsByGPA[] a) {
        for (SortingStudentsByGPA i : a)
            System.out.println(i);
    }
    static void swap(SortingStudentsByGPA a, SortingStudentsByGPA b){
        SortingStudentsByGPA t = new SortingStudentsByGPA(a);
        a.setSortingStudentByGPA(b);
        b.setSortingStudentByGPA(t);
    }
    static void sortBigToLess(SortingStudentsByGPA[] a){
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length-1-i; j++)
                if (a[j].compareTo(a[j+1]) < 0)
                    Practice.swap(a[j], a[j+1]);
    }
    static void sortLessToBig(SortingStudentsByGPA[] a){
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length-i-1; j++)
                if (a[j].compareTo(a[j+1]) > 0)
                    Practice.swap(a[j], a[j+1]);
    }
}