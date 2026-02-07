package studentsystem;
 
import studentsystem.exceptions.StudentLimitExceededException;
import studentsystem.exceptions.StudentNotFoundException;

public class StudentService implements StudentOperations{
    private Student[] data = new Student[10];
    private int count=0;

    @Override
    public void add(Student obj) throws StudentLimitExceededException{
        if(count >= data.length){
            throw new StudentLimitExceededException("Student Limit reached!");
        }  
        data[count++] = obj;
    }
    @Override
    public void viewAll() throws StudentNotFoundException{
        if(count == 0) throw new StudentNotFoundException("students are not added!");
        for(int i=0;i<count;i++){
            System.out.println("Student "+(i+1));
            data[i].displayInfo();         
        }    
    }
    @Override
    public Student search(int target) throws StudentNotFoundException{
        for(int i=0;i<count;i++){
            if(data[i].getId() == target){
                return data[i];
            }
        }
        throw new StudentNotFoundException("Student not Found");
    }
    @Override
    public void update(int original, int newid,String newname, String newcourse, int newage)
        throws StudentNotFoundException{
        for(int i=0;i<count;i++){
            if(data[i].getId() == original){
                data[i].setId(newid);
                data[i].setName(newname);
                data[i].setCourse(newcourse);
                data[i].setAge(newage);
                data[i].displayInfo();
                return;
            }
        }
        throw new StudentNotFoundException("Student not Found To Update");
    }

    @Override
    public void delete(int target) throws StudentNotFoundException{
        int index=-1;
        for(int i=0;i<count;i++){
            if(data[i].getId() == target){
                index=i;
                break;
            }
        }
        if(index == -1) throw new StudentNotFoundException("Student not found to delete");
        for(int i=index;i<count-1;i++){
            data[i]=data[i+1];
        }
        data[count-1] = null;
        count--;
    }
}
 