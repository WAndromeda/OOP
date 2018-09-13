package Lab1;

import  java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.lang.Integer;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long b;
        int com, sum;
        Integer[] a = {1, 2, 3, 4, 5};
        while (true){
            Lab1Class.menu();
            com = scanner.nextInt();
            switch (com){
                case 1:
                    sum = Lab1Class.forCycle(a);
                    System.out.println(sum + " - Цикл for");
                    sum = Lab1Class.whileCycle(a);
                    System.out.println(sum + " - Цикл while");
                    sum = Lab1Class.doWhileCycle(a);
                    System.out.println(sum + " - Цикл do-while");
                    break;
                case 2:
                    Lab1Class.outPut(args);
                    break;
                case 3:
                    Lab1Class.harmonicSeries();
                    break;
                case 4:
                    Lab1Class.random(a);
                    Lab1Class.outPut(a);
                    System.out.println();
                    Arrays.sort(a);
                    Lab1Class.outPut(a);
                    break;
                case 5:
                    System.out.println("Введите число, от которого будем искать факторил: ");
                    com = scanner.nextInt();
                    com++;
                    b = Lab1Class.factorial(com);
                    System.out.println("Факториал: " + b);
                    break;
                case 0:
                    return;
            }
        }

    }
}

class Lab1Class{
    static void menu(){
        System.out.println("\nЛабораторная работа 1\n1. Вывести на экран сумму чисел массива с помощью циклов for, while, do while.\n" +
                            "2. Вывести на экран аргументы командной строки в цикле for\n" + "3. Вывести на экран первые 10 чисел гармонического ряда");
        System.out.print("4. Сгенерировать массив целых чисел случайным образом, вывести его на экран, отсортировать его, и снова вывести на экран.\n" +
                            "5. Вычисление факториала с помощью цикла\n0. Выход\n>");
    }
    static void harmonicSeries(){
        for (int j = 1; j < 11; j++)
            System.out.println((float) 1/j);
    }
    static long factorial(int k) {
        long a = 1;
        for (int i = 1; i < k; i++)
            a *= i;
        return a;
    }
     static void outPut(Object[] a){
         for (int i = 0; i <  a.length; i++)
             System.out.print(a[i] + " ");
    }
    static void random(Integer[] a){
        for (int i = 0; i < a.length; i++)
            a[i] = new Random().nextInt(100);
    }
    static int forCycle(Integer[] a){
        int sum = 0;
        for (int i : a)
            sum += i;
        return sum;
    }
    static int whileCycle(Integer[] a){
        int i = 0, sum = 0;
        while (i < a.length){
            sum += a[i];
            i++;
        }
        return sum;
    }
    static int doWhileCycle(Integer[] a){
        int i = 0, sum = 0;
        do{
            sum += a[i];
            i++;
        }while (i < a.length);
        return sum;
    }
}

