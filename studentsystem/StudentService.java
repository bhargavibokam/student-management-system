package studentsystem;
import java.util.*;
import studentsystem.exceptions.StudentNotFoundException;

public class StudentService implements StudentOperations{
    private List<Student> data = new ArrayList<>();

    @Override
    public void add(Student obj) {
       data.add(obj);
    }
    @Override
    public void viewAll() throws StudentNotFoundException{
            if(data.isEmpty()){
                throw new StudentNotFoundException("Student list not found");
            }
            int index = 1;
            for(Student s : data){
                System.out.println("student "+index++);
                s.displayInfo();
            }
    }
    @Override
    public Student search(int target) throws StudentNotFoundException{
        for(Student s : data){
            if(s.getId() == target)
                return s;
        }
        throw new StudentNotFoundException("Student not Found");
    }
    @Override
    public void update(int original, int newid,String newname, String newcourse, int newage)
        throws StudentNotFoundException{
        Student s = search(original);
        s.setId(newid);
        s.setName(newname);
        s.setCourse(newcourse);
        s.setAge(newage);
    }

    @Override
    public void delete(int target) throws StudentNotFoundException{
        Student s = search(target);
        data.remove(s);
    }
}
 