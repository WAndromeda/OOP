import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        File file = null;
        String string = new String();
        int com;
        while(true){
            Lab8.menu();
            com = scanner.nextInt();
            switch(com){
                case 1:
                    System.out.println("Введите имя файла: ");
                    scanner.nextLine();
                    file = new File(scanner.nextLine());
                    System.out.println("Введите данные для записи в файл: ");
                    string = scanner.nextLine();
                    if (Lab8.writeFile(file, string))
                        System.out.println("\nФайл успешно создан!");
                    else
                        System.out.println("\nОшибка создания файла");
                    file.deleteOnExit();
                    break;
                case 2:
                    System.out.println("Введите имя файла: ");
                    scanner.nextLine();
                    file = new File(scanner.nextLine());
                    if (!Lab8.readFile(file))
                        System.out.println("\nОшибка чтения файла");
                    file.deleteOnExit();
                    break;
                case 3:
                    System.out.println("Введите имя файла: ");
                    scanner.nextLine();
                    file = new File(scanner.nextLine());
                    System.out.println("Введите данные для перезаписи в файл: ");
                    string = scanner.nextLine();
                    if (Lab8.writeFile(file, string))
                        System.out.println("\nПерезапись прошла успешно!");
                    else
                        System.out.println("\nОшибка перезаписи");
                    file.deleteOnExit();
                    break;
                case 4:
                    System.out.println("Введите имя файла: ");
                    scanner.nextLine();
                    file = new File(scanner.nextLine());
                    System.out.println("Введите данные для записи в конец файла: ");
                    string = scanner.nextLine();
                    if (Lab8.appendData(file, string))
                        System.out.println("\nДанные успешно записаны!");
                    else
                        System.out.println("\nОшибка записи в файл");
                    file.deleteOnExit();
                    break;
                case 0:
                    return;
            }
        }
    }
}

class Lab8{
    static public void menu(){
        System.out.print("\nЛабораторная работа 8 (Файла всегда будет создаваться в директории проекта)\n"+
                            "1. Запись в файл введённой с клавиатуры информации\n"+
                            "2. Вывод информации из файла на экран\n"+
                            "3. Заменить информацию в файле на информацию, введённую с клавиатуры\n"+
                            "4. Добавить в конец исходного файла текст, введённый с клавиатуры\n"+
                            "0. Выход\n> "
        );
    }

    static public boolean writeFile(File file, String str){
        Desktop desktop = null;
        boolean flag = false;
        if (!file.exists())
            try {
                file = new File(file.getName());
                file.createNewFile();
                file.deleteOnExit();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        if (file.isFile()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                flag = true;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                    desktop.open(file);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return flag;
    }

    static public boolean readFile(File file){
        String string = new String();
        boolean flag = false;
        if (!file.exists())
            try {
                file = new File(file.getName());
                file.createNewFile();
                file.deleteOnExit();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("Стандартная запись в несуществующий до нынешнего момента файл");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        try{
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                string += scanner.nextLine() + "\n";
            }
            fileReader.close();
            flag = true;
            System.out.println("\n" + string + "\n");
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return flag;
    }

    static public boolean appendData(File file, String str){
        Desktop desktop = null;
        boolean flag = false;
        if (!file.exists())
            try {
                file = new File(file.getName());
                file.createNewFile();
                file.deleteOnExit();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        if (file.isFile()) {
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write("\n" +str);
                fileWriter.flush();
                fileWriter.close();
                flag = true;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                    desktop.open(file);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return flag;
    }
}

