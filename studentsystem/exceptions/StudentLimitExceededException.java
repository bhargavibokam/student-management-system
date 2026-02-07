package studentsystem.exceptions;

public class StudentLimitExceededException extends Exception {
    public StudentLimitExceededException(String m){
        super(m);
    }
}
