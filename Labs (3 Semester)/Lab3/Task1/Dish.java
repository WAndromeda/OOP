import java.util.Scanner;

public abstract class Dish {
    protected String targetFood;
    protected String material;
    protected String color;

    Dish(){
        targetFood = "";
        material = "";
        color = "";
    }

    Dish(String targetFood, String material, String color){
        this.targetFood = targetFood;
        this.material = material;
        this.color = color;
    }

    Dish(Dish a){
        setTargetFood(a.getTargetFood());
        setMaterial(a.getMaterial());
        setColor(a.getColor());
    }

    public void setTargetFood(String targetFood){
        this.targetFood = targetFood;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTargetFood(){
        return targetFood;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    abstract public void setData();

    @Override
    public String toString() {
        return "Посуда\nПредназначение: " + targetFood + "\nМатериал: " + material + "\nЦвет: " + color + "\n" ;
    }
}

class RoundDish extends Dish{
    private int diameter;

    RoundDish(){
        super();
        diameter = 0;
    }

    RoundDish(String targetFood, String material, String color, int diameter){
        super(targetFood, material, color);
        this.diameter = diameter;
    }

    RoundDish(RoundDish roundDish){
        super(roundDish.getTargetFood(), roundDish.getMaterial(), roundDish.getColor());
        setDiameter(roundDish.getDiameter());
    }

    public void setDiameter(int diameter){
        this.diameter = diameter;
    }

    public void setRoundDish(RoundDish roundDish){
        setTargetFood(roundDish.getTargetFood());
        setMaterial(roundDish.getMaterial());
        setColor(roundDish.getColor());
        setDiameter(roundDish.getDiameter());
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public void setData(){
        Scanner scanner = new Scanner(System.in);
        String[] string = {new String(), new String(), new String()};
        System.out.print("Введите предназначение посуды: ");
        string[0] = scanner.nextLine();
        System.out.print("Введите материал посуды: ");
        string[1] = scanner.nextLine();
        System.out.print("Введите цвет посуды: ");
        string[2] = scanner.nextLine();
        System.out.print("Введите диаметр: ");
        int t = scanner.nextInt();
        setRoundDish(new RoundDish(string[0], string[1], string[2], t));
    }

    @Override
    public String toString() {
        return super.toString() + "Диаметр: " + diameter + " мм";
    }
}

class SquareDish extends Dish{
    private int length;

    SquareDish(){
        super();
        length = 0;
    }

    SquareDish(String targetFood, String material, String color, int length){
        super(targetFood, material, color);
        this.length = length;
    }

    SquareDish(SquareDish squareDish){
        super(squareDish.getTargetFood(), squareDish.getMaterial(), squareDish.getColor());
        setLength(squareDish.getLength());
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSquareDish(SquareDish squareDish){
        setTargetFood(squareDish.getTargetFood());
        setMaterial(squareDish.getMaterial());
        setColor(squareDish.getColor());
        setLength(squareDish.getLength());
    }

    public int getLength() {
        return length;
    }

    @Override
    public void setData(){
        Scanner scanner = new Scanner(System.in);
        String[] string = {new String(), new String(), new String()};
        System.out.print("Введите предназначение посуды: ");
        string[0] = scanner.nextLine();
        System.out.print("Введите материал посуды: ");
        string[1] = scanner.nextLine();
        System.out.print("Введите цвет посуды: ");
        string[2] = scanner.nextLine();
        System.out.print("Введите длину: ");
        int t = scanner.nextInt();
        setSquareDish(new SquareDish(string[0], string[1], string[2], t));
    }

    @Override
    public String toString() {
        return super.toString() + "Длина: " + length + " мм";
    }
}

class DeepDish extends Dish{
    private int volume;

    DeepDish(){
        super();
        volume = 0;
    }

    DeepDish(String targetFood, String material, String color, int volume){
        super(targetFood, material, color);
        this.volume = volume;
    }

    DeepDish(DeepDish deepDish){
        super(deepDish.getTargetFood(), deepDish.getMaterial(), deepDish.getColor());
        setVolume(deepDish.getVolume());
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setDeepDish(DeepDish deepDish){
        setTargetFood(deepDish.getTargetFood());
        setMaterial(deepDish.getMaterial());
        setColor(deepDish.getColor());
        setVolume(deepDish.getVolume());
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void setData(){
        Scanner scanner = new Scanner(System.in);
        String[] string = {new String(), new String(), new String()};
        System.out.print("Введите предназначение посуды: ");
        string[0] = scanner.nextLine();
        System.out.print("Введите материал посуды: ");
        string[1] = scanner.nextLine();
        System.out.print("Введите цвет посуды: ");
        string[2] = scanner.nextLine();
        System.out.print("Введите объём: ");
        int t = scanner.nextInt();
        setDeepDish(new DeepDish(string[0], string[1], string[2], t));
    }

    @Override
    public String toString() {
        return super.toString() + "Объём: " + volume + " см^3";
    }
}