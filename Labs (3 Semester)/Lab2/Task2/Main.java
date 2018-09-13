import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Human a = new Human(new Human(2, 2, 190.0, 120.0));
        {
            double[] u = new double[5];
            for (int i = 0; i < u.length; i++)
                u[i] = 2.0 + i;
            Head head = new Head(2, 0);
            Leg[] legs = new Leg[2];
            for (int i = 0; i < legs.length; i++)
                legs[i] = new Leg(5, 100.0, u);
            Hand[] hands = new Hand[2];
            for (int i = 0; i < hands.length; i++)
                hands[i] = new Hand(5, 70.0, u);
            a.setParts(head, hands, legs);
        }
        Scanner scanner = new Scanner(System.in);
        double k;
        int com;
        while (true){
            System.out.print("Лабораторная работа 2 | Задание 2\n1. Изменить Рост\n2. Изменить вес\n3. Изменить количество ног\n4. Изменить количество рук\n" +
                            "5. Проверить человека на лишний вес\n6. Проверит человека на слепоту\n7. Проверить человека на глухоту\n8. Вывести параметры человека\n0. Выход\n>");
            com = scanner.nextInt();
            switch (com){
                case 1:
                    System.out.println("Введите новый рост: ");
                    k = scanner.nextDouble();
                    a.setGrowth(k);
                    break;
                case 2:
                    System.out.println("Введите новый вес: ");
                    k = scanner.nextDouble();
                    a.setWeight(k);
                    break;
                case 3:
                    System.out.println("Введите количество ног: ");
                    com = scanner.nextInt();
                    a.setAmountLeg(com);
                    break;
                case 4:
                    System.out.println("Введите количество рук: ");
                    com = scanner.nextInt();
                    a.setAmountHand(com);
                    break;
                case 5:
                    System.out.println("Человек "+ (a.isFat()? "с лишним весом" : "без лишнего веса"));
                    break;
                case 6:
                    System.out.println("Человек "+ (a.isBlind()? "слепой" : "не слепой"));
                    break;
                case 7:
                    System.out.println("Человек "+ (a.isDeaf()? "глухой" : "не глухой"));
                    break;
                case 8:
                    System.out.println("Человек\n" + a);
                    break;
                case 0:
                    return;
            }
        }
    }
}
