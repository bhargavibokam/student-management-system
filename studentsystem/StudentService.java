package studentsystem;
import java.util.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import studentsystem.exceptions.StudentNotFoundException;

public class StudentService implements StudentOperations{
    private Map<Integer,Student> data = new HashMap<>();
    private static final String FILE_NAME = "students.ser";
    public StudentService(){
        loadFromFile();
    }
    @SuppressWarnings("unchecked") //Don’t show warning messages for unchecked type casting here. 
    //tells compiler : Yes, I know this cast is risky. Don’t warn me
    private void loadFromFile(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            data = (Map<Integer,Student>) ois.readObject();
        }
        catch(FileNotFoundException e){
            System.out.println("No existing data found.starting fresh");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void saveToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(data);
        }
        catch(IOException e){
            System.out.println("Error saving data");
            e.printStackTrace();
        }
    }
    @Override
    public void add(Student obj) {
        if(data.containsKey(obj.getId())){
            throw new IllegalArgumentException("Student Id already exixts");
        }
        data.put(obj.getId(),obj);
        saveToFile();
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
        saveToFile();
    }

    @Override
    public void delete(int target) throws StudentNotFoundException{
        if(data.remove(target) == null)
            throw new StudentNotFoundException("Student not found");
        saveToFile();
    }
    
}
 