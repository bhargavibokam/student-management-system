package studentsystem;

public interface StudentOperations{
    boolean add(Student obj);
    boolean viewAll();
    Student search(int target);
    boolean update(int originalId, int newId, String newName, String newCourse, int newAge);
    boolean delete(int target);

}