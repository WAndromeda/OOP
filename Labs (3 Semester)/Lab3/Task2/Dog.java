import java.util.Scanner;

public abstract class Dog {
    protected String name;
    protected String purpose;
    protected String colorWool;

    Dog(){
        name = "";
        purpose = "";
        colorWool = "";
    }

    Dog(String name, String purpose, String colorWool){
        this.name = name;
        this.purpose = purpose;
        this.colorWool = colorWool;
    }

    Dog(Dog a){
        setName(a.getName());
        setPurpose(a.getPurpose());
        setColorWool(a.getColorWool());
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setColorWool(String colorWool) {
        this.colorWool = colorWool;
    }

    public String getName(){
        return name;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getColorWool() {
        return colorWool;
    }

    abstract public void setData();
    public static String getBreed(){ return ""; };

    @Override
    public String toString() {
        return "Собака\nИмя: " + name + "\nПредназначение: " + purpose + "\nЦвет шерсти: " + colorWool + "\n";
    }
}

class Spitz extends Dog{
    static final String breed = new String("Шпиц");

    Spitz(){
        super();
    }

    Spitz(String name, String purpose, String colorWool){
        super(name, purpose, colorWool);
    }

    Spitz(Spitz spitz){
        super(spitz.getName(), spitz.getPurpose(), spitz.getColorWool());
    }

    public void setSpitz(Spitz spitz){
        setName(spitz.getName());
        setPurpose(spitz.getPurpose());
        setColorWool(spitz.getColorWool());
    }

    @Override
    public void setData(){
        Scanner scanner = new Scanner(System.in);
        String[] string = {new String(), new String(), new String()};
        System.out.print("Введите имя: ");
        string[0] = scanner.nextLine();
        System.out.print("Введите предназначение: ");
        string[1] = scanner.nextLine();
        System.out.print("Введите цвет шерсти: ");
        string[2] = scanner.nextLine();
        setSpitz(new Spitz(string[0], string[1], string[2]));
    }

    public static String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return super.toString() +  "Порода: "  + getBreed();
    }
}

class Chihuahua extends Dog{
    static final String breed = new String("Чихуахуа");

    Chihuahua(){
        super();
    }

    Chihuahua(String name, String purpose, String colorWool){
        super(name, purpose, colorWool);
    }

    Chihuahua(Chihuahua chihuahua){
        super(chihuahua.getName(), chihuahua.getPurpose(), chihuahua.getColorWool());;
    }

    public void setChihuahua(Chihuahua chihuahua){
        setName(chihuahua.getName());
        setPurpose(chihuahua.getPurpose());
        setColorWool(chihuahua.getColorWool());
    }

    @Override
    public void setData(){
        Scanner scanner = new Scanner(System.in);
        String[] string = {new String(), new String(), new String()};
        System.out.print("Введите имя: ");
        string[0] = scanner.nextLine();
        System.out.print("Введите предназначение: ");
        string[1] = scanner.nextLine();
        System.out.print("Введите цвет шерсти: ");
        string[2] = scanner.nextLine();
        setChihuahua(new Chihuahua(string[0], string[1], string[2]));
    }

    public static String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return super.toString() +  "Порода: "  + getBreed();
    }
}

class GermanShepherd extends Dog{
    static final String breed = new String("Немецкая Овчарка");

    GermanShepherd(){
        super();
    }

    GermanShepherd(String name, String purpose, String colorWool){
        super(name, purpose, colorWool);
    }

    GermanShepherd(GermanShepherd germanShepherd){
        super(germanShepherd.getName(), germanShepherd.getPurpose(), germanShepherd.getColorWool());
    }

    public void setGermanShepherd(GermanShepherd germanShepherd){
        setName(germanShepherd.getName());
        setPurpose(germanShepherd.getPurpose());
        setColorWool(germanShepherd.getColorWool());
    }

    @Override
    public void setData(){
        Scanner scanner = new Scanner(System.in);
        String[] string = {new String(), new String(), new String()};
        System.out.print("Введите имя: ");
        string[0] = scanner.nextLine();
        System.out.print("Введите предназначение: ");
        string[1] = scanner.nextLine();
        System.out.print("Введите цвет шерсти: ");
        string[2] = scanner.nextLine();
        setGermanShepherd(new GermanShepherd(string[0], string[1], string[2]));
    }

    public static String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return super.toString() +  "Порода: "  + getBreed();
    }
}
