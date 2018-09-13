public abstract class Furniture {
    protected String name;
    protected String function;
    protected String exploitation;
    protected String material;

    Furniture(){
        name = "";
        function = "";
        exploitation = "";
        material = "";
    }

    Furniture(String name, String function, String exploitation, String material){
        this.name = name;
        this.function = function;
        this.exploitation = exploitation;
        this.material = material;
    }

    Furniture(Furniture furniture){
        setName(furniture.getName());
        setFunction(furniture.getFunction());
        setExploitation(furniture.getExploitation());
        setMaterial(furniture.getMaterial());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setExploitation(String exploitation) {
        this.exploitation = exploitation;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public String getMaterial() {
        return material;
    }

    public String getExploitation() {
        return exploitation;
    }

    @Override
    public String toString() {
        return "Наименование: " + name + " | Функциональное назначение: " + function + " | Эксплуатационное назвачение: " + exploitation + " | Материал: " + material;
    }
}

class Chair extends Furniture{
    private String color;
    private double height, diameter;

    Chair(){
        super();
        color = "";
        diameter = 0;
        height = 0;
    }

    Chair(String name, String function, String exploitation, String material, String color, double diameter, double height){
        super(name, function, exploitation, material);
        this.color = color;
        this.diameter = diameter;
        this.height = height;
    }

    Chair(Chair chair){
        super(chair);
        setDiameter(chair.getDiameter());
        setColor(chair.getColor());
        setHeight(chair.getHeight());
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getColor() {
        return color;
    }

    public double getHeight() {
        return height;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Стул\n" + super.toString() + "\nЦвет: " + color + " | Диаметр: " + diameter + " | Высота: " + height ;
    }
}

class Sofa extends Furniture{
    private String filler, upholstery;

    Sofa(){
        super();
        filler = "";
        upholstery = "";
    }

    Sofa(String name, String function, String exploitation, String material, String filler, String upholstery){
        super(name, function, exploitation, material);
        this.filler = filler;
        this.upholstery = upholstery;
    }

    Sofa(Sofa sofa){
        super(sofa);
        setFiller(sofa.getFiller());
        setUpholstery(sofa.getUpholstery());
    }

    public void setUpholstery(String upholstery) {
        this.upholstery = upholstery;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getUpholstery() {
        return upholstery;
    }

    public String getFiller() {
        return filler;
    }

    @Override
    public String toString() {
        return "Диван\n" + super.toString() + "\nНаполнитель: " + filler + " | Обивка: " + upholstery;
    }
}

class Bed extends Furniture{
    private double height, width, length;
    Bed(){
        super();
        height = 0;
        width = 0;
        length = 0;
    }

    Bed(String name, String function, String exploitation, String material, double height, double width, double length){
        super(name, function, exploitation, material);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    Bed(Bed bed){
        super(bed);
        setHeight(bed.getHeight());
        setLength(bed.getLength());
        setWidth(bed.getWidth());
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Кровать\n" + super.toString() + "\nВысота: " + height + " | Длина: " + length + " | Ширина: " + width;
    }
}
