package JavaException.exception;

public class EmptyStudentGroupException extends Exception{
    public EmptyStudentGroupException() {
    }

    public EmptyStudentGroupException(String message) {
        super(message);
    }

    public EmptyStudentGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStudentGroupException(Throwable cause) {
        super(cause);
    }
}
