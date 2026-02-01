package studentsystem;

public class Student {
    private int id;
    private String name;
    private String course;
    private int age;

    public Student(int id, String name, String course, int age){
        this.id = id;
        this.name = name;
        this.course = course;
        this.age = age;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCourse(){
        return this.course;
    }
    public void setCourse(String  course){
        this.course = course;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void displayInfo(){
        System.out.println("ID : "+id+" | "+
        "NAME : "+name+" | "+
        "COURSE : "+course+" | "+
        "AGE : "+age+" | ");
    }
}
