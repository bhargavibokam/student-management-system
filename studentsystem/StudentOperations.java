package studentsystem;

import studentsystem.exceptions.StudentNotFoundException;

public interface StudentOperations{
    void add(Student obj);
    void viewAll()throws StudentNotFoundException;
    Student search(int target) throws StudentNotFoundException;
    void update(int originalId, int newId, String newName, String newCourse, int newAge) throws StudentNotFoundException;
    void delete(int target) throws StudentNotFoundException;

}