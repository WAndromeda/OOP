import java.util.ArrayDeque;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>[] a;
        int com, sum;
        while (true){
            System.out.print("Практическая работа №7 (Игра в Пьяницу)\n1. Начать игру\n0. Выход\n> ");
            com = scanner.nextInt();
            switch (com){
                case 1:
                    System.out.println("Раскладываем карты...");
                    a = Practice.createCards();
                    Practice.waiting(500);
                    System.out.println("Карты первого игрока: " + a[0] +"\nКарты второго игрока: " + a[1] + "\n");
                    System.out.println("Игра началась: ");
                    int card[] = new int[2];
                    while (!a[0].isEmpty() && !a[1].isEmpty()) {
                        boolean flag = false;
                        System.out.println("\nИгроки вскрывают верхние карты...");
                        Practice.waiting(3000);
                        card[0] = a[0].pop();
                        card[1] = a[1].pop();
                        System.out.println("У Игрока 1 верхняя карта: " + card[0] + "\nУ Игрока 2 верхняя карта: " + card[1]);
                        if (card[0] == 0 && card[1] == 9)
                            flag = true;
                        String str;
                        if (card[0] > card[1] || flag) {
                            str = "\nУ Игрока 1 карта больше, он забирает обе карты\n";
                            a[0].addLast(card[1]);
                            a[0].addLast(card[0]);
                        }
                        else {
                            str = "\nУ Игрока 2 карта больше, он забирает обе карты\n";
                            a[1].addLast(card[0]);
                            a[1].addLast(card[1]);
                        }
                        System.out.println(str);
                        System.out.println("\nКарты первого игрока: " + a[0] +"\nКарты второго игрока: " + a[1] + "\n");
                    }
                    if (a[0].isEmpty())
                        System.out.println("Игрок 1 проиграл!");
                    else if (a[1].isEmpty())
                        System.out.println("Игрок 2 проиграл!");
                    break;
                case 0:
                    return;
            }
        }
    }
}

class Practice{
    static ArrayDeque<Integer>[] createCards(){
        ArrayDeque<Integer>[] a = new ArrayDeque[2];
        a[0] = new ArrayDeque<>();
        a[1] = new ArrayDeque<>();
        Boolean[] b = new Boolean[10];
        for (int i = 0; i < b.length; i++)
            b[i] = new Boolean(false);
        Random random = new Random();
        boolean flag = true;
        int i = 0, cnt = 0;
        while(cnt != 10) {
            int t = random.nextInt(10);
            if (!b[t]){
                b[t] = true;
                a[i % 2].addFirst(t);
                i++;
                cnt++;
            }
        }
        return a;
    }

    static void waiting(int time){
        try { Thread.sleep(time); }
        catch (Exception e){}
    }
}