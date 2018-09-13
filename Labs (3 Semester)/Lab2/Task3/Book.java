public class Book {
    private String author;
    private String name;
    private MyDate date;
    private int edition;
    private int pages;
    private boolean fillmed;
    Book(){
        author = new String("");
        name = new String("");
        date = new MyDate();
        edition = 0;
        pages = 1;
        fillmed = false;
    }

    Book(String author, String name, MyDate date, int edition, int pages, boolean fillmed){
        this.author = author;
        this.date = date;
        this.name = name;
        this.edition = edition;
        this.pages = pages;
        this.fillmed = fillmed;
    }

    Book(Book book){
        setAuthor(book.getAuthor());
        setName(book.getName());
        setDate(book.getDate());
        setEdition(book.getEdition());
        setPages(book.getPages());
        setFillmed(book.isFillmed());
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setFillmed(boolean fillmed) {
        this.fillmed = fillmed;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public MyDate getDate() {
        return date;
    }

    public int getEdition() {
        return edition;
    }

    public int getPages() {
        return pages;
    }

    public boolean isFillmed() {
        return fillmed;
    }

    @Override
    public String toString() {
        return "Книга \"" + name + "\", Автор " + author + "\nДата выхода: " + date + "\nКоличество страниц: " + pages + "\nТираж: " + edition + "\n" +
                (isFillmed() ? "Была экранизирована" : "Не была экранизирована") + "\n" ;
    }
}

class MyDate{
    private int day;
    private int month;
    private int year;

    MyDate(){
        day = 1;
        month = 1;
        year = 0;
    }

    MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    MyDate(MyDate myDate){
        setDay(myDate.getDay());
        setMonth(myDate.getMonth());
        setYear(myDate.getYear());
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}
