package Model;

public class Students {
    private int id;
    private String name;
    private int age;
    private boolean isMale;
    private String Subject;
    private double score;

    public Students(int id, String name, int age, boolean isMale, String subject, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.Subject = subject;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGenderAsString() {
        return isMale ? "Male" : "Female";
    }

    @Override
    public String toString() {
        return "Students [ id = " + id +
                "Name = " + name +
                "Age = " + age +
                "Gender = " + isMale +
                "Subject = " + Subject +
                "Score = " + score + "]";
    }

}
