package studentsystem;

public class StudentService implements StudentOperations{
    private Student[] data = new Student[10];
    private int count=0;

    @Override
    public boolean add(Student obj){
        if(count < 10){
            data[count] = obj;
            count++;
        }
        else{
            return false;
        }
        return true;   
    }
    @Override
    public boolean viewAll(){
        if(count == 0) return false;
        for(int i=0;i<count;i++){
            System.out.println("Student "+(i+1));
            data[i].displayInfo();
            
        }
        return true;
    }
    public Student search(int target){
        for(int i=0;i<count;i++){
            if(data[i].getId() == target){
                return data[i];
            }
        }
        return null;
    }
    public boolean update(int original, int newid,String newname, String newcourse, int newage){
        if(count == 0) return false;
        for(int i=0;i<count;i++){
            if(data[i].getId() == original){
                data[i].setId(newid);
                data[i].setName(newname);
                data[i].setCourse(newcourse);
                data[i].setAge(newage);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int target){
        if(count == 0) return false;
        int index=-1;
        for(int i=0;i<count;i++){
            if(data[i].getId() == target){
                index=i;
                break;
            }
        }
        if(index == -1) return false;
        for(int i=index;i<count-1;i++){
            data[i]=data[i+1];
        }
        data[count-1] = null;
        count--;
        return true;
    }
}
 