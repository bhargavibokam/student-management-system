package studentsystem;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileStorageService {
    private static final String FILE_NAME = "students.ser";

    public void save(Map<Integer,Student> data){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(data);
        }
        catch(IOException e){
            System.out.println("Error saving data");
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked") //Don’t show warning messages for unchecked type casting here. 
    //tells compiler : Yes, I know this cast is risky. Don’t warn me
    public Map<Integer,Student> load(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            return (Map<Integer,Student>) ois.readObject();
        }
        catch(FileNotFoundException e){
            System.out.println("No existing data found.starting fresh");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new HashMap<>();
    }
     
}
