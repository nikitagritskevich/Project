package JavaException.exception;

public class EmptyStudentSubjectException extends Exception{
    public EmptyStudentSubjectException() {
    }

    public EmptyStudentSubjectException(String message) {
        super(message);
    }

    public EmptyStudentSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStudentSubjectException(Throwable cause) {
        super(cause);
    }
}
