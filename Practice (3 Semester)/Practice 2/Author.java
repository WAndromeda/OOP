public class Author {
    private String name, email;
    private char gender;
    Author(){
        email = new String("");
        name = new String("");
        gender = 'u';
    }

    Author(String name, String email, char gender){
        this.email = email;
        this.name = name;
        this.gender = gender;
    }

    Author(Author author){
        setName(author.getName());
        setGender(author.getGender());
        setEmail(author.getEmail());
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        String t;
        if (gender == 'M')
            t = "Мужской";
        else if (gender == 'F')
            t = "Женский";
        else
            t = "Неизвествен";
        return "Имя Автора: " + name + "\nАдрес электронной почты: " + email + "\nПол: " + t + '\n';
    }
}