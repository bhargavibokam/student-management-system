package studentsystem;
import java.util.*;
import studentsystem.exceptions.StudentNotFoundException;

public class StudentService implements StudentOperations{
    private HashMap<Integer,Student> data = new HashMap<>();

    @Override
    public void add(Student obj) {
       if(data.containsKey(obj.getId())){
        throw new IllegalArgumentException("Student Id already exixts");
       }
       data.put(obj.getId(),obj);
    }
    @Override
    public void viewAll() throws StudentNotFoundException{
            if(data.isEmpty()){
                throw new StudentNotFoundException("Student list not found");
            }
            int i=1;
            for(Student s : data.values()){
                System.out.println("Student "+ i++);
                s.displayInfo();
            }
    }
    @Override
    public Student search(int target) throws StudentNotFoundException{
        Student s = data.get(target);
        if(s == null)
            throw new StudentNotFoundException("Student not Found");
        return s;
    }
    @Override
    public void update(int original, int newid,String newname, String newcourse, int newage)
        throws StudentNotFoundException{
        Student s = search(original);
        data.remove(original);
        s.setId(newid);
        s.setName(newname);
        s.setCourse(newcourse);
        s.setAge(newage);
        data.put(newid,s);
    }

    @Override
    public void delete(int target) throws StudentNotFoundException{
        if(data.remove(target) == null)
            throw new StudentNotFoundException("Student not found");
    }
}
 