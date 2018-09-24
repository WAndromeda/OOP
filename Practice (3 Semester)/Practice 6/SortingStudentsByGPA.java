import java.util.ArrayList;

public class SortingStudentsByGPA implements Comparable<SortingStudentsByGPA> {
    int mark;
    String name;

    SortingStudentsByGPA(int mark, String name){
        this.mark = mark;
        this.name = name;
    }

    SortingStudentsByGPA(SortingStudentsByGPA sortingStudentsByGPA){
        mark = sortingStudentsByGPA.getMark();
        name = sortingStudentsByGPA.getName();
    }

    void setSortingStudentByGPA(SortingStudentsByGPA sortingStudentByGPA){
        mark = sortingStudentByGPA.getMark();
        name = sortingStudentByGPA.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public int compareTo(SortingStudentsByGPA o) {
        if (mark > o.getMark())
            return 1;
        else if (mark < o.getMark())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Баллы: " + mark + " | Имя: " + name + "\n";
    }
}